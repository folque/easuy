/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.web;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import pt.folque.easuy.ejb.UserProductEBean;
import pt.folque.easuy.ejb.ProductEBean;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@Named("product")
@RequestScoped
public class ProductMBean {
    
    @Inject
    private ProductEBean productEBean;
    @Inject
    private UserProductEBean userProductEBean;
    
    public List<Product> getList(){
        return productEBean.findAll();
    }
    
    private void addMessage(FacesMessage message){
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String placeOrder(Product product){
        userProductEBean.createNewOrder(product);
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Your order of " + product.getName() + "has been processed. Thank you for using our service.", null));
        return "success";
    }
    
}
