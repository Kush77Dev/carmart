/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.DealerBeanLocal;
import ejb.adminLocal;
import entities.Cars;
import entities.Dealer;
import javax.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 *
 * @author Kush Khakhiwala
 */
@WebServlet(name = "dealerServlet", urlPatterns = {"/dealerServlet"})
public class dealerServlet extends HttpServlet {

    @EJB
    adminLocal adminbean;
    @EJB
    DealerBeanLocal dbl;

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
            out.println("<title>Servlet dealerServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dealerServlet at " + request.getContextPath() + "</h1>");
            
//            dbl.addCar("aa", "a.jpg", "aa", "aa", "aa", 10000, "aa", 15, "red", 123, 25, true);

//            adminbean.addDealer("kush", "surat", "79466", "k@gmail.com",1);
//            adminbean.updateDealer(1, "Hari", "Chinnar", "Rand", "Majura ni rand");
//            adminbean.removeDealer(1,1);
            Collection<Dealer> deal = adminbean.getallDealers();

            for (Dealer d : deal) {

//                out.println("<br/> Cust id :" + d.getId() + " Name : " + d.getName() + " " + d.getPhonenumber());
                out.println("Name:" + d.getName());
                out.println("</br>");
                out.println("Address:" + d.getAdress());
                out.println("</br>");
                out.println("Phone Number:" + d.getPhonenumber());
                out.println("</br>");
                out.println("Email:" + d.getEmail());
                out.println("</br>");
            }

//            Collection<Cars> cars = dbl.getCarsByDealerId(25);
//            
//            out.println("Cars by id:");
//            for (Cars c : cars) {
//                out.println("car id:" + c.getId());
//                out.println("<br>");
//            }
//
////            Dealer d = adminbean.getallDealersbyId(20);
////            out.println("Name:" + d.getName());
////            out.println("</br>");
////            out.println("Address:" + d.getAdress());
////            out.println("</br>");
////            out.println("Phone Number:" + d.getPhonenumber());
////            out.println("</br>");
////            out.println("Email:" + d.getEmail());
//            out.println("</br>");
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
