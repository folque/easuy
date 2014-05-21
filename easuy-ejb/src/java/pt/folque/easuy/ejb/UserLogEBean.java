/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

import java.util.List;
import pt.folque.easuy.enums.UserLogType;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserLog;

/**
 *
 * @author Diogo
 */
public interface UserLogEBean {
    
    public void setEvent(UserLogType event, User user);
    
    public void setEvent(UserLog userLog);
    
    public List<UserLog> findByUserId(long id);
    
    public List<UserLog> findAll(long id);
    
}
