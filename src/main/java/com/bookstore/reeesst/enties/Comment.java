package com.bookstore.reeesst.enties;

public class Comment {

    private User user;
    private String content;
    private Mark mark;

    public Comment(User user, String content, Mark mark) {
        this.user = user;
        this.content = content;
        this.mark = mark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
