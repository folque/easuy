/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pt.folque.easuy.ejb.ProductEJB;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@ManagedBean(name = "product")
@RequestScoped
public class ProductMBean {

    @EJB
    private ProductEJB productEJB;
    
    /**
     * Creates a new instance of ProductMBean
     */
    public ProductMBean() {
    }
    
    public List<Product> getList(){
       return productEJB.findAll();
    }
    
}
