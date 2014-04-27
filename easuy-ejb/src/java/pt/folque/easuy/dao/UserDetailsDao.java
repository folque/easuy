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
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserDetails;
import pt.folque.easuy.model.UserLog;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class UserDetailsDao {

     @PersistenceContext(unitName = "easuy-ejbPU")
    private EntityManager em;
    
    public List<UserDetails> findAll(){
        List<UserDetails> userDetails = em.createNamedQuery("UserDetails.findAll").getResultList();
        return userDetails;
    }
    
    public UserDetails findByUserId(Long id){
        List<UserDetails> userDetails = em.createNamedQuery("UserDetails.findByUserId")
                .setParameter("userId", id)
                .getResultList();
        if(!userDetails.isEmpty()){
            return userDetails.get(0);
        }
        return null;
    }
    
    public List<UserDetails> findByFirstname(String firstname){
        List<UserDetails> userDetails = em.createNamedQuery("UserDetails.findByFirstname")
                .setParameter("firstname", firstname)
                .getResultList();
        return userDetails;
    }
    
    public List<UserDetails> findByLastname(String lastname){
        List<UserDetails> userDetails = em.createNamedQuery("UserDetails.findByLastname")
                .setParameter("lastname", lastname)
                .getResultList();
        return userDetails;
    }
    
    public List<UserDetails> findByDob(Date dob){
        List<UserDetails> userDetails = em.createNamedQuery("UserDetails.findByDob")
                .setParameter("dob", dob)
                .getResultList();
        return userDetails;
    }

    public void persist(UserDetails userDetails) {
        em.persist(userDetails);
    }
    
    public void merge(UserDetails userDetails){
        em.merge(userDetails);
    }
    
    public void remove(UserDetails userDetails){
        em.remove(userDetails);
    }
}
