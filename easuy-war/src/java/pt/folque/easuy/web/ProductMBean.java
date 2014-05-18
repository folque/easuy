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
import pt.folque.easuy.ejb.AuthEBean;
import pt.folque.easuy.ejb.OrderProductEBean;
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
    private OrderProductEBean orderProductEBean;
    
    /**
     * Creates a new instance of ProductMBean
     */
    public ProductMBean() {
    }
    
    public List<Product> getList(){
       return productEBean.findAll();
    }
    
    public void placeOrder(long id){
        System.out.println("ID IS: " + id);
        orderProductEBean.createNewOrder(id);
    }
    
}
