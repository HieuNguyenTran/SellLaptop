package vn.edu.nlu.db;

import java.sql.*;

public class ConnectDB {
    static Connection con;
    public static Statement connect() throws ClassNotFoundException, SQLException {
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laptop1?useUnicode=true&characterEncoding=utf-8", "root", "");
            return con.createStatement();
        } else {
            return con.createStatement();
        }

    }
    public static PreparedStatement connect(String sql) throws ClassNotFoundException, SQLException {
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/laptop1?useUnicode=true&characterEncoding=utf-8", "root", "");
            return con.prepareStatement(sql);
        } else {
            return con.prepareStatement(sql);
        }

    }

}