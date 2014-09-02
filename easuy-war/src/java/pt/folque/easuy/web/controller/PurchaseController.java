/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.web.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pt.folque.easuy.ejb.CategoryEBean;
import pt.folque.easuy.ejb.ProductEBean;
import pt.folque.easuy.ejb.UserEBean;
import pt.folque.easuy.ejb.UserProductEBean;
import pt.folque.easuy.model.Product;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserProduct;

/**
 *
 * @author Diogo
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/easuy/category", "/easuy/product", "/easuy/success", "/easuy/cart"})
public class PurchaseController extends HttpServlet {
    
    @Inject
    private CategoryEBean categoryBean;
    @Inject
    private ProductEBean productBean;
    @Inject
    private UserProductEBean userProductBean;
    @Inject
    private UserEBean userEBean;
    
    private static final String CATEGORY = "/easuy/category";
    private static final String PRODUCT = "/easuy/product";
    private static final String SUCCESS = "/easuy/success";
    private static final String CART = "/easuy/cart";
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
            String message = (String)session.getAttribute("message");
            session.removeAttribute("message");
            request.setAttribute("listProducts", categoryBean.findById(catId).getProductList());
            request.setAttribute("message", message);
            userPath = "/easuy/product";
        }
        
        if(userPath.equals(SUCCESS)){
            String message = (String)session.getAttribute("message");
            request.setAttribute("message", message);
            session.removeAttribute("message");
            userPath = "/easuy/success";
        }
        
        if(userPath.equals(CART)){
            User user = userEBean.findByEmail(request.getRemoteUser());
            List<UserProduct> listUserProducts = userProductBean.getUnpurchased(user.getId());
            request.setAttribute("listUserProducts", listUserProducts);
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
        String url = "";
        String userPathAux = "";
        switch(userPath){
            
            case CATEGORY:

                session.setAttribute("catId", request.getParameter("catId"));
                userPathAux = "/easuy/product";
                url = "/WEB-INF/view" + userPathAux + ".jsp";
                try {
                    request.getRequestDispatcher(url).forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/easuy/product");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
                
            case PRODUCT:
                long prodId = Long.valueOf(request.getParameter("prodId"));
                userProductBean.createNewOrder(prodId);
                Product product = productBean.findById(prodId);
                String message = product.getName() + " has been added to your cart";
                session.setAttribute("message", message);
                userPathAux = PRODUCT;

                url = "/WEB-INF/view" + userPathAux + ".jsp";
                try {
                    request.getRequestDispatcher(url).forward(request, response);
                    response.sendRedirect(request.getContextPath() + PRODUCT);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                break;
        
            case CART:
                userProductBean.buy(userEBean.findByEmail(request.getRemoteUser()).getId());
                session.setAttribute("message", "You successfully bought the desired products");

                userPathAux = "/easuy/success";

                url = "/WEB-INF/view" + userPathAux + ".jsp";

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
