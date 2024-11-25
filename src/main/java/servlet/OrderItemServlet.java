/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.UserBeanLocal;
import entities.OrderItems;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 *
 * @author Kush Khakhiwala
 */
@WebServlet(name = "OrderItemServlet", urlPatterns = {"/OrderItemServlet"})
public class OrderItemServlet extends HttpServlet {
    
    @EJB
    UserBeanLocal ubl;


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrderItemServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrderItemServlet at " + request.getContextPath() + "</h1>");
            
//            ubl.addItem(4, 3);
        
//            ubl.updateItem(1, 8, 2);

//              ubl.removeItem(3, 2, 7);

//            OrderItems oi = ubl.getOrderItemById(4);
////
//            out.println("id:" + oi.getItemId());
//            out.println("</br>");


            Collection<OrderItems> itemses= ubl.getItemByCarId(4);
            for(OrderItems oi: itemses){
                out.println("ID:" + oi.getItemId()); // multiple collection 
                out.println("</br>");
                out.println("Car:" + oi.getCarid().getId()); // multiple collection 
                out.println("</br>");
                out.println("Order:" + oi.getOrderId().getId()); // multiple collection 
                out.println("</br>");
            }
            
//            Collection<OrderItems> itemses= ubl.getItemByOrderId(3);
//            for(OrderItems oi: itemses){
//                out.println("Car:" + oi.getOrderId().getCarID().getId()); // multiple collection 
//                out.println("</br>");
//
//            }
//            

            
            out.println("</body>");
            out.println("</html>");
        }   
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
