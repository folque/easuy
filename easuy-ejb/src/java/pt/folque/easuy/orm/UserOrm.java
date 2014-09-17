package pt.folque.easuy.orm;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo Teixeira
 */
@Stateless
@LocalBean
public class UserOrm{
    
    @PersistenceContext(unitName = "easuy-ejbPU")
    private EntityManager em;

    public User findById(Long id){
        return em.find(User.class, id);
    }
    
    public List<User> findAll(){
        List<User> users = em.createNamedQuery("User.findAll").getResultList();
        return users;
    }
    
    public User findByEmail(String email){
        List<User> users = em.createNamedQuery("User.findByEmail")
                .setParameter("email", email)
                .getResultList();
        if(!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }

    public void persist(User user) {
        em.persist(user);
    }
    
    public void merge(User user){
        em.merge(user);
    }
    
    public void remove(User user){
        em.remove(user);
    }

}
