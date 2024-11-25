/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import ejb.DealerBeanLocal;
import entities.Cars;
import entities.Dealer;
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
@WebServlet(name = "CarsServlet", urlPatterns = {"/CarsServlet"})
public class CarsServlet extends HttpServlet {
    
    @EJB
    DealerBeanLocal dealerBean;

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
            out.println("<title>Servlet CarsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarsServlet at " + request.getContextPath() + "</h1>");

//          dealerBean.addCar("jazz", "img1.jpg", 3,"SUV", "nice", 1500000, "zxi", 12, "white", 125, 25, true);
//          dealerBean.addCar("swift", "img", 1, "hatchback", "nice", 5000, "zxi", 17, "red", 123, 25, true);
//          dealerBean.updateCar(8, "Baleno", "img",3 , "hatchback", "nice", 5000, "zxi", 17, "red", 123, 25, true);
//           dealerBean.removeCar(10,25   ,1);
           
           
//            Cars c = dealerBean.getCarByName("seltos");
//
//            out.println("Name:" + c.getName());
//            out.println("</br>");
            
             Collection<Cars> car = dealerBean.getAllCars();

            for (Cars c1 : car) {
                out.println("Name:" + c1.getName());
                out.println("</br>");
            }

//               Collection<Cars> car = dealerBean.searchCarByName("jazz");
//               for(Cars c: car)
//               {
//                    out.println("Name:" + c.getName());
//                    out.println("</br>");
//               }
               
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
