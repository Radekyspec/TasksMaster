package use_case.message_board.message;

import entities.user.User;

public record MessageInputData(long projectID, long messageID, User user, String newComment) {
}
