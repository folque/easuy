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
import pt.folque.easuy.ejb.CategoryEBean;
import pt.folque.easuy.model.Category;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@Named("category")
@RequestScoped
public class CategoryMBean {

    @Inject
    private CategoryEBean categoryEBean;
    
    private Category category = null;
    
    /**
     * Creates a new instance of CategoryMBean
     */
    public CategoryMBean() {
    }
    
    
    public String enterCategory(long id){
        this.category = categoryEBean.findById(id);
        return "category";
    }
    
    public List<Category> getList(){
        return categoryEBean.findAll();
    }
    
    public Category getCategory(){
        return category;
    }
    
    public List<Product> getProducts(long id){
       return categoryEBean.findById(id).getProductList();
    }
    
    
}
