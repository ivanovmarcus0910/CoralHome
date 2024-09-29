<%-- 
    Document   : Update
    Created on : 29 Sept 2024, 14:18:45
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cập nhật thông tin san hô</h1>
        <form action ="MainServlet?action=update" method="post">
            <label for="id">ID </label>
            <td> <input type="text" id="id" name="id">  </td> <br>
            <label for="name">Tên </label>
            <td> <input type="text" id="name" name="name">  </td> <br>
            <label for="color">Màu </label>
            <td> <input type="text" id="color" name="color">  </td> <br>
            <label for="price">Giá </label>
            <td> <input type="number" id="price" name="price" step="0.1">  </td> <br>
            <input type="submit" value="Cập nhật"/>

        </form>
        <br>
        <button onclick="window.location.href='MainServlet'">Về lại trang chủ</button>
    </body>
</html>
