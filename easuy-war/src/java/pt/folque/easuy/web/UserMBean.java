/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pt.folque.easuy.ejb.UserEBean;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo
 */
@Named("user")
@SessionScoped
public class UserMBean implements Serializable{
    
    @Inject
    private UserEBean userEBean;
    
    private User user;
    /**
     * Creates a new instance of UserMBean
     */
    public UserMBean() {
    }
    
    public String getLoggedInUser(){
        return userEBean.getPrincipal().getName();
    }
    
    public String getText(){
        return userEBean.getText();
    }
    
    
    
    
    
}
