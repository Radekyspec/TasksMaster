package use_case.message_board.message;

import entities.user.User;

public record MessageInputData(int projectID, int messageID, User user, String newComment) {
}
