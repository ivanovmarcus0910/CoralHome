/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class MainServlet extends HttpServlet {
    DBConnect DAO = new DBConnect();
    ArrayList<Coral> coralList = new ArrayList<>();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    protected void InsertDB(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=  request.getParameter("name");
        String color=  request.getParameter("color");
        BigDecimal price=  new BigDecimal(request.getParameter("price"));
        System.out.println(id+" "+name+" "+color+" "+price);
        boolean status = DAO.addDB(id, name, color, price);
        doGet(request, response);
    }

    protected void Delete(HttpServletRequest request, HttpServletResponse response)
    {
        int id= Integer.parseInt(request.getParameter("iddel"));
        boolean status = DAO.deleteDB(id);
        doGet(request, response);
        
    }
    protected void Update(HttpServletRequest request, HttpServletResponse response)
    {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=  request.getParameter("name");
        String color=  request.getParameter("color");
        BigDecimal price=  new BigDecimal(request.getParameter("price"));
        //System.out.println(id + name + color + price);
        DAO.updateDB(id, name, color, price);
        doGet(request, response);
    }
    
    
    
     
     
     
     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //System.out.println("Chay doGet");
        coralList = DAO.getDB();
        //System.out.println("Day data vo request");
        request.setAttribute("coralList", coralList);
        try{
        RequestDispatcher dispatcher = request.getRequestDispatcher("Display.jsp");
        
        dispatcher.forward(request, response);
        }
        catch (Exception e){
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action");
         switch (action){
             case "add"->{
                
                 InsertDB(request, response);
             }
             case "update"->{
                 Update(request, response);
             }
             case "delete"->{
                 Delete(request, response);
             }
         }
    }
 
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    @Override
    public String getServletInfo() {
                 System.out.println("Đã đến đây");

        return "Short description";
    } // </editor-fold>
 
}
