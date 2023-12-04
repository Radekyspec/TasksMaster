package use_case.message_board.message;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.comment.Comment;
import entities.comment.CommonCommentFactory;
import entities.message.Message;
import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageInteractorTest {
    private MessageBoardUserDataAccessInterface userDAO;
    private MessageOutputBoundary presenter;
    private User user;
    private MessageInputBoundary interactor;

    @BeforeEach
    void setUp() {
        user = CommonUserFactory.create(
                0, "Radeky", "Aa1", LocalDateTime.now(), "1@a.a"
        );
        userDAO = new MessageBoardUserDataAccessInterface() {
            @Override
            public List<Message> getMessages(long projectID, long messageBoardID) {
                return null;
            }

            @Override
            public List<Comment> getComments(long projectID, long messageID) {
                if (messageID == 0) {
                    return null;
                }
                List<Comment> comments = new ArrayList<>();
                comments.add(CommonCommentFactory.create(
                        0, "author", "content"
                ));
                return comments;
            }

            @Override
            public Comment addComment(long projectID, long messageID, User user, String newComment) {
                if (messageID == 0) {
                    return null;
                }
                return CommonCommentFactory.create(
                        0, user.getName(), newComment
                );
            }

            @Override
            public Message addMessage(long projectID, long messageBoardID, User author, String messageTitle, String messageContent) {
                return null;
            }
        };
        presenter = new MessageOutputBoundary() {
            @Override
            public void prepareGetCommentsSuccessView(MessageOutputData messageOutputData) {
                assertEquals(1, messageOutputData.getComments().size());
            }

            @Override
            public void prepareGetCommentsFailView() {

            }

            @Override
            public void prepareAddCommentsFailView() {

            }
        };
        interactor = new MessageInteractor(userDAO, presenter);
    }

    @Test
    void getComments() {
        interactor.getComments(new MessageInputData(0, 0, user, "comment"));
        interactor.getComments(new MessageInputData(0, 123, user, "comment"));
    }

    @Test
    void addComments() {
        interactor.addComments(new MessageInputData(0, 123, user, "comment"));
        interactor.addComments(new MessageInputData(0, 0, user, "comment"));
    }
}