/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
public class CategoryMBean implements Serializable{

    @Inject
    private CategoryEBean categoryEBean;
    
    private Category category = null;

    public CategoryEBean getCategoryEBean() {
        return categoryEBean;
    }

    public void setCategoryEBean(CategoryEBean categoryEBean) {
        this.categoryEBean = categoryEBean;
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
    
    public List<Product> getProducts(Category category){
       List<Product> prod = category.getProductList();
        return prod;
    }
    
    
}
