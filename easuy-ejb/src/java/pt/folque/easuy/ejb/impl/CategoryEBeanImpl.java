/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.ejb.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import pt.folque.easuy.orm.CategoryOrm;
import pt.folque.easuy.ejb.CategoryEBean;
import pt.folque.easuy.model.Category;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class CategoryEBeanImpl implements CategoryEBean {
    
    @Inject
    private CategoryOrm categoryOrm;
    
    @Override
    public List<Category> findAll() {
        return categoryOrm.findAll();
    }
    
    @Override
    public Category findById(long id) {
        Category category = null;
        try {
            category = categoryOrm.findById(id);
        } catch(Exception e){
            System.err.println("Error while finding category by id with cause: " + e.getCause());
        }
        return category;
    }
    
    
}
