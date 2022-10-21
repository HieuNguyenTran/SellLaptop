package vn.edu.nlu.model;

import vn.edu.nlu.beans.Product;
import vn.edu.nlu.beans.User;
import vn.edu.nlu.database.ConnectDB;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Cart implements Serializable {
  /*  private String uname;
    private Map<String, Product> map = new HashMap<>();

    public Cart() {
    }

    public Cart(String uname) {
        this.uname = uname;
    }

    public void put(Product p) {
        if (p == null) return;
        if (map.containsKey(p.getId())) {
            map.get(p.getId()).add();
            return;
        }
//        p.setQuantityInCart(1);
        map.put(p.getId(), p);
    }

    public void add(Product p) {
        if (p == null) return;
        String id = p.getId();
        if (map.containsKey(id)) {
            Product old = map.get(id);
         //   old.setQuantityInCart(old.getQuantityInCart() + p.getQuantityInCart());
            map.put(id, old);
        } else
            map.put(id, p);
    }

    public Product get(String id) {
        return map.get(id);
    }

    public void update(String id, int quantity) {
        if (quantity < 1) return;
      //  if (map.containsKey(id)) map.get(id).setQuantityInCart(quantity);
    }

    public Product remove(String id) {
        return map.remove(id);
    }

    public void removeAll() {
        map.clear();
    }

    public long total() {
        long sum = 0;
        for (Product p : map.values()) sum += p.getPricesale() * p.getQuantityInCart();
        return sum;
    }

    public int quantity() {
        int re = 0;
        for (Product p : map.values()) re += p.getQuantityInCart();
        return re;
    }

    public static Cart getCart(HttpSession session) {
        User user = (User) session.getAttribute("USER");
        if (user == null)
            return new Cart("NULL");

        Cart c = (Cart) session.getAttribute("cart");
        if (c == null)
            c = getCart(user.getUsername());

        return c;

    }

    public static Cart getCart(String uname) {
        try {
            String sql = "SELECT * FROM v_cart WHERE Username = ?";
            PreparedStatement pre = ConnectDB.connect(sql);
            pre.setString(1, uname);
            ResultSet rs = pre.executeQuery();
            Cart c = new Cart(uname);
            while (rs.next())
                c.put(new Product(rs.getString("MaSP"),
                        rs.getString("Ten"),
                        rs.getLong("Gia"),
                        rs.getString("MainImg"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoLuong")
                ));
            rs.close();
            pre.close();
            return c;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void commit(HttpSession session) {
        session.setAttribute("cart", this);
    }

    public List<Product> list() {
        return new ArrayList<>(map.values());
    }

    public void save() {
        Collection<Product> list = map.values();
        try {
            int ID = -1;
            PreparedStatement pre = ConnectDB.connect("SELECT ID FROM cart WHERE Username = ?");
            pre.setString(1, uname);
            ResultSet rs = pre.executeQuery();
            if (rs.next())
                ID = rs.getInt(1);
            rs.close();
            pre.close();

            if (ID > -1) {
                pre = ConnectDB.connect("DELETE FROM cart_detail WHERE ID = ?");
                pre.setInt(1, ID);
                pre.executeUpdate();
                pre.close();
                if(list.size() == 0)
                    return;

            } else {
                if(list.size() == 0)
                    return;

                pre = ConnectDB.connect("INSERT INTO cart (Username) VALUES (?)");
                pre.setString(1, uname);
                pre.executeUpdate();
                pre.close();

                pre = ConnectDB.connect("SELECT ID FROM cart WHERE Username = ?");
                pre.setString(1, uname);
                rs = pre.executeQuery();
                if (rs.next())
                    ID = rs.getInt(1);
                rs.close();
                pre.close();
            }

            pre = ConnectDB.connect("INSERT INTO cart_detail (ID, MaSP, SoLuong) VALUES (?,?,?)");
            for (Product p : list) {
                pre.setInt(1, ID);
                pre.setString(2, p.getId());
                pre.setInt(3, p.getQuantityInCart());
                pre.executeUpdate();
            }
            pre.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Map<String, Product> getMap() {
        return map;
    }

    public void setMap(Map<String, Product> map) {
        this.map = map;
    }

   */
}
