/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.web.controller;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pt.folque.easuy.ejb.UserEBean;
import pt.folque.easuy.ejb.UserLogEBean;
import pt.folque.easuy.ejb.UserProductEBean;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo
 */
@WebServlet(name = "LogController", urlPatterns = {"/easuy/log"})
public class LogController extends HttpServlet {
    
    @Inject
    private UserLogEBean userLogBean;
    @Inject
    private UserEBean userBean;
    @Inject
    private UserProductEBean userProductBean;
    
    private static final String LOG = "/easuy/log";
    
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
        
        if(userPath.equals(LOG)){
                userPath = "/easuy/log";
                User user = userBean.findByEmail(request.getRemoteUser());
                long id = user.getId();
                request.setAttribute("logList", userLogBean.findByUserId(id));
        }
        
        String url = "/WEB-INF/view" + userPath + ".jsp";
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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
        
        if(userPath.equals(LOG)){
            userPath = "/easuy/log";
        }
        
        String url = "WEB-INF/view" + userPath + ".jsp";
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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
