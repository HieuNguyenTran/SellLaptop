package vn.edu.nlu.entity;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.database.ConnectDB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginEntity {
    // kiểm tra đăng nhập
    public static boolean checkLogin(String username, String password) {
        String sql = "Select  * from user where Username=?";
        PreparedStatement pre = null;
        try {

            pre = ConnectDB.connect(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                if (rs.getString(1).equals(username) && rs.getString(2).equals(password))
                    return true;
            }
            pre.close();
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // lấy thông tin của user qua username
    public static User getInformationOfUser(String uname){
        String sql = "Select  * from user where Username="+"\""+ uname+"\"";
        PreparedStatement pre = null;
        try {
            pre = ConnectDB.connect(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String username = rs.getString(1);
                String password = rs.getString(2);
                String address = rs.getString(3);
                String state = rs.getString(4);
                String name = rs.getString(5);
                String phone = rs.getString(6);
                String email = rs.getString(7);
                String type = rs.getString(8);
                String sex = rs.getString(9);
                Date dob = rs.getDate(10);
                Date createdDate = rs.getDate(11);
                String avatar = rs.getString(12);
                String key = rs.getString(13);
                Date keyTime = rs.getDate(14);
                return new User(username, password, address, state, name, phone,
                        email, type, sex, dob, createdDate, avatar, key, keyTime);
            }
            pre.close();
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;

    }
    //test
//    public static void main(String[] args) {
//        LoginEntity l = new LoginEntity();
//        System.out.print(getInformationOfUser("Vi Vi"));
//    }

}
