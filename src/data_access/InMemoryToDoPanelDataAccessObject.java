package data_access;

import data_access.todopanel.ToDoPanelDataAccessInterface;
import entities.todo.ToDo;
import entities.todo_list.CommonToDoListFactory;
import entities.todo_list.ToDoList;
import entities.todo_panel.ToDoPanel;
import exceptions.InvalidToDoPanelConfigException;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryToDoPanelDataAccessObject implements ToDoPanelDataAccessInterface {
    private final File tdlFile;
    private final Map<String, Integer> fileIndex = new LinkedHashMap<>();
    private final Map<Integer, ToDoPanel> tdpStorage = new HashMap<>();

    public InMemoryToDoPanelDataAccessObject(String filePath) throws InvalidToDoPanelConfigException, IOException {
        tdlFile = new File(filePath); // read data from a file / create a new file if it doesn't exist.
        fileIndex.put("ID", 0); // current we just find ID to pass
        fileIndex.put("Lists", 1);
        if (tdlFile.length() == 0) {
            save();
        } else { // Read user data from the file and populate the accounts map. Validate the file header & n of column.
            try (BufferedReader reader = new BufferedReader(new FileReader(tdlFile))) {
                String header = reader.readLine();
                if (!header.equals("ID,name,detail,toDos")) {
                    throw new InvalidToDoPanelConfigException("ID,name,detail,toDos", header);
                }
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split("\\|");
                    if (col.length != 3) {
                        throw new InvalidToDoPanelConfigException(row);
                    }
                    int ID = Integer.parseInt(col[fileIndex.get("ID")]);
                    String name = String.valueOf(col[fileIndex.get("name")]);
                    ToDo toDos = ToDo.parse(
                            String.valueOf(col[fileIndex.get("toDos")]));
                    ToDoList toDoList = CommonToDoListFactory.create(ID);
                    tdpStorage.put(ID, toDoPanel);
                }
            }
        }
    }

    /**
     * Verify if this ToDoPanel is already exists.
     * @param tdpName the name of the ToDoPanel
     * @return ture or false
     */
    @Override
    public boolean exists(String tdpName) {
        for (ToDoPanel toDoPanel : tdpStorage.values()) {
            if (toDoPanel.getName().equals(tdpName)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Save the provided ToDoPanel to the DB.
     * when implementing, it will call method save() to persist the changes.
     *
     * @param toDoPanel the organized entity that is going to store.
     */
    @Override
    public void save(ToDoPanel toDoPanel) {

    }
}
