package pt.folque.easuy.orm;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.folque.easuy.model.UserLog;

/**
 *
 * @author Diogo Teixeira
 */
@Stateless
@LocalBean
public class UserLogOrm {

    @PersistenceContext(unitName = "easuy-ejbPU")
    private EntityManager em;
    
    public List<UserLog> findAll(){
        List<UserLog> userLogs = em.createNamedQuery("UserLog.findAll").getResultList();
        return userLogs;
    }
    
    public List<UserLog> findByUserId(Long id){
        List<UserLog> userLogs = em.createNamedQuery("UserLog.findByUserId")
                .setParameter("userId", id)
                .getResultList();
        return userLogs;
    }
    
    public List<UserLog> findByDate(Date date){
        List<UserLog> userLogs = em.createNamedQuery("UserLog.findByDate")
                .setParameter("date", date)
                .getResultList();
        return userLogs;
    }
    
    public List<UserLog> findByType(String type){
        List<UserLog> userLogs = em.createNamedQuery("UserLog.findByType")
                .setParameter("type", type)
                .getResultList();
        return userLogs;
    }
    
    public UserLog find(Long userId, Date date, String type){
        List<UserLog> userLogs = em.createNamedQuery("UserLog.find")
                .setParameter("userId", userId)
                .setParameter("date", date)
                .setParameter("type", type)
                .getResultList();
        if(!userLogs.isEmpty()){
            return userLogs.get(0);
        }
        return null;
    }

    public void persist(UserLog userLog) {
        em.persist(userLog);
    }
    
    public void merge(UserLog userLog){
        em.merge(userLog);
    }
    
    public void remove(UserLog userLog){
        em.remove(userLog);
    }
}
