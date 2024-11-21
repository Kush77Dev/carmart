/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.UserBeanLocal;
import entities.Appointment;
import javax.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 *
 * @author Kush Khakhiwala
 */
public class appointmentServlet extends HttpServlet {

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
            out.println("<title>Servlet appointmentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet appointmentServlet at " + request.getContextPath() + "</h1>");

          ubl.addAppointment(5, 25, 2, "confirmed");
          ubl.addAppointment(5, 25, 2, "scheduled");

//          ubl.updateAppointment(2, 6,25,2,"confirmed");
//          ubl.remmoveAppointment(2, 6, 25, 2);

//            Appointment app = ubl.getAppointmentbyId(1);

//            out.println("id:" + app.getId());
//            out.println("</br>");

            
//            Collection<Appointment> app1= ubl.getAppoinetmentbyStatus("canceled");
//            for(Appointment a: app1){
//                out.println("id:" + a.getStatus());
//                out.println("</br>");
//
//            }
            
//            Collection<Appointment> app1= ubl.getAppoinetmentbyCarId(2);
//            for(Appointment a: app1){
//                out.println("status:" + a.getStatus());
//                out.println("</br>");
//                out.println("Date:" + a.getAppointmentDate());
//                out.println("</br>");
//
//            }
            
//            Collection<Appointment> app1= ubl.getAppoinetmentbyUserId(5);
//            for(Appointment a: app1){
//                out.println("status:" + a.getStatus());
//                out.println("</br>");
//                out.println("Date:" + a.getAppointmentDate());
//                out.println("</br>");
//
//            }
//            
//            Collection<Appointment> app2= ubl.getAppoinetmentbyDealerId(25);
//            for(Appointment a: app1){
//                out.println("status:" + a.getStatus());
//                out.println("</br>");
//                out.println("Date:" + a.getAppointmentDate());
//                out.println("</br>");
//
//            }
            
            
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
