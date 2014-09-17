package pt.folque.easuy.orm;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.folque.easuy.model.UserProduct;

/**
 *
 * @author Diogo Teixeira
 */
@Stateless
@LocalBean
public class UserProductOrm {
    
    @PersistenceContext(unitName = "easuy-ejbPU")
    private EntityManager em;
    
    public UserProduct find(Long userId, Long productId, Date date){
        List<UserProduct> users = em.createNamedQuery("UserProduct.find")
                .setParameter("productId", productId)
                .setParameter("userId", userId)
                .setParameter("date", date)
                .getResultList();
        if(!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }
    
    public UserProduct findById(Long id){
        return em.find(UserProduct.class, id);
    }
    
    public List<UserProduct> findAll(){
        List<UserProduct> users = em.createNamedQuery("UserProduct.findAll")
                .getResultList();
        return users;
    }
    
    public List<UserProduct> findByUserId(Long id){
        List<UserProduct> users = em.createNamedQuery("UserProduct.findByUserId")
                .setParameter("userID", id)
                .getResultList();
        return users;
    }
    
    public List<UserProduct> findByProductId(Long id){
        List<UserProduct> users = em.createNamedQuery("UserProduct.findByProductId")
                .setParameter("productId", id)
                .getResultList();
        return users;
    }
    
    
    public List<UserProduct> findByDate(Date date){
        List<UserProduct> users = em.createNamedQuery("UserProduct.findByDate")
                .setParameter("date", date)
                .getResultList();
        return users;
    }
    
    public UserProduct findByProductAndUser(Long productId, Long userId){
        List<UserProduct> userProducts = em.createNamedQuery("UserProduct.findByProductAndUser")
                .setParameter("productId", productId)
                .setParameter("userId", userId)
                .getResultList();
        return !userProducts.isEmpty() ? userProducts.get(0) : null;
    }
    
    public List<UserProduct> findByUserAndPurchased(Long userId, Boolean purchased){
        List<UserProduct> userProducts = em.createNamedQuery("UserProduct.findbyUserAndPurchased")
                .setParameter("userId", userId)
                .setParameter("purchased", purchased)
                .getResultList();
        return userProducts;
    }
    
    public void persist(UserProduct userProduct) {
        System.out.println(userProduct);
        em.persist(userProduct);
    }
    
    public void merge(UserProduct userProduct){
        em.merge(userProduct);
    }
    
    public void remove(UserProduct userProduct){
        em.remove(userProduct);
    }
    
}
