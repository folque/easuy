/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

import java.util.List;
import pt.folque.easuy.model.Product;
import pt.folque.easuy.model.UserProduct;

/**
 *
 * @author Diogo
 */
public interface UserProductEBean {
    
    public void createNewOrder(Product product);
    public void createNewOrder(UserProduct userProduct);
    public List<UserProduct> findByUserId(long userId);
    public List<UserProduct> findByProductId(long productId);
    public UserProduct findByProductAndUserId(long productId, long userId);
    
}
