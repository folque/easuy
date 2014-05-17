/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import pt.folque.easuy.ejb.UserEBean;

/**
 *
 * @author Diogo
 */
@Named("register")
@RequestScoped
public class RegisterMBean {
    
    private String email;
    private String password;
    private String confirmEmail;
    private String confirmPassword;
    
    @Inject
    private UserEBean userEBean;

    /**
     * Creates a new instance of RegisterMBean
     */
    public RegisterMBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public UserEBean getUserEBean() {
        return userEBean;
    }

    public void setUserEBean(UserEBean userEBean) {
        this.userEBean = userEBean;
    }
    
    private void addMessage(FacesMessage message){
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String addUser(){
        userEBean.createNewUser(email, password, "user");
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "User successfully registered", null));
        return "registered";
    }
    
    public boolean validateEmail(){
        return email.equals(confirmEmail);
    }
    
    public boolean validatePassword(){
        return password.equals(confirmPassword);
    }
    
}
