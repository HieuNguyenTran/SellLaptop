package vn.edu.nlu.entity;

import vn.edu.nlu.beans.Product;
import vn.edu.nlu.db.ConnectDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class ProductListEntity {
    public List<Product> getAll() {
        Statement s = null;
        try {
            s = ConnectDB.connect();
            ResultSet rs = s.executeQuery("select * from product");
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
            String sql = "INSERT INTO Product (id,name,image,price,priceSale) VALUES ";
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

    public Product getById(String id) {
        PreparedStatement s = null;
        try {
            String sql = "select * from product where id =?";
            s = ConnectDB.connect(sql);
            s.setString(1, id);
            ResultSet rs = s.executeQuery();
            Product p;
            if (rs.next()) {
                p = new Product(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)

                );
                rs.close();
                s.close();
                return p;
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;

        }
    }

    public static void a(String name) {
        PreparedStatement s = null;
        try {
            String sql = "select * from product where name like ?";
            s = ConnectDB.connect(sql);
            s.setString(1, "%" + name + "%");
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
    //function bổ trợ để lấy tên ổ cúng và kích thước trong db
    public static String splitString(String s){
        String result="";
        StringTokenizer tokenizer = new StringTokenizer(s);
        result+= tokenizer.nextToken();
        result+= tokenizer.nextToken();
        result+= tokenizer.nextToken();
        return result;
    }
    //get Product with limit
    public static List<Product> getRecords(int start, int total) {
        PreparedStatement s = null;
        List<Product> listProLimit = new LinkedList<Product>();
        try {
            String sql = "";
            sql = "select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  from product inner join gia on product.id = gia.masp left join  khuyenmai on gia.masp=khuyenmai.masp join bonho on product.MaBoNho=bonho.id where gia.ngayketthuc is null  limit " + (start - 1) + "," + total;
            System.out.println(sql);
            s = ConnectDB.connect(sql);

            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                listProLimit.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listProLimit;
    }
    //get Product with limit
    public static List<Product> getRecords() {
        PreparedStatement s = null;
        List<Product> listProLimit = new ArrayList<>();
        try {
            String sql = "";
            sql = "select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  from product inner join gia on product.id = gia.masp left join  khuyenmai on gia.masp=khuyenmai.masp join bonho on product.MaBoNho=bonho.id where gia.ngayketthuc is null" ;
            System.out.println(sql);
            s = ConnectDB.connect(sql);

            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                listProLimit.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(listProLimit.size());
        return listProLimit;
    }
    //Total product number
    public static int getCount() {
        Statement s = null;
        int count=0;
        try {
            s = ConnectDB.connect();
            ResultSet rs = s.executeQuery("select COUNT(*)from product");
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return count;
    }
    //function to filter on brand
    public static List<Product> getProductOnBrand(String[] brand){
        if (brand==null)
        System.out.println("true");
        else System.out.println(brand[0]);
        List<Product> result = new LinkedList<>();
        PreparedStatement s = null;
        try {
            String sql ="select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  " +
                    "from product inner join gia on product.id = gia.masp " +
                    "left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "join bonho on product.MaBoNho=bonho.id " +
                    "where gia.ngayketthuc is null "+
                    " and product.HangSX = ? ";
            if (brand.length>1){
            for (int i = 1; i < brand.length; i++) {
                sql+= " or product.HangSX = ? ";
            }}

            s = ConnectDB.connect(sql);

            for (int i = 1; i <= brand.length; i++) {
                s.setString(i,brand[i-1]);
            }
            System.out.println(sql);
            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                result.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }

System.out.println(result.size());
        return result;
    }

    //function to filter on price
    public static List<Product> getProductOnPrice(String priceLow,String priceHigh){
        List<Product> result = new LinkedList<>();
        PreparedStatement s = null;
        try {
            String sql ="select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  " +
                    "from product inner join gia on product.id = gia.masp " +
                    "left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "join bonho on product.MaBoNho=bonho.id " +
                    "where gia.ngayketthuc is null  " +
                    "and gia.Gia < ? "+
                    "and gia.Gia > ? ";


            s = ConnectDB.connect(sql);
            s.setInt(1,Integer.parseInt(priceHigh+"000000"));
            s.setInt(2,Integer.parseInt(priceLow+"000000"));
            System.out.println(sql);
            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                result.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return result;
    }
//function to filter on monitor
    public static List<Product> getProductOnMonitor(String size1, String size2){
        List<Product> result = new LinkedList<>();
        PreparedStatement s = null;
        try {
            String sql ="select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM " +
                    "from product inner join gia on product.id = gia.masp " +
                    "left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "join bonho on product.MaBoNho=bonho.id " +
                    "join manhinh on manhinh.id=product.MaManHinh "+
                    "where gia.ngayketthuc is null  "+
                    "and manhinh.KichThuoc <= ? "+
                    "and manhinh.KichThuoc >= ? ";

            System.out.println(sql);
            s = ConnectDB.connect(sql);
            s.setFloat(1,Float.parseFloat(size2));
            s.setFloat(2,Float.parseFloat(size1));
            System.out.println(Float.parseFloat(size1)+""+Float.parseFloat(size2));
            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                result.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return result;
    }
    //function to filter on cpu
    public static List<Product> getProductOnCPU(String[] cpu){
        List<Product> result = new LinkedList<>();
        PreparedStatement s = null;
        try {
            String sql ="select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  " +
                    "from product inner join gia on product.id = gia.masp " +
                    "left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "join bonho on product.MaBoNho=bonho.id " +
                    "join cpu on product.MaCPU=cpu.id "+
                    "where gia.ngayketthuc is null  "+
                    "and cpu.CongNghe like ? ";
            if(cpu.length>1){
            for (int i = 1; i < cpu.length; i++) {
                sql+= "or cpu.CongNghe like ? ";
            }
            }
            System.out.println(sql);
            s = ConnectDB.connect(sql);

            for (int i = 1; i <= cpu.length; i++) {
                s.setString(i,"%"+cpu[i-1]+"%");
            }

            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                result.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return result;
    }
    //function to filter on RAM
    public static   List<Product> getProductOnRAM(String[] ram){
        List<Product> result = new LinkedList<>();
        PreparedStatement s = null;
        try {
            String sql ="select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  " +
                    "from product inner join gia on product.id = gia.masp " +
                    "left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "join bonho on product.MaBoNho=bonho.id " +
                    "where gia.ngayketthuc is null  "+
                    "and bonho.RAM = ? ";
            if(ram.length>1){
            for (int i = 1; i < ram.length; i++) {
                sql+= " or bonho.RAM = ? ";
            }}

            s = ConnectDB.connect(sql);
            for (int i = 1; i <= ram.length; i++) {
                s.setString(i,ram[i-1]);
            }
            System.out.println(sql);
            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                result.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return result;
    }
    //function to help function getProductOnHardDisk
    public static String stringForLike(String s){
        String result="";
        StringTokenizer tokenizer = new StringTokenizer(s,"-");
        result = "%"+tokenizer.nextToken()+"%"+tokenizer.nextToken()+"%"+tokenizer.nextToken()+"%";
        return result;
    }
    //function to filter on hardDisk
    public static List<Product> getProductOnHardDisk(String[] disk){
        List<Product> result = new LinkedList<>();
        PreparedStatement s = null;
        try {
            String sql ="select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  " +
                    "from product inner join gia on product.id = gia.masp " +
                    "left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "join bonho on product.MaBoNho=bonho.id " +
                    "where gia.ngayketthuc is null  "+
                    "and bonho.OCung like ? ";
            if (disk.length>1)
            for (int i = 1; i < disk.length; i++) {
                sql+= "or bonho.OCung like ? ";
            }
            System.out.println(sql);
            s = ConnectDB.connect(sql);
            for (int i = 1; i <= disk.length; i++) {
                s.setString(i,stringForLike(disk[i-1]));
            }

            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                result.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("SSD"+result.size());
        return result;
    }
    //function to filter on Sale
    public static List<Product> getProductOnSale(boolean sale){
        List<Product> result = new LinkedList<>();
        PreparedStatement s = null;
        try {
            String sql ="select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  " +
                    "from product inner join gia on product.id = gia.masp " +
                    "left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "join bonho on product.MaBoNho=bonho.id " +
                    "where gia.ngayketthuc is null  ";
            if(sale)
                sql+=" and khuyenmai.ngayketthuc-CURDATE()>0 ";
            s = ConnectDB.connect(sql);
            System.out.println(sql);
            ResultSet rs = s.executeQuery();
            Product p;

            while (rs.next()) {
                p = new Product(
                        rs.getString("ID"),
                        rs.getString("Ten"),
                        rs.getString("MainImg"),
                        rs.getInt("Gia"),
                        rs.getInt("GiaKM"),
                        rs.getDouble("MucGiamGia"),
                        rs.getInt("SoSaoDanhGia"),
                        rs.getInt("RAM"),
                        splitString(rs.getString("OCung"))

                );
                result.add(p);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }


        return result;
    }
    //support function
    public static String removeSubString(String sup, String sub){
        return sup.replace(sub,"");
    }
    //funtion to pagatation
    public  static List<Product> pagination(List<Product> list, int start, int total){
        List<Product> result = new ArrayList<>();
        if(list!=null&& start<list.size())
        for (int i = start-1; i <start+total-1; i++) {
            if(i<=list.size()-1)
                result.add(list.get(i));
            else
                break;

        }
        return result;
    }
    //support ppagatation button
    public static String getQuery(String s){
        String re="";
        StringTokenizer t = new StringTokenizer(s,"&");
        int count =t.countTokens();
        for (int i = 0; i < count; i++) {
            String item=t.nextToken();
            if (item.contains("page"))
                continue;
            else if(i==count-1)
                re+=item;
                else re+= item+"&";


        }
        return re;
    }
    public static List<Product> sort ( List<Product>  arr,String id){
        if (arr==null||arr.isEmpty()) System.out.println("list is null");
        if (id.equals("2")){
            Collections.sort(arr, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o2.getPrice()- o1.getPrice());
                }
            });
            System.out.println("Sort complete 2");
        }else if (id.equals("3")){
            Collections.sort(arr, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice()- o2.getPrice());
                }
            });
            System.out.println("Sort complete 3");
        }
        System.out.println("Sort complete ??");
        return arr;
    }
    public static void main(String[] args) {
       // int a = ProductListEntity.getCount();
      //  System.out.println(a);
       // System.out.println(getRecords(2,5));
        String[] a={"Apple","Aus"};
        List<Product> h =getProductOnBrand(a);
        List<Product> p = getRecords();
        p.retainAll(h);
        System.out.println("g"+p.size());
        //System.out.println(removeSubString("asdfghk","dfg"));
    }
}
