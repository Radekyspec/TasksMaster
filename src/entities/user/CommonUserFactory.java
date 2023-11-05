package entities.user;

import java.time.LocalDateTime;

public class CommonUserFactory {
    public static User create(int ID, String name, String password, LocalDateTime createDateTime, String email) {
        return new CommonUser(ID, name, password, createDateTime, email);
    }
}
