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
import javax.servlet.http.HttpSession;
import pt.folque.easuy.ejb.CategoryEBean;
import pt.folque.easuy.ejb.ProductEBean;
import pt.folque.easuy.ejb.UserProductEBean;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/easuy/category", "/easuy/product", "/easuy/success"})
public class CategoryController extends HttpServlet {
    
    @Inject
    private CategoryEBean categoryBean;
    @Inject
    private ProductEBean productBean;
    @Inject
    private UserProductEBean userProductBean;
    
    private static final String CATEGORY = "/easuy/category";
    private static final String PRODUCT = "/easuy/product";
    private static final String SUCCESS = "/easuy/success";
    
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
        
        HttpSession session = request.getSession(false);
        
        String userPath = request.getServletPath();
        
        if(userPath.equals(CATEGORY)){
            userPath = "/easuy/category";
            request.setAttribute("listCategories", categoryBean.findAll());
        }
        
        if(userPath.equals(PRODUCT)){
            long catId = Long.valueOf(session.getAttribute("catId").toString());
            session.removeAttribute("catId");
            request.setAttribute("listProducts", categoryBean.findById(catId).getProductList());
            userPath = "/easuy/product";
        }
        
        if(userPath.equals(SUCCESS)){
            Product product = (Product)session.getAttribute("product");
            request.setAttribute("product", product);
            session.removeAttribute("product");
            userPath = "/easuy/success";
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

        HttpSession session = request.getSession(false);
        
        String userPath = request.getServletPath();
        if(userPath.equals(CATEGORY)){
            session.setAttribute("catId", request.getParameter("catId"));
            String userPathAux = "/easuy/product";
            String url = "/WEB-INF/view" + userPathAux + ".jsp";
            try {
                request.getRequestDispatcher(url).forward(request, response);
                response.sendRedirect(request.getContextPath() + "/easuy/product");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        else if(userPath.equals(PRODUCT)){
            long prodId = Long.valueOf(request.getParameter("prodId"));
            userProductBean.createNewOrder(prodId);
            Product product = productBean.findById(prodId);
            session.setAttribute("prod", product);
            String userPathAux = "/easuy/success";
            
            String url = "/WEB-INF/view" + userPathAux + ".jsp";
            try {
                request.getRequestDispatcher(url).forward(request, response);
                response.sendRedirect(request.getContextPath() + "/easuy/success");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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
