package vn.edu.nlu.entity;

import vn.edu.nlu.beans.MyImage;
import vn.edu.nlu.database.ConnectDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageEntity {

    // hàm lấy ảnh slider/ banner để đổ vào trang chủ index.jsp
    public static List<MyImage> getHomepageImg(String type) {
        try {
            String sql = "SELECT DuongDan FROM anh WHERE Loai = ?";
            PreparedStatement pre = ConnectDB.connect(sql);
            pre.setString(1, (type.equals("slider") ? "slider_show" : "banner_show"));
            ResultSet rs = pre.executeQuery();
            List<MyImage> re = new ArrayList<>();
            while (rs.next())
                re.add(new MyImage(rs.getString(1)));
            rs.close();
            pre.close();
            return re;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return new ArrayList<MyImage>();
        }
    }


}
