package entities.message;

import entities.user.User;

public class CommonMessageFactory {
    /**
     * build up the CommonMessage object
     *
     * @param ID      the ID of message
     * @param author  the author of message
     * @param title  the tittle of message
     * @param content the content of message
     */
    public static CommonMessage create(long ID, String author, String title, String content) {
        return new CommonMessage(ID, author, title, content);
    }
}
