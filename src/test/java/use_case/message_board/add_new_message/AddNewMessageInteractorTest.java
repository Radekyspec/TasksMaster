package use_case.message_board.add_new_message;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.comment.Comment;
import entities.comment.CommonCommentFactory;
import entities.message.CommonMessageFactory;
import entities.message.Message;
import entities.user.CommonUserFactory;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddNewMessageInteractorTest {
    private AddNewMessageOutputBoundary presenter;
    private MessageBoardUserDataAccessInterface userDAO;
    private AddNewMessageInputBoundary interactor;
    private User user;

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
                return null;
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
                if (messageBoardID == 0) {
                    return null;
                }
                return CommonMessageFactory.create(
                        0, author.getName(), messageTitle, messageContent
                );
            }
        };
        presenter = new AddNewMessageOutputBoundary() {
            @Override
            public void prepareSuccessView(AddNewMessageOutputData addNewMessageOutputData) {
                assertEquals(user.getName(), addNewMessageOutputData.getMessage().getAuthor());
                assertEquals("title", addNewMessageOutputData.getMessage().getTitle());
            }

            @Override
            public void prepareFailView() {

            }
        };
    }

    @Test
    void postMessage() {
        interactor = new AddNewMessageInteractor(userDAO, presenter);
        interactor.postMessage(new AddNewMessageInputData(0, 123, user, "title", "content"));
        interactor.postMessage(new AddNewMessageInputData(0, 0, user, "title", "content"));
    }
}