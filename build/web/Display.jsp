<%-- 
    Document   : Display.jsp
    Created on : 25 Sept 2024, 13:22:46
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.ArrayList" import="Model.Coral"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" href="css/bootstrap.css"/>
        <link rel="shortcut icon" type="image/png" href="images/favicon.png"/>
                    <title>Coral Home</title>

    </head>
    <body>
        <h1>Danh Sách San Hô</h1>
        
         <table border="1">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Màu</th>
            <th>Giá</th>
            <th>Hành động</th>
        </tr>
          <%
            // Lấy danh sách Coral từ request attribute
            ArrayList<Coral> listCoral = (ArrayList<Coral>) request.getAttribute("coralList");
            if (listCoral != null) {
                for (Coral coral : listCoral) {
            %>
                  <tr>
                <td><%= coral.getID() %></td>
                <td><%= coral.getName() %></td>
                <td><%= coral.getColor() %></td>
                <td><%= coral.getPrice() %></td>
                <td>
                    <form action="MainServlet?action=delete" method="post" style="display:inline;">
                        
                        <input type="hidden" name="iddel" value="<%= coral.getID() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
                </tr>
           <%    
               }
            } else {
        %>
               <tr>
                <td colspan="5">Không có san hô nào</td>
            </tr>
        <%  
            }
        %>
                      
    </table>
     <br>
    <form action="InsertForm.jsp" method="get" ">
                        <input type="submit" value="Thêm san hô">
                    </form>          
     <form action="Update.jsp" method="get" ">
                        <input type="submit" value="Cập nhật san hô">
                    </form> 
    </body>
    
</html>
