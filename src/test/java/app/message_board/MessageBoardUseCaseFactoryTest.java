package app.message_board;

import data_access.message_board.MessageBoardUserDataAccessInterface;
import entities.comment.Comment;
import entities.message.Message;
import entities.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.message_board.MessageBoardViewModel;
import interface_adapter.message_board.add_new_message.AddNewMessageViewModel;
import interface_adapter.message_board.message.MessageViewModel;
import interface_adapter.project.MainProjectViewModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MessageBoardUseCaseFactoryTest {

    @Test
    void create() {
        assertNotNull(MessageBoardUseCaseFactory.create(
                new ViewManagerModel(),
                new MainProjectViewModel(),
                new MessageBoardViewModel(),
                new AddNewMessageViewModel(),
                new MessageViewModel(),
                new MessageBoardUserDataAccessInterface() {
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
                        return null;
                    }

                    @Override
                    public Message addMessage(long projectID, long messageBoardID, User author, String messageTitle, String messageContent) {
                        return null;
                    }
                }
        ));
    }

    @Test
    void createController() {
        assertNotNull(MessageBoardUseCaseFactory.createController(
                new MessageBoardViewModel(),
                new MessageBoardUserDataAccessInterface() {
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
                        return null;
                    }

                    @Override
                    public Message addMessage(long projectID, long messageBoardID, User author, String messageTitle, String messageContent) {
                        return null;
                    }
                }
        ));
    }
}