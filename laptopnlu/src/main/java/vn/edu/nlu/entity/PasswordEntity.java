package vn.edu.nlu.entity;



import vn.edu.nlu.database.ConnectDB;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PasswordEntity {
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

//    public static void main(String[] args) {
//       new PasswordEntity().UpdatePassword("123", "Tu");
//    }
}
