package vn.edu.nlu.beans;

import java.io.Serializable;

public class MyImage implements Serializable {
    private String maAnh;
    private String maSP;
    private String loai;
    private String url;

    public MyImage(){}

    public MyImage(String url) {
        this.url = url;
    }

    // getters & setters

    public String getMaAnh() {
        return maAnh;
    }

    public void setMaAnh(String maAnh) {
        this.maAnh = maAnh;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
