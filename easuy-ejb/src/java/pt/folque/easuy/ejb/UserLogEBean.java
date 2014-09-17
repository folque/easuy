package pt.folque.easuy.ejb;

import java.util.List;
import javax.transaction.Transactional;
import pt.folque.easuy.enums.UserLogType;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserLog;

/**
 *
 * @author Diogo Teixeira
 */
public interface UserLogEBean {
    
    // Creates an event of given type for a given user
    @Transactional
    public void setEvent(UserLogType event, User user);
        
    public List<UserLog> findByUserId(long id);
    
    public List<UserLog> findAll();
    
}
