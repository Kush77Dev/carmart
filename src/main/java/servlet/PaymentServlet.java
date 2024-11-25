/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.UserBeanLocal;
import entities.Payment;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Kush Khakhiwala
 */
public class PaymentServlet extends HttpServlet {

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
            out.println("<title>Servlet PaymentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentServlet at " + request.getContextPath() + "</h1>");

//            ubl.addPayment(2, 100000, "banking");
//            ubl.addPayment(2,50000,"banking");
//              ubl.updatePayment(1, 2, 70000, "byCash");
//              ubl.removePayment(1,2);
//            Payment p = ubl.getPaymentById(2);
//
//            out.println("id:" + p.getId());
//            out.println("</br>");
//             Collection<Payment> pay= ubl.getPaymentByMethod("banking");
//            for(Payment p: pay){
//                out.println("Method:" + p.getPaymentMethod());
//                out.println("</br>");
//
//            }
//            Collection<Payment> pay= ubl.getAllPayments();
//            for(Payment p: pay){
//                out.println("Method:" + p.getPaymentMethod());
//                out.println("</br>");
//
//            }
            LocalDate localDate = LocalDate.of(2024, 11, 16);
           

            // Convert LocalDate to java.util.Date
            Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            Collection<Payment> pay = ubl.getPaymentByDate(date);
            for (Payment p : pay) {
                out.println("Method:" + p.getPaymentDate());
                out.println("</br>");

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
