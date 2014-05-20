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
import pt.folque.easuy.dao.ProductDao;
import pt.folque.easuy.ejb.ProductEBean;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class ProductEBeanImpl implements ProductEBean {
    
    @Inject
    private ProductDao productDao;
    
    @Override
    public List<Product> findAll() {
        List<Product> products = null;
        try {
            products = productDao.findAll();
        } catch(Exception e){
            System.err.println("Error while finding all products with cause: " + e.getCause());
        }
        return products;
    }
    
    @Override
    public Product findById(long id) {
        Product product = null;
        try {
            product = productDao.findById(id);
        } catch(Exception e){
            System.err.println("Error while finding product by id with cause: " + e.getCause());
        }
        return product;
    }
    
    @Override
    public List<Product> findByCategoryIdAndMinStock(long id, int stock){
        List<Product> products = null;
        try {
            products = productDao.findByCategoryIdAndMinStock(id, stock);
        } catch(Exception e){
            System.err.println("Error while finding products by category id and stock with cause: " + e.getCause());
        }
        return products;
    }
    
    @Override
    public void createNewProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void update(Product product) {
        try {
            productDao.merge(product);
        } catch(Exception e){
            System.err.println("Error while updating product with cause: " + e.getCause());
        }
    }
    
    @Override
    public void remove(Product product) {
        try {
            productDao.remove(product);
        } catch(Exception e){
            System.err.println("Error while removing product with cause: " + e.getCause());
        }
    }
    
}
