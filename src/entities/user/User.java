package entities.user;

import java.time.LocalDateTime;

public interface User {
    int getID();
    String getName();

    String getPassword();

    LocalDateTime getCreationTime();

    String getEmail();
    void setRule();
}
