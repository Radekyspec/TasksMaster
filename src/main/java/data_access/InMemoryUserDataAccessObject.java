package data_access;

import entities.user.CommonUserFactory;
import entities.user.User;
import exceptions.InvalidApiKeyException;
import exceptions.InvalidUserConfigException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject extends HttpDataAccessObject {
    private final Map<String, Integer> fileIndex = new LinkedHashMap<>();
    private final Map<String, User> accounts = new HashMap<>();
    private final File userFile;

    public InMemoryUserDataAccessObject(String apiKey, String filePath) throws
            InvalidApiKeyException, InvalidUserConfigException, IOException {
        super(apiKey);

        userFile = new File(filePath);
        fileIndex.put("ID", 0);
        fileIndex.put("username", 1);
        fileIndex.put("password", 2);
        fileIndex.put("createDateTime", 3);
        fileIndex.put("email", 4);
        if (userFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
                String header = reader.readLine();
                if (!header.equals("ID,username,password,createDateTime,email")) {
                    throw new InvalidUserConfigException("ID,username,password,createDateTime,email", header);
                }
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split("\\|");
                    if (col.length != 5) {
                        throw new InvalidUserConfigException(row);
                    }
                    int ID = Integer.parseInt(col[fileIndex.get("ID")]);
                    String username = String.valueOf(col[fileIndex.get("username")]);
                    String password = String.valueOf(col[fileIndex.get("password")]);
                    LocalDateTime creationDateTime = LocalDateTime.parse(
                            String.valueOf(col[fileIndex.get("createDateTime")]));
                    String email = String.valueOf(col[fileIndex.get("email")]);
                    User user = CommonUserFactory.create(
                            ID, username, password, creationDateTime, email);
                    accounts.put(username, user);
                }
            }
        }
    }

    @Override
    public boolean exists(String username) {
        return accounts.containsKey(username);
    }

    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {

            writer.write(String.join(",", fileIndex.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s|%s|%s|%s|%s",
                        user.getID(), user.getName(), user.getPassword(), user.getCreationTime(), user.getEmail());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User login(String username, String password) {
        if (username.isEmpty() || password.isEmpty() || !accounts.containsKey(username)) {
            return null;
        }
        if (accounts.get(username).getPassword().equals(password)) {
            return accounts.get(username);
        }
        return null;
    }
}
