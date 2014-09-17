package pt.folque.easuy.web.controller;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pt.folque.easuy.ejb.UserEBean;

/**
 *
 * @author Diogo Teixeira
 */
@WebServlet(name = "ControllerServlet", 
        urlPatterns = {"/home", 
            "/login/register", 
            "/logout",
            "/login/success"},
        loadOnStartup = 1)
public class UserController extends HttpServlet {
    
    @Inject
    private UserEBean userBean;
    
    private static final String REGISTER = "/login/register";
    private static final String LOGOUT = "/logout";
    private static final String REGISTERSUCCESS = "/login/success";
    private static final String INDEX = "/home";

    
    
    
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
        if(userPath.equals(REGISTER)){
            userPath = "/login/register";
        }
        if(userPath.equals(REGISTERSUCCESS)){
            userPath = "/login/success";
        }
        if(userPath.equals(LOGOUT)){
            request.logout();
            userPath = "/index";
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
        
        if(userPath.equals(REGISTER)){
            userPath = "/login/register";
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            userBean.createNewUser(email, password, "user");
            
            String url = "/WEB-INF/view" + userPath + ".jsp";
            
            try {
                request.getRequestDispatcher(url).forward(request, response);
                response.sendRedirect(request.getContextPath() + INDEX);
            } catch(Exception e){
                e.printStackTrace();
            }            
        
        }
        if(userPath.equals(REGISTERSUCCESS)){
            userPath = "/login/success";
        }
        
        String url = "/WEB-INF/view" + userPath + ".jsp";
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
