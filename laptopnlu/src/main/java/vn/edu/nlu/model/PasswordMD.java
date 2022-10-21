package vn.edu.nlu.model;

import vn.edu.nlu.entity.PasswordEntity;

public class PasswordMD {
    public  boolean samePass(String newPass, String rePass){
        return newPass.equals(rePass);
    }
    public  void changePass(String passChange, String username){
        new PasswordEntity().UpdatePassword(passChange,username);
    }
}
