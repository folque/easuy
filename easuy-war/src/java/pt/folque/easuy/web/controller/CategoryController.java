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
import pt.folque.easuy.ejb.CategoryEBean;
import pt.folque.easuy.ejb.ProductEBean;
import pt.folque.easuy.ejb.UserProductEBean;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/easuy/category", "/easuy/category/*"})
public class CategoryController extends HttpServlet {
    
    @Inject
    private CategoryEBean categoryBean;
    @Inject
    private ProductEBean productBean;
    @Inject
    private UserProductEBean userProductBean;
    
    private static final String CATEGORY = "/easuy/category";
    
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
        
        if(userPath.equals(CATEGORY)){
            if(request.getPathInfo() != null && request.getPathInfo().length() > 1){
                String[] pathInfo = request.getPathInfo().split("/");
                int catId = Integer.valueOf(pathInfo[1]);
                request.setAttribute("listProducts", categoryBean.findById(catId).getProductList());
                userPath = "/easuy/product";
            }
            else {
                userPath = "/easuy/category";
                
                request.setAttribute("listCategories", categoryBean.findAll());
            }
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
        
        if(userPath.equals(CATEGORY)){
            long prodId = Long.valueOf(request.getParameter("prodId"));
            userProductBean.createNewOrder(prodId);
            Product product = productBean.findById(prodId);
            
            request.setAttribute("prod", product);
            userPath = "/easuy/success";
            
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
