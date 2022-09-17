package vn.edu.nlu.beans;

public class Pin {
    private String type;
    private String info;

    public Pin() {
    }

    public Pin(String type, String info) {
        this.type = type;
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
