/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PhongNha
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String ERROR = "error.html";
    private static final String LOGIN = "login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT = "logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String SEARCH = "Search";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String UPDATECOURSE = "Update";
    private static final String UPDATECOURSE_CONTROLLER = "UpdateCourseController";
    private static final String CREATECOURSE = "CreateCourse";
    private static final String CREATECOURSE_CONTROLLER = "CreateCourseController";
    private static final String ADDTOCART = "AddToCart";
    private static final String ADDTOCART_CONTROLLER = "AddToCartController";
    private static final String REMOVETOCART = "Remove";
    private static final String REMOVETOCART_CONTROLLER = "RemoveCartController";
    private static final String UPDATECART = "UpdateCart";
    private static final String UPDATECART_CONTROLLER = "UpdateCartController";
    private static final String ORDER = "Order";
    private static final String ORDER_CONTROLLER = "OrderController";
    private static final String SEARCHORDER = "SearchOrder";
    private static final String SEARCHORDER_CONTROLLER = "ShowOrderController";
    private static final String UPDATEORDER = "UpdateOrder";
    private static final String UPDATEORDER_CONTROLLER = "UpdateOrderController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action.equals(LOGIN)) {
                url = LOGIN_CONTROLLER;
            } else if (action.equals(SEARCH)) {
                url = SEARCH_CONTROLLER;
            } else if (action.equals(UPDATECOURSE)) {
                url = UPDATECOURSE_CONTROLLER;
            } else if (action.equals(CREATECOURSE)) {
                url = CREATECOURSE_CONTROLLER;
            } else if (action.equals(ADDTOCART)) {
                url = ADDTOCART_CONTROLLER;
            } else if (action.equals(REMOVETOCART)) {
                url = REMOVETOCART_CONTROLLER;
            } else if (action.equals(UPDATECART)) {
                url = UPDATECART_CONTROLLER;
            } else if (action.equals(ORDER)) {
                url = ORDER_CONTROLLER;
            } else if (action.equals(LOGOUT)) {
                url = LOGOUT_CONTROLLER;
            } else if (action.equals(SEARCHORDER)) {
                url = SEARCHORDER_CONTROLLER;
            } else if (action.equals(UPDATEORDER)) {
                url = UPDATEORDER_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
