package vn.edu.nlu.beans;

public class Memory {
    private int ram;
    private String typeRam;
    private int speed;
    private String maxRam;
    private String hardDisk;

    public Memory() {
    }

    public Memory(int ram, String typeRam, int speed, String maxRam, String hardDisk) {
        this.ram = ram;
        this.typeRam = typeRam;
        this.speed = speed;
        this.maxRam = maxRam;
        this.hardDisk = hardDisk;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getTypeRam() {
        return typeRam;
    }

    public void setTypeRam(String typeRam) {
        this.typeRam = typeRam;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getMaxRam() {
        return maxRam;
    }

    public void setMaxRam(String maxRam) {
        this.maxRam = maxRam;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }
}
