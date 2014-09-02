/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package pt.folque.easuy.ejb.impl;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import pt.folque.easuy.orm.UserLogOrm;
import pt.folque.easuy.ejb.UserLogEBean;
import pt.folque.easuy.enums.UserLogType;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserLog;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class UserLogEBeanImpl implements UserLogEBean {
    
    @Inject
    private UserLogOrm userLogOrm;
    
    @Override
    public void setEvent(UserLogType type, User user){
        UserLog userLog = new UserLog();
        userLog.setDate(new Date());
        userLog.setType(type);
        userLog.setUser(user);
        
        userLogOrm.persist(userLog);
    }    
    
    @Override
    public List<UserLog> findByUserId(long id){
        List<UserLog> userLogs = null;
        try {
            userLogs = userLogOrm.findByUserId(id);
        } catch(Exception e){
            System.err.println("Error while retrieving user logs by user id with cause: " + e.getCause());
        }
        return userLogs;
    }
    
    @Override
    public List<UserLog> findAll(){
        List<UserLog> userLogs = null;
        try {
            userLogs = userLogOrm.findAll();
        } catch(Exception e){
            System.err.println("Error while retrieving all user log with cause: " + e.getCause());
        }
        return userLogs;
    }
    
}
