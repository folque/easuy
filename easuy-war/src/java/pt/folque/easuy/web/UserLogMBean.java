/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pt.folque.easuy.ejb.AuthEBean;
import pt.folque.easuy.ejb.UserEBean;
import pt.folque.easuy.ejb.UserLogEBean;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserLog;

/**
 *
 * @author Diogo
 */
@Named("log")
@RequestScoped
public class UserLogMBean {

    @Inject
    private UserLogEBean userLogEBean;
    @Inject
    private AuthEBean authEBean;
    @Inject
    private UserEBean userEBean;
    
    public List<UserLog> getList(){
        User user = userEBean.findByEmail(authEBean.getPrincipal().getName());
        List<UserLog> userLogs = userLogEBean.findByUserId(user.getId());
        return userLogs;
    }
    
}
