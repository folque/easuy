package pt.folque.easuy.ejb;

import java.util.List;
import javax.transaction.Transactional;
import pt.folque.easuy.model.UserProduct;

/**
 *
 * @author Diogo Teixeira
 */
public interface UserProductEBean {
    
    // Adds a product to the cart
    @Transactional
    public void createNewOrder(Long id);
    
    // Purchase products from the cart
    @Transactional
    public void buy(Long id);
    
    public List<UserProduct> getUnpurchased(Long userId);
    
    public List<UserProduct> getPurchased(Long userId);
    
}
