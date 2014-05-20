/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.folque.easuy.model.Product;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class ProductDao {
@PersistenceContext(unitName = "easuy-ejbPU")
    private EntityManager em;

    public Product findById(Long id){
        return em.find(Product.class, id);
    }
    
    public List<Product> findAll(){
        List<Product> products = em.createNamedQuery("Product.findAll").getResultList();
        return products;
    }
    
   public List<Product> findByName(String name){
       List<Product> products = em.createNamedQuery("Product.findByName")
               .setParameter("name", name)
               .getResultList();
       return products;
   }
   
   public List<Product> findByPrice(BigDecimal price){
       List<Product> products = em.createNamedQuery("Product.findByPrice")
               .setParameter("price", price)
               .getResultList();
       return products;
   }
   
   public List<Product> findByCategoryIdAndMinStock(long id, int stock){
       List<Product> products = em.createNamedQuery("Product.findByCategoryIdAndMinStock")
               .setParameter("categoryId", id)
               .setParameter("stock", stock)
               .getResultList();
       return products;
   }

    public void persist(Product product) {
        em.persist(product);
    }
    
    public void merge(Product product){
        em.merge(product);
    }
    
    public void remove(Product product){
        em.remove(product);
    }
}
