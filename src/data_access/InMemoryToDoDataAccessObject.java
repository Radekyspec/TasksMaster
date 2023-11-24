package data_access;

import data_access.todo.ToDoDataAccessInterface;
import entities.todo.CommonToDoFactory;
import entities.todo.ToDo;
import exceptions.InvalidToDoConfigException;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryToDoDataAccessObject implements ToDoDataAccessInterface {
    private final File toDoFile;
    private final Map<String, Integer> fileIndex = new LinkedHashMap<>();
    private final Map<Integer, ToDo> toDoStorage = new HashMap<>();

    public InMemoryToDoDataAccessObject(String filePath) throws InvalidToDoConfigException, IOException {
        toDoFile = new File(filePath);

        // Assign indices to different columns in the user data file.
        fileIndex.put("ID", 0);
        fileIndex.put("target", 1);
        fileIndex.put("assignedTo", 2);

        // If the user file is empty, create and save it; otherwise, read and populate the user accounts.
        if (toDoFile.length() == 0) {
            save();
        } else {
            // Read user data from the file and populate the accounts map.
            // Validate the file header and the number of columns in each row.
            try (BufferedReader reader = new BufferedReader(new FileReader(toDoFile))) {
                String header = reader.readLine();
                if (!header.equals("ID,target,assignedTo")) {
                    throw new InvalidToDoConfigException("ID,target,assignedTo", header);
                }
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split("\\|");
                    if (col.length != 3) {
                        throw new InvalidToDoConfigException(row);
                    }
                    int ID = Integer.parseInt(col[fileIndex.get("ID")]);
                    String target = String.valueOf(col[fileIndex.get("target")]);
                    String[] assignedTo = String[].valueOf(col[fileIndex.get("assignedTo")]);
                    ToDo toDo = CommonToDoFactory.create(
                            ID, target, assignedTo);
                    toDoStorage.put(ID, toDo);
                }
            }
        }
    }

    /**
     * Save the provided ToDoPanel to the DB.
     * when implementing, it will call method save() to persist the changes.
     *
     * @param toDo the organized entity that is going to store.
     */
    @Override
    public void save(ToDo toDo) {
        toDoStorage.put(toDo.getID(), toDo);
        this.save();
    }

    // Writes the user data from the accounts map to the user file.
    public void save() {
        // Write the header and user data to the file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toDoFile))) {

            writer.write(String.join(",", fileIndex.keySet()));
            writer.newLine();

            for (ToDo toDo : toDoStorage.values()) {
                String line = String.format("%s|%s|%s",
                        toDo.getID(), toDo.getTarget(), toDo.getAssignedTo());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
