package vn.edu.nlu.model;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.database.ConnectDB;
import vn.edu.nlu.entity.ForgetPassEntity;
import vn.edu.nlu.entity.PasswordEntity;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class FogetPassMD {
    // kiểm tra email có nằm trong database không?
    public boolean checkEmail(String email) {
        return new ForgetPassEntity().emailInDatabase(email);
    }

    // Mã hóa MD5
    public String encrypt(String src) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String result = "";

        MessageDigest msd = MessageDigest.getInstance("MD5");
        byte[] srcTextBytes = src.getBytes("UTF-8");
        byte[] resultTextByte = msd.digest(srcTextBytes);

        BigInteger big = new BigInteger(1, resultTextByte);
        result = big.toString(16);

        return result;

    }

    public User getUser(String email) {
        return new ForgetPassEntity().getUser(email);

    }

    // inser key md5 vào
    public void insertMd5(String md5, String email) {
        new ForgetPassEntity().insertMd5(md5, email);
    }

    public void insertKeyTime(String email) {
        new ForgetPassEntity().insertKeyTime(email);

    }

    public boolean checkKey(String key) {
        return new ForgetPassEntity().checkKey(key);
    }

    public User getUserByKey(String key) {
        return new ForgetPassEntity().getUserByKey(key);
    }

    // kiểm tra 2 pass có giống nhau không
    public boolean samePass(String newPass, String rePass) {
        return newPass.equals(rePass);
    }

    // cập nhật lại pass mới cho username
    public void changePass(String passChange, String username) {
        new ForgetPassEntity().UpdatePassword(passChange, username);


    }

    // cập nhật lại key
    public void UpdateKey(String username, String emptyKey) {
        new ForgetPassEntity().UpdateKey(username, emptyKey);
    }

//    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
//        System.out.println(new FogetPassMD().encrypt("HOÀNG VI"));
//    }

}
