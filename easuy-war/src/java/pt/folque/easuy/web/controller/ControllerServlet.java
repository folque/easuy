/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diogo
 */
@WebServlet(name = "ControllerServlet", 
        urlPatterns = {"/home", 
            "/easuy/product", 
            "/easuy/log", 
            "/register", 
            "/login/success",
            "/easuy/success"},
        loadOnStartup = 1)
public class ControllerServlet extends HttpServlet {
    
    private static final String CATEGORY = "/easuy/category";
    private static final String PRODUCT = "/easuy/product";
    private static final String LOG = "/easuy/log";
    private static final String REGISTER = "/login/register";
    private static final String LOGIN = "/login/login";
    private static final String REGISTERSUCCESS = "/login/success";
    private static final String INDEX = "/home";
    private static final String SUCCESS = "/easuy/success";
    
    
    
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
        String userPath = request.getServletPath();
        
        if(userPath.equals(INDEX)){
            userPath = "/index";
        }
        if(userPath.equals(CATEGORY)){
            userPath = "/easuy/categories/list";
        }
        if(userPath.equals(PRODUCT)){
            userPath = "/easuy/products/list";
        }
        if(userPath.equals(LOG)){
            userPath = "/easuy/logs/list";
        }
        if(userPath.equals(REGISTER)){
            userPath = "/login/register";
        }
        if(userPath.equals(REGISTERSUCCESS)){
            userPath = "/login/success";
        }
        if(userPath.equals(SUCCESS)){
            userPath = "/easuy/success";
        }
        
        String url = "/WEB-INF/view" + userPath + ".jsp";
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
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
        String userPath = request.getServletPath();
        
        if(userPath.equals(CATEGORY)){
            userPath = "/easuy/categories/list";
        }
        if(userPath.equals(PRODUCT)){
            userPath = "/easuy/products/list";
        }
        if(userPath.equals(LOG)){
            userPath = "/easuy/logs/list";
        }
        if(userPath.equals(REGISTER)){
            userPath = "/register";
        }
        if(userPath.equals(REGISTERSUCCESS)){
            userPath = "/login/success";
        }
        if(userPath.equals(SUCCESS)){
            userPath = "/easuy/success";
        }
        
        String url = "/WEB-INF/view" + userPath + ".xhtml";
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
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
