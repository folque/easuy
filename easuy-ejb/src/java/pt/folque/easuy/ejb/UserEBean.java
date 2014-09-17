package pt.folque.easuy.ejb;

import java.util.List;
import javax.ejb.Local;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo Teixeira
 */
@Local
public interface UserEBean {
    
    public void createNewUser(String email, String password, String role);
    
    public String encryptPassword(String password);
    
    public User findById(long id);
    
    public User  findByEmail(String email);
    
    public List<User> findAll();
}
