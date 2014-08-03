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
import pt.folque.easuy.ejb.ProductEBean;
import pt.folque.easuy.model.Category;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@Named("category")
@SessionScoped
public class CategoryMBean implements Serializable{
    
    private final static int MINIMUM_STOCK = 1;
    
    @Inject
    private CategoryEBean categoryEBean;
    @Inject
    private ProductEBean productEBean;
    
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
//        if(this.category == null) category = categoryEBean.findById(1);
        return category;
    }
    
    
    public List<Product> getProducts(){
        List<Product> prod = productEBean.findByCategoryIdAndMinStock(1, MINIMUM_STOCK);
        return prod;
    }
    
    
}
