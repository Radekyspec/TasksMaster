package use_case.message_board;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.comment.Comment;
import entities.comment.CommonCommentFactory;
import entities.message.CommonMessageFactory;
import entities.message.Message;
import entities.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageBoardInteractorTest {
    private MessageBoardUserDataAccessInterface userDAO;
    private MessageBoardOutputBoundary presenter;

    @BeforeEach
    void setUp() {
        userDAO = new MessageBoardUserDataAccessInterface() {
            @Override
            public List<Message> getMessages(long projectID, long messageBoardID) {
                if (messageBoardID == 0L) {
                    return null;
                }
                List<Message> messages = new ArrayList<>();
                messages.add(CommonMessageFactory.create(0, "author", "title", "content"));
                return messages;
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
                if (messageBoardID == 0) {
                    return null;
                }
                return CommonMessageFactory.create(0, author.getName(), messageTitle, messageContent);
            }
        };
        presenter = new MessageBoardOutputBoundary() {
            @Override
            public void prepareGetMessagesSuccessView(MessageBoardOutputData messageBoardOutputData) {
                assertEquals(1, messageBoardOutputData.getMessages().size());
            }

            @Override
            public void prepareGetMessageFailView() {

            }
        };
    }

    @Test
    void getMessages() {
        MessageBoardInputBoundary interactor = new MessageBoardInteractor(userDAO, presenter);
        interactor.getMessages(new MessageBoardInputData(0, 123));
        interactor.getMessages(new MessageBoardInputData(0, 0));
    }
}