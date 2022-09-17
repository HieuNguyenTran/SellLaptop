package vn.edu.nlu.beans;

import java.util.Date;

public class Evaluate {
    private String user;
    private String content;
    private int star;
    private Date date;

    public Evaluate() {
    }

    public Evaluate(String user, String content, int star, Date date) {
        this.user = user;
        this.content = content;
        this.star = star;
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
