/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

import java.util.List;
import javax.ejb.Local;
import pt.folque.easuy.model.Category;

/**
 *
 * @author Diogo
 */
@Local
public interface CategoryEBean {
        
    public Category findById(long id);
    
    public List<Category> findAll();

}