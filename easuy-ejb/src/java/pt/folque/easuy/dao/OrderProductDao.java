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
import pt.folque.easuy.model.OrderProduct;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class OrderProductDao {
    
    @PersistenceContext(unitName = "easuy-ejbPU")
    private EntityManager em;
    
    public OrderProduct find(Long userId, Long productId, Date date){
        List<OrderProduct> orders = em.createNamedQuery("OrderProduct.find")
                .setParameter("productId", productId)
                .setParameter("userId", userId)
                .setParameter("date", date)
                .getResultList();
        if(!orders.isEmpty()){
            return orders.get(0);
        }
        return null;
    }
    
    public List<OrderProduct> findAll(){
        List<OrderProduct> orders = em.createNamedQuery("OrderProduct.findAll")
                .getResultList();
        return orders;
    }
    
    public List<OrderProduct> findByUserId(Long id){
        List<OrderProduct> orders = em.createNamedQuery("OrderProduct.findByUserId")
                .setParameter("userID", id)
                .getResultList();
        return orders;
    }
    
    public List<OrderProduct> findByProductId(Long id){
        List<OrderProduct> orders = em.createNamedQuery("OrderProduct.findByProductId")
                .setParameter("productId", id)
                .getResultList();
        return orders;
    }
    
    
    public List<OrderProduct> findByDate(Date date){
        List<OrderProduct> orders = em.createNamedQuery("OrderProduct.findByDate")
                .setParameter("date", date)
                .getResultList();
        return orders;
    }
    
    public void persist(OrderProduct orderProduct) {
        em.persist(orderProduct);
    }
    
    public void merge(OrderProduct orderProduct){
        em.merge(orderProduct);
    }
    
    public void remove(OrderProduct orderProduct){
        em.remove(orderProduct);
    }
    
}
