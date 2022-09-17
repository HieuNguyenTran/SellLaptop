package vn.edu.nlu.beans;

import java.util.Date;
import java.util.List;

public class Comment {
    private String content;
    private String user;
    private Date date;

    public Comment() {
    }

    public Comment(String content, String user, Date date) {
        this.content = content;
        this.user = user;
        this.date = date;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
