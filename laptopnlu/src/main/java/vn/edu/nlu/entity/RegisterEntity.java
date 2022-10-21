package vn.edu.nlu.entity;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.database.ConnectDB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class RegisterEntity {
    // lấy ra các user đã có trong csdl để check
    public static Map<String, User> getAll() {
        Map<String, User> map = new HashMap<String, User>();
        String sql = "select * from user";
        try {
            PreparedStatement pre = ConnectDB.connect(sql);
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
                map.put(username, new User(username, password, address, state, name, phone,
                        email, type, sex, dob, createdDate, avatar, key, keyTime));
            }
            pre.close();
            rs.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    //kiểm tra đã có trong database chưa?
    public static boolean isExist(String username) {
        String sql = "select Username from user where Username = ?";
        boolean result = false;
        try {
            PreparedStatement pre = ConnectDB.connect(sql);
            pre.setString(1, username);
            ResultSet rs = pre.executeQuery();
            result = (rs.next()) ? true : false;
            rs.close();
            pre.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;

    }

    // thêm user mới đăng ký vào database
    public static void insertCustomer(User user) {
        String sql = "INSERT INTO user(Username, Password, Name, Phone, Email, Address,Sex, Dob,Type) VALUES (?,?,?,?,?,?,?,?,?)";
//        sql = "INSERT INTO user(Username, Password, Name, Phone, Email, Address,Sex, Dob) VALUES (" + "\"" + user.getUsername() + "\",\"" + user.getPassword() + "\",\""
//                + user.getName() + "\",\"" + user.getPhone() + "\",\"" + user.getEmail()
//                + "\",\"" + user.getAddress() + "\",\"" + user.getSex() + "\",\"" + user.getDob() + "\")";

        PreparedStatement ps = null;
        try {

            ps = ConnectDB.connect(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getAddress());
            ps.setString(7, user.getSex());
            ps.setDate(8, new Date(user.getDob().getTime()));
            ps.setString(9,"Customer");
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // thêm admin vào database
    public static void insertAdmin(User userAmin) {
        String sql = "INSERT INTO user (Username, Password, Email, Phone, Address, Avatar, Type) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = ConnectDB.connect(sql);
            ps.setString(1, userAmin.getUsername());
            ps.setString(2, userAmin.getPassword());
            ps.setString(3, userAmin.getEmail());
            ps.setString(4, userAmin.getPhone());
            ps.setString(5, userAmin.getAddress());
            ps.setString(6, userAmin.getAvatar());
            ps.setString(7, userAmin.getType());
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }
    }

}