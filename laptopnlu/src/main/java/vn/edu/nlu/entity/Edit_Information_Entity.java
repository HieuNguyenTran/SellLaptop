package vn.edu.nlu.entity;

import vn.edu.nlu.beans.User;
import vn.edu.nlu.database.ConnectDB;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Edit_Information_Entity {
    // thay đổi thông tin của  producer
    public void UpdateUser(User userChange, String username) {
        String sql = "Update  user set Name=? , Phone= ?,   Email=?, Address=?, Dob=?, Sex=? where Username=?";
        PreparedStatement ps = null;
        try {
            ps = ConnectDB.connect(sql);

            ps.setString(1, userChange.getName());
            ps.setString(2, userChange.getPhone());
            ps.setString(3, userChange.getEmail());
            ps.setString(4, userChange.getAddress());
            ps.setDate(5, (Date) userChange.getDob());
            ps.setString(6, userChange.getSex());
            ps.setString(7, username);
            ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
