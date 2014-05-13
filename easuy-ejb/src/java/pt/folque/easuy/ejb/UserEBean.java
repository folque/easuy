/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

import java.security.Principal;
import javax.ejb.Local;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo
 */
@Local
public interface UserEBean {
    
    public void createNewUser(User user);
    
    public void createNewUser(String email, String password, String role);
    
    public String encryptPassword(String password);
    
    public Principal getPrincipal();
}
