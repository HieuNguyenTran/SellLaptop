package vn.edu.nlu.beans;

public class Monitor {
    private float size;
    private String resolution;
    private String tech;
    private String touch;

    public Monitor() {
    }

    public Monitor(float size, String resolution, String tech, String touch) {
        this.size = size;
        this.resolution = resolution;
        this.tech = tech;
        this.touch = touch;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getTouch() {
        return touch;
    }

    public void setTouch(String touch) {
        this.touch = touch;
    }
}
