/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.orm;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.folque.easuy.model.Category;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class CategoryOrm {
    @PersistenceContext(unitName = "easuy-ejbPU")
    private EntityManager em;
    
    public Category findById(long id){
        return em.find(Category.class, id);
    }
    
    public List<Category> findAll(){
        List<Category> categories = em.createNamedQuery("Category.findAll").getResultList();
        return categories;
    }
    
    public void persist(Category category) {
        em.persist(category);
    }
    
    public void merge(Category category){
        em.merge(category);
    }
    
    public void remove(Category category){
        em.remove(category);
    }
    
}
