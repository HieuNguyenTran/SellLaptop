<%@ page import="java.sql.*" %>
<%@ page import="vn.edu.nlu.db.ConnectDB" %>
<%@ page import="vn.edu.nlu.beans.Product" %>
<%
    String name=request.getParameter("val");
    if(name==null||name.trim().equals("")){
        out.print("<p>Pleas0e enter name!</p>");
    }else {
        PreparedStatement s = null;
        try {
            String sql = "select *, ROUND(Gia*(1-MucGiamGia),0) AS GiaKM  " +
                    "    from product inner join gia on product.id = gia.masp " +
                    "    left join  khuyenmai on gia.masp=khuyenmai.masp " +
                    "    where gia.ngayketthuc is null and product.Ten like ?  ";
            s = ConnectDB.connect(sql);
            s.setString(1, "%"+name+"%");
            ResultSet rs = s.executeQuery();
            int count=0;
            while (rs.next()&&count<5) {
                String id= rs.getString("ID");
                out.println("<tr class=\" pro\"><td > <img class =\" proImg\" src =\""+rs.getString("MainImg")+"\"/></td>" +
                        "<td class =\" proName\"><a  href= \"detail?id="+id+"\">" +
                         rs.getString("Ten")+ "</a>"+ "</td></tr>+<hr/>"

                );
            count++;
            }
                rs.close();
                s.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }
    }
%>
