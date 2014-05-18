/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.folque.easuy.model.UserProduct;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class UserProductDao {
    
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
    
    public void persist(UserProduct userProduct) {
        em.persist(userProduct);
    }
    
    public void merge(UserProduct userProduct){
        em.merge(userProduct);
    }
    
    public void remove(UserProduct userProduct){
        em.remove(userProduct);
    }
    
}
