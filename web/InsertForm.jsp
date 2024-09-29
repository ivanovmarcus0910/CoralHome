<%-- 
    Document   : InsertForm
    Created on : 25 Sept 2024, 13:49:56
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm san hô</title>
    </head>
    <body>
        <h1>Thông tin san hô cần thêm</h1>
        <form action="MainServlet?action=add" method="post">
              <label for="id">ID </label>
        <input type="number" id="id" name="id" required/><br/><br/>
        <label for="ten">Tên:</label>
        <input type="text" id="name" name="name" required/><br/><br/>
        <label for="mau">Màu:</label>
        <input type="text" id="color" name="color" required/><br/><br/>
        
        <label for="gia">Giá:</label>
        <input type="number" id="price" name="price" step="0.01" required/><br/><br/>
        
        <input type="submit" value="Thêm San Hô"/>
    </form>
    <br>
    <button onclick="window.location.href='MainServlet'">Về lại trang chủ</button>
    </body>
</html>
