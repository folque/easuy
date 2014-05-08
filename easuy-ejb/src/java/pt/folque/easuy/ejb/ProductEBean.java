/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

import java.util.List;
import javax.ejb.Local;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@Local
public interface ProductEBean {
    
    public List<Product> findAll();

    public Product findById(long id);
    
    public void createNewProduct(Product product);
    
    public void update(Product product);
    
    public void remove(Product product);
    
    
    
}
