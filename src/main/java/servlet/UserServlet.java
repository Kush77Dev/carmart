/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.UserBeanLocal;
import entities.User;
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
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    
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
            out.println("<title>Servlet UserServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserServlet at " + request.getContextPath() + "</h1>");
            
//            ubl.addUser("Hari", "Hari@gmail.com", "Hari1234", "Surat", "595926946",2);
//              ubl.updateUser(1, "hello", "hari@gmail.com", "123456Hari", "surat", "987989998");
              ubl.removeUser(1,2);

//            User u = ubl.getUserbyId(1);
//            out.println("Name:" + u.getName());
//            out.println("</br>");
//            out.println("Email:" + u.getEmail());
//            out.println("</br>");
//            out.println("Password:" + u.getPassword());
//            out.println("</br>");
//            out.println("Address:" + u.getAdress());
//            out.println("</br>");
//            out.println("Phone Number:" + u.getPhonenumber());
//            out.println("</br>");

//            User u = ubl.getUserbyName("Hari");
//            out.println("Name:" + u.getName());
//            out.println("</br>");
//            out.println("Email:" + u.getEmail());
//            out.println("</br>");
//            out.println("Password:" + u.getPassword());
//            out.println("</br>");
//            out.println("Address:" + u.getAdress());
//            out.println("</br>");
//            out.println("Phone Number:" + u.getPhonenumber());
//            out.println("</br>");
            
            
//            User u = ubl.getUserbyEmail("Hari@gmail.com");
//            out.println("Name:" + u.getName());
//            out.println("</br>");
//            out.println("Email:" + u.getEmail());
//            out.println("</br>");
//            out.println("Password:" + u.getPassword());
//            out.println("</br>");
//            out.println("Address:" + u.getAdress());
//            out.println("</br>");
//            out.println("Phone Number:" + u.getPhonenumber());
//            out.println("</br>");

//            Collection<User> user = ubl.getUserByGroup(2);
//            for(User u : user){
//                out.println("Name:" + u.getName());
//                out.println("</br>");
//                out.println("Email:" + u.getEmail());
//                out.println("</br>");
//                out.println("Password:" + u.getPassword());
//                out.println("</br>");
//                out.println("Address:" + u.getAdress());
//                out.println("</br>");
//                out.println("Phone Number:" + u.getPhonenumber());
//                out.println("</br>");
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
