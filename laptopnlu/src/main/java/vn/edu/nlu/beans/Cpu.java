package vn.edu.nlu.beans;

public class Cpu {
    private String technology;
    private String type;
    private float speed;
    private float maxSpeed;

    public Cpu() {
    }

    public Cpu(String technology, String type, float speed, float maxSpeed) {
        this.technology = technology;
        this.type = type;
        this.speed = speed;
        this.maxSpeed = maxSpeed;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
