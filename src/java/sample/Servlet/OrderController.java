/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.DAO.Cart;
import sample.DAO.DAO;
import sample.DAO.Item;
import sample.DAO.Order;
import sample.DAO.Course;
import sample.DAO.User;

/**
 *
 * @author PhongNha
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Random rand = new Random();
        String check = request.getParameter("login");
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("LOGIN_USER");
        List<Item> list = cart.getItems();
        DAO dao = new DAO();
        boolean checkDup = false;
        String orderID;
        if (check.equals("null")) {
            int randomID;
            do {
                randomID = rand.nextInt(1000);
                orderID = "od" + randomID;
                List<Order> dup = dao.order(orderID);
                if (dup == null) {
                    checkDup = true;
                }
            } while (checkDup = false);
            for (Item item : list) {
                String CourseID = item.getCourse().getCourseID();
                int quantity = item.getQuantity();
                LocalDate localDate = LocalDate.now();//For reference
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String orderDate = localDate.format(formatter);
                boolean addOD = dao.createOrder(orderID, CourseID, quantity, orderDate);
                if(addOD = false){
                    request.getRequestDispatcher("dsffasdf").forward(request, response);
                }
                //----------------------------
                Course getCourse = dao.getCourseByID(CourseID);
                int newQuantity = getCourse.getQuantity() - quantity;
                boolean newProduct = dao.updateCourse(CourseID, getCourse.getCourseName(), getCourse.getDescription(), getCourse.getTuitionFee(), getCourse.getEndDate(), getCourse.getCategory(), newQuantity, getCourse.getUpdate());
            }
            list.removeAll(list);
            cart.setItems(list);
            session.setAttribute("Order", orderID);
            request.getRequestDispatcher("OrderSuccess.jsp").forward(request, response);
        } else if (user != null) {
            for (Item item : list) {
                String userID = user.getUserID();
                String CourseID = item.getCourse().getCourseID();
                int quantity = item.getQuantity();
                LocalDate localDate = LocalDate.now();//For reference
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String orderDate = localDate.format(formatter);
                boolean addOD = dao.createOrder(userID, CourseID, quantity, orderDate);

                //----------------------------
                Course getCourse = dao.getCourseByID(CourseID);
                int newQuantity = getCourse.getQuantity() - quantity;
                boolean newProduct = dao.updateCourse(CourseID, getCourse.getCourseName(), getCourse.getDescription(), getCourse.getTuitionFee(), getCourse.getEndDate(), getCourse.getCategory(), newQuantity, getCourse.getUpdate());
            }
            list.removeAll(list);
            cart.setItems(list);
            request.getRequestDispatcher("OrderSuccess.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
