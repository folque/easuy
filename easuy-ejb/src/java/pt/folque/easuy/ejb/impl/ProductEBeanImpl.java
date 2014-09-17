package pt.folque.easuy.ejb.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import pt.folque.easuy.orm.ProductOrm;
import pt.folque.easuy.ejb.ProductEBean;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo Teixeira
 */
@Stateless
@LocalBean
public class ProductEBeanImpl implements ProductEBean {
    
    @Inject
    private ProductOrm productOrm;
    
    @Override
    public List<Product> findAll() {
        List<Product> products = null;
        try {
            products = productOrm.findAll();
        } catch(Exception e){
            System.err.println("Error while finding all products with cause: " + e.getCause());
        }
        return products;
    }
    
    @Override
    public Product findById(long id) {
        Product product = null;
        try {
            product = productOrm.findById(id);
        } catch(Exception e){
            System.err.println("Error while finding product by id with cause: " + e.getCause());
        }
        return product;
    }
    
    @Override
    public List<Product> findByCategoryIdAndMinStock(long id, int stock){
        List<Product> products = null;
        try {
            products = productOrm.findByCategoryIdAndMinStock(id, stock);
        } catch(Exception e){
            System.err.println("Error while finding products by category id and stock with cause: " + e.getCause());
        }
        return products;
    }
    
    @Override
    public void createNewProduct(Product product) {
        try {
            productOrm.persist(product);
        } catch(Exception e){
            System.err.println("Error while creating product with cause: " + e.getCause());
        }
    }
    
    @Override
    public void update(Product product) {
        try {
            productOrm.merge(product);
        } catch(Exception e){
            System.err.println("Error while updating product with cause: " + e.getCause());
        }
    }
    
    @Override
    public void remove(Product product) {
        try {
            productOrm.remove(product);
        } catch(Exception e){
            System.err.println("Error while removing product with cause: " + e.getCause());
        }
    }
}