package vn.edu.nlu.entity;

import vn.edu.nlu.beans.*;
import vn.edu.nlu.db.ConnectDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProductEntity {
    //Total product number
    public static int getCountComment() {
        Statement s = null;
        int count=0;
        try {
            s = ConnectDB.connect();
            ResultSet rs = s.executeQuery("select COUNT(*)from binhluan");
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static void insertEvaluate(String idSP,String user, String star, String evalu) {

        Statement s = null;
        try {
            s = ConnectDB.connect();
            int id= getCountEvalu()+1;
            String sql="INSERT INTO danhgia (Username,MaSP,SoSao,NoiDung,NgayTao) VALUES " +
                    "(\""+user+"\",\""+idSP+"\",\""+star+"\",\""+evalu+"\","+"CURDATE()"+")" ;

            System.out.println(sql);
            s.executeUpdate(sql);
            s.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
    }

    private static int getCountEvalu() {
        Statement s = null;
        int count=0;
        try {
            s = ConnectDB.connect();
            ResultSet rs = s.executeQuery("select COUNT(*)from danhgia");
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void insertComment(String idSP, String user, String content) {

        Statement s = null;
        try {
            s = ConnectDB.connect();
            int id= getCountComment()+1;
            String sql="INSERT INTO binhluan (ID,MaSP,Username,NoiDung,NgayTao) VALUES " +
                    "("+id+",\""+idSP+"\",\""+user+"\",\""+content+"\","+"CURDATE()"+")" ;

            System.out.println(sql);
            s.executeUpdate(sql);
            s.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
    }

    public List<Product> getAll() {
        Statement s = null;
        try {
            s = ConnectDB.connect();
            ResultSet rs = s.executeQuery("select * from products");
            LinkedList<Product> list = new LinkedList<>();
            while (rs.next()) {
                list.add(new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
                ));
            }
            rs.close();
            s.close();
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new LinkedList<>();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new LinkedList<>();

        }

    }

    public int insertAll(Collection<Product> data) {
        Statement s = null;
        try {
            s = ConnectDB.connect();
            String sql = "INSERT INTO Products (id,name,image,price,priceSale) VALUES ";
            int i = 0;
            for (Product p : data) {

                if (++i < data.size())
                    sql += "(" + p.getId() + ",\"" + p.getName() + "\",\"" + p.getImg() + "\"," + p.getPrice() + "," + p.getPriceSale() + "),";
                else
                    sql += "(" + p.getId() + ",\"" + p.getName() + "\",\"" + p.getImg() + "\"," + p.getPrice() + "," + p.getPriceSale() + ")";
            }
            //System.out.println(sql);
            s.executeUpdate(sql);
            s.close();
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;

        }
    }

    public static Product getById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  " +
                    "    from product inner join gia on product.id = gia.masp " +
                    "    left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "    where gia.ngayketthuc is null and product.id= ?  ";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();
            Product p =null;
            if (rs.next()) {
                String id1 = rs.getString("ID");
                p = new Product(

                        id1,
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getDouble("Gia"),
                        rs.getDouble("GiaKM"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getString("MoTa"),
                        getCommentById(id1),
                        getEvaluateById(id1),
                        getConectorById(id1),
                        getCpuById(id1),
                        getMemoryById(id1),
                        getMonitorById(id1),
                        getOperatingById(id1),
                        getSizeById(id1),
                        getSoundById(id1),
                        getPinById(id1)

                );
            }
                rs.close();
                s.close();
                if (p==null) System.out.println("error");
                else System.out.println(p);
                return p;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }



    public static List<Comment> getCommentById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select * from binhluan where MaSP =?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            List<Comment> listCom = new ArrayList<>();
            while (rs.next())  {

                listCom.add(new Comment(
                        rs.getString(5),
                        rs.getString(4),
                        rs.getDate(6)

                ));}
                rs.close();
                s.close();
                return listCom;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    private static  Connector getConectorById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select congketnoi.* from congketnoi join product where congketnoi.ID = product.MaCongKetNoi and product.ID= ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            Connector con =null ;
            if (rs.next()) {
                con= new Connector(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)

                );
            }
            rs.close();
            s.close();
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    private  static  OperatingSys getOperatingById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select hedieuhanh.* from hedieuhanh join product where hedieuhanh.ID = product.MaHeDieuHanh and product.ID= ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            OperatingSys op =null ;
            if (rs.next()) {
                op= new OperatingSys(
                    rs.getString(2),
                    rs.getString(3)
                );
            }
            rs.close();
            s.close();
            return op;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    private static  Memory getMemoryById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select bonho.* from bonho join product where bonho.ID = product.MaBoNho and product.ID= ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            Memory con =null ;
            if (rs.next()) {
                con= new Memory(
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)

                );
            }
            rs.close();
            s.close();
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    private static  Size getSizeById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select kichthuoc.* from kichthuoc join product where kichthuoc.ID = product.MaKichThuoc and product.ID= ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            Size con =null ;
            if (rs.next()) {
                con= new Size(

                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getString(4)
                );
            }
            rs.close();
            s.close();
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    private  static Sound getSoundById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select dohoa_amthanh.* from dohoa_amthanh join product where dohoa_amthanh.ID = product.MaDoHoa and product.ID= ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            Sound con =null ;
            if (rs.next()) {
                con= new Sound(

                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
            }
            rs.close();
            s.close();
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }
    private  static Pin getPinById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select pin.* from pin join product where pin.ID = product.MaPin and product.ID= ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            Pin con =null ;
            if (rs.next()) {
                con= new Pin(

                        rs.getString(2),
                        rs.getString(3)
                );
            }
            rs.close();
            s.close();
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    private static  Monitor getMonitorById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select manhinh.* from manhinh join product where manhinh.ID = product.MaManHinh and product.ID= ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            Monitor con =null ;
            if (rs.next()) {
                con= new Monitor(

                        rs.getFloat(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
            rs.close();
            s.close();
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    private  static Cpu getCpuById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select cpu.* from cpu join product where cpu.ID = product.MaCPU and product.ID= ?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            Cpu con =null ;
            if (rs.next()) {
                con= new Cpu(


                        rs.getString(2),
                        rs.getString(3),
                        rs.getFloat(4),
                        rs.getFloat(5)
                );
            }
            rs.close();
            s.close();
            return con;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    public  static List<Evaluate> getEvaluateById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select * from danhgia where MaSP =?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();

            List<Evaluate> listEva = new ArrayList<>();
            while (rs.next())  {

                listEva.add(new Evaluate(
                        rs.getString(1),
                        rs.getString(4),
                        rs.getInt(3),
                        rs.getDate(5)
                ));}
            rs.close();
            s.close();
            return listEva;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }
    public static void a(String name){
        PreparedStatement s = null;
        try {
            String sql = "select * from products where name like ?";
            s = ConnectDB.connect(sql);
            s.setString(1, "%"+name+"%");
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                System.out.println("<tr><td>" +
                        rs.getString(1) + "</td><td>" +
                        rs.getString(2) + "</td><td>" +
                        rs.getString(3) + "</td><td>" +
                        rs.getInt(4) + "</td><td>" +
                        rs.getInt(5) + "</td></tr>"

                );
                rs.close();
                s.close();

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
    }
    public static void main(String[] args) {
        //a("a");
       // getById("BR271T");
        insertEvaluate("BR271T","NguyễnVănAnh","5","adasfsdf");
    }
}
