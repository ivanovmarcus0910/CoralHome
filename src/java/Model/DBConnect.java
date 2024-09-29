/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Statement;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class DBConnect {
    static ArrayList<Coral> listCoral = new ArrayList<>();
    public static Connection getConnection() {
        Connection con = null;
        String dbUser = "sa";
        String dbPassword = "admin";
        String port = "1433";
        String IP = "127.0.0.1";
        String ServerName = "minipele";
        String DBName = "CoralWeb";
        String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

        String dbURL = "jdbc:sqlserver://minipele;databaseName=CoralWeb;encrypt=false;trustServerCertificate=false;loginTimeout=30";

        try {
            Class.forName(driverClass);
            //DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            con = (Connection) DriverManager.getConnection(dbURL, dbUser, dbPassword);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return con;
    }
    public static ArrayList<Coral> getDB(){
        try{
        Connection connection = getConnection();
        String sql = "SELECT * FROM Coral";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
            //System.out.println("da den day");
        listCoral.clear();
        while (resultSet.next()) {
               int id = resultSet.getInt("ID");
               String ten = resultSet.getString("Name");
               String mau = resultSet.getString("Color");
               BigDecimal gia = resultSet.getBigDecimal("Price");
               //System.out.println(id +" "+ ten+" "+ mau +" "+ gia);
               listCoral.add(new Coral(id, ten, mau, gia));
            }
        } catch (Exception e){
            listCoral=null;
        }   
        return listCoral;
    }
    public static boolean addDB(int id, String name, String color, BigDecimal price){
        try{
        Connection connection = getConnection();
        String sqlInsert = "INSERT INTO Coral (ID, Name, Color, Price) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sqlInsert);

        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, color);
        statement.setBigDecimal(4, price);
        statement.executeUpdate();
        statement.close();
        return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static boolean deleteDB(int id){
        try{
        Connection connection = getConnection();
        java.sql.Statement statement = connection.createStatement();
        String sqlDelete = "DELETE FROM Coral WHERE ID = " + id;
        statement.executeUpdate(sqlDelete);
        return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static boolean updateDB(int id, String name, String color, BigDecimal price){
        try{
            Connection connection = getConnection();

            String sqlQuery="UPDATE Coral SET Name=?, Color=?, Price=? WHERE ID="+id;
            PreparedStatement stmt = connection.prepareStatement(sqlQuery);
            stmt.setString(1, name);
            stmt.setString(2, color);
            stmt.setBigDecimal(3, price);
            stmt.execute();
            stmt.close();
            return true;
                }
        catch (Exception e){
            return false;
        }
    }
   
}
