/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import java.util.List;
import javax.enterprise.context.RequestScoped;
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
    
    public void placeOrder(Product product){
        userProductEBean.createNewOrder(product);
    }
    
}
