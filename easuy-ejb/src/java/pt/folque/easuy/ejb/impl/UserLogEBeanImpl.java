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
import pt.folque.easuy.dao.UserLogDao;
import pt.folque.easuy.ejb.UserLogEBean;
import pt.folque.easuy.enums.UserLogType;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserLog;
import pt.folque.easuy.model.UserLogPK;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class UserLogEBeanImpl implements UserLogEBean {
    
    @Inject
    private UserLogDao userLogDao;
    
    @Override
    public void setEvent(UserLogType type, User user){
        UserLog userLog = new UserLog();
        UserLogPK userLogPK = new UserLogPK();
        userLogPK.setDate(new Date());
        userLogPK.setUserId(user.getId());
        userLog.setType(type);
        userLog.setUser(user);
        userLog.setUserLogPK(userLogPK);
        
        setEvent(userLog);
    }
    
    @Override
    public void setEvent(UserLog userLog) {
        userLogDao.persist(userLog);
    }
    
    @Override
    public List<UserLog> findByUserId(long id){
        List<UserLog> userLogs = null;
        try {
            userLogs = userLogDao.findByUserId(id);
        } catch(Exception e){
            System.err.println("Error while retrieving user logs by user id with cause: " + e.getCause());
        }
        return userLogs;
    }
    
    @Override
    public List<UserLog> findAll(long id){
        List<UserLog> userLogs = null;
        try {
            userLogs = userLogDao.findAll();
        } catch(Exception e){
            System.err.println("Error while retrieving all user log with cause: " + e.getCause());
        }
        return userLogs;
    }
    
}
