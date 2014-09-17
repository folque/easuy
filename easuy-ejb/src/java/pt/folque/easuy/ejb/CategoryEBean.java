package pt.folque.easuy.ejb;

import java.util.List;
import javax.ejb.Local;
import pt.folque.easuy.model.Category;

/**
 *
 * @author Diogo Teixeira
 */
@Local
public interface CategoryEBean {
        
    public Category findById(long id);
    
    public List<Category> findAll();

}