/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Diogo
 */
@Named("login")
@RequestScoped
public class LoginMBean {

    /**
     * Creates a new instance of LoginMBean
     */
    public LoginMBean() {
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "logout";
    }
    
}
