package vn.edu.nlu.entity;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.database.ConnectDB;


import java.sql.*;
import java.util.Calendar;

public class ForgetPassEntity {

    // inser key md5 vào
    public void insertMd5(String md5, String email) {
        String sql = "Update user set `Key`=? where Email=?";
        PreparedStatement ps = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setString(1, md5);
            ps.setString(2, email);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void insertKeyTime(String email) {

        String sql = "Update user set KeyTime=? where Email=?";
        PreparedStatement ps = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setTimestamp(1, new Timestamp(Calendar.getInstance().getTimeInMillis()));
            ps.setString(2, email);
            ps.executeUpdate();
            ps.close();
            System.out.println("Done insert keytime");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    // kiểm tra email có trong database hay không
    public boolean emailInDatabase(String email) {
        boolean result = false;
        String sql = "Select * from user where Email=?";
        PreparedStatement ps = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setString(1, email);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                result = true;
                break;
            }
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    // kiểm tra key có trong database hay không
    public boolean checkKey(String key) {
        boolean result = false;
        String sql = "Select KeyTime from user where `Key`=?";
        PreparedStatement ps = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setString(1, key);
            ResultSet re = ps.executeQuery();
            if (re.next()) {
                Timestamp keytime = re.getTimestamp(1);
                long current = System.currentTimeMillis();
                System.out.println(keytime.getTime());
                System.out.println(current);
                long time = current - keytime.getTime();
                System.out.println(time);
                if (time <= 24 * 60 * 60 * 1000) {
                    result = true;
                }

            }
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    // lay thong tin user
    public User getUser(String email) {
        String sql = "Select Username, Password from user where Email=?";
        PreparedStatement ps = null;
        User u = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setString(1, email);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                u = new User(re.getString(1), re.getString(2));
            }
            re.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return u;
    }

    // lay thong tin user qua key
    public User getUserByKey(String key) {
        String sql = "Select Username, Password from user where `Key`=?";
        PreparedStatement ps = null;
        User u = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setString(1, key);
            ResultSet re = ps.executeQuery();
            while (re.next()) {
                u = new User(re.getString(1), re.getString(2));
            }
            re.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return u;
    }

    // thay đổi pass của một username trong database
    public void UpdatePassword(String passChange, String username) {
        String sql = "Update  user set Password=? where Username=?";
        PreparedStatement ps = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setString(1,passChange);
            ps.setString(2, username);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // cập nhật lại key
    public void UpdateKey(String username, String emptyKey) {
        String sql = "Update  user set `Key`=? where Username=?";
        PreparedStatement ps = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setString(1,emptyKey);
            ps.setString(2,username);

            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        new ForgetPassEntity().insertMd5("ac", "thoangvi.it@gmail.com");
      //  System.out.println(new ForgetPassEntity().checkKey("aa5e3daa0c1f42cfa09f63d9ba405be1"));
       // System.out.println(System.currentTimeMillis()- 24 * 60 * 60 * 1000);


    }

}
