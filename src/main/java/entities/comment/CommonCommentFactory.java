package entities.comment;

import entities.user.User;

public class CommonCommentFactory {
    /**
     * create up the new comment with user
     *
     * @param ID      the ID of the comment
     * @param author  the author of the comment
     * @param content the content of the comment
     */
    public static CommonComment create(int ID, User author, String content) {
        return new CommonComment(ID, author, content);
    }
}
