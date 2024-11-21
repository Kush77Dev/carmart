/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.UserBeanLocal;
import entities.CarOrder;
import entities.OrderItems;
import javax.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Kush Khakhiwala
 */
public class orderServlet extends HttpServlet {

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
            out.println("<title>Servlet orderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet orderServlet at " + request.getContextPath() + "</h1>");

//            ubl.addOrder(2, 6, 2, "Surat", 7000, 707000, true, false, "Surat");
//            ubl.updateOrder(3,2, 6, 2, "Navsari", 7000, 707000, true, false, "Surat");
//              ubl.removeOrder(4, 2, 6, 2);
//                CarOrder co = ubl.getCarOrderById(2);
//                out.println("id:" + co.getId());
//                out.println("</br>");
//              Collection<CarOrder> carid= ubl.getCarOrderByCarId(2);
//            for(CarOrder co: carid){
//                out.println("id:" + co.getId());
//                out.println("</br>");
//                out.println("CarID:" + co.getCarID().getId());
//                out.println("</br>");
//
//            }
//            Collection<CarOrder> itemid = ubl.getCarOrderByItemId(2);
//            for(CarOrder co: itemid)
//            {
//                out.println("id:" + co.getId());
//                out.println("</br>");
//                out.println("CarID:" + co.getItemID().getItemId());
//                out.println("</br>");
//            }
//            Collection<CarOrder> userid = ubl.getCarOrderByUserId(8);
//            for(CarOrder co: userid)
//            {
//                out.println("id:" + co.getId());
//                out.println("</br>");
//                out.println("UserID:" + co.getUserID().getId());
//                out.println("</br>");
//            }
//            Collection<CarOrder> itemid = ubl.getAllCarorder();
//            for(CarOrder co: itemid)
//            {
//                out.println("id:" + co.getId());
//                out.println("</br>");
//                out.println("CarID:" + co.getItemID().getItemId());
//                out.println("</br>");
//            }
            LocalDate localDate = LocalDate.of(2024, 11, 14);

            // Convert LocalDate to java.util.Date
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // Now pass the date to your method
//        Collection<CarOrder> orderDate = ubl.getCarOrderByDate(date);
//
//        // Iterate and display the results
//        for (CarOrder co : orderDate) {
//            out.println("id: " + co.getId());
//            out.println("</br>");
//            out.println("CarID: " + co.getItemID().getItemId());
//            out.println("</br>");
//        }
//            ubl.addOrder(1, "Surat", 1000, 2000, false, false, "Surat");
//            ubl.addItem(4, 6);
            Collection<OrderItems> items = ubl.getItemByOrderId(6);
            out.println(items);
            for(OrderItems i:items){
                out.println("<br/>");
                out.println("id:"+i.getCarid().getName());
            }

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
