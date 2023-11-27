package entities.message_board;

public class CommonMessageBoardFactory {
    /**
     * create a new MessageBoard which containing many massage
     *
     * @param ID the ID of the messageBoard
     * @return return a new messageBoard that we build
     */
    public static CommonMessageBoard create(int ID) {
        return new CommonMessageBoard(ID);
    }
}
