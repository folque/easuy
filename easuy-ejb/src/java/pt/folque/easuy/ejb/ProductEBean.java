package pt.folque.easuy.ejb;

import java.util.List;
import javax.ejb.Local;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo Teixeira
 */
@Local
public interface ProductEBean {
    
    public List<Product> findAll();

    public Product findById(long id);
    
    public List<Product> findByCategoryIdAndMinStock(long id, int stock);
    
    public void createNewProduct(Product product);
    
    public void update(Product product);
    
    public void remove(Product product);
    
    
    
}
