package data_access;

import data_access.todolist.ToDoListDataAccessInterface;
import entities.todo_list.CommonToDoListFactory;
import entities.todo_list.ToDoList;
import exceptions.InvalidToDoListConfigException;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryToDoListDataAccessObject implements ToDoListDataAccessInterface {
    private final Map<String, Integer> fileIndex = new LinkedHashMap<>();
    private final Map<Integer, ToDoList> tdlStorage = new HashMap<>();
    private final File tdlFile;

    public InMemoryToDoListDataAccessObject(String filePath) throws InvalidToDoListConfigException, IOException {
        tdlFile = new File(filePath);

        // Assign indices to different columns in the user data file.
        fileIndex.put("ID", 0);
        fileIndex.put("name", 1);
        fileIndex.put("detail", 2);

        // If the user file is empty, create and save it; otherwise, read and populate the user accounts.
        if (tdlFile.length() == 0) {
            save();
        } else {
            // Read user data from the file and populate the accounts map.
            // Validate the file header and the number of columns in each row.
            try (BufferedReader reader = new BufferedReader(new FileReader(tdlFile))) {
                String header = reader.readLine();
                if (!header.equals("ID,name,detail")) {
                    throw new InvalidToDoListConfigException("ID,name,detail", header);
                }
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split("\\|");
                    if (col.length != 3) {
                        throw new InvalidToDoListConfigException(row);
                    }
                    int ID = Integer.parseInt(col[fileIndex.get("ID")]);
                    String name = String.valueOf(col[fileIndex.get("name")]);
                    String detail = String.valueOf(col[fileIndex.get("detail")]);
                    ToDoList toDoList = CommonToDoListFactory.create(
                            ID, name, detail);
                    tdlStorage.put(ID, toDoList);
                }
            }
        }
    }

    /**
     * Save the provided ToDoPanel to the DB.
     * when implementing, it will call method save() to persist the changes.
     *
     * @param toDoList the organized entity that is going to store.
     */
    @Override
    public void save(ToDoList toDoList) {
        tdlStorage.put(toDoList.getID(), toDoList);
        this.save();
    }

    /**
     * Verify if this ToDoPanel is already exists.
     *
     * @param tdlName the name of the ToDoPanel
     * @return ture or false
     */
    @Override
    public boolean exists(String tdlName) {
        for (ToDoList toDoList : tdlStorage.values()) {
            if (toDoList.getName().equals(tdlName)) {
                return true;
            }
        }
        return false;
    }

    // Writes the user data from the accounts map to the user file.
    public void save() {
        // Write the header and user data to the file.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tdlFile))) {

            writer.write(String.join(",", fileIndex.keySet()));
            writer.newLine();

            for (ToDoList toDoList : tdlStorage.values()) {
                String line = String.format("%s|%s|%s",
                        toDoList.getID(), toDoList.getName(), toDoList.getDetail());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
