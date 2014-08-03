/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

import java.util.List;
import javax.transaction.Transactional;
import pt.folque.easuy.enums.UserLogType;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserLog;

/**
 *
 * @author Diogo
 */
public interface UserLogEBean {
    
    @Transactional
    public void setEvent(UserLogType event, User user);
        
    public List<UserLog> findByUserId(long id);
    
    public List<UserLog> findAll();
    
}
