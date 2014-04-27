/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pt.folque.easuy.ejb.UserEJB;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo
 */
@ManagedBean(name = "user")
@SessionScoped
public class UserMBean {
    @EJB
    private UserEJB userEJB;
    
    private User user;
    /**
     * Creates a new instance of UserMBean
     */
    public UserMBean() {
    }
    
    public String getLoggedInUser(){
        return userEJB.getPrincipal().getName();
    }
    
    public String getText(){
        return userEJB.getText();
    }
    
    
    
    
    
}
