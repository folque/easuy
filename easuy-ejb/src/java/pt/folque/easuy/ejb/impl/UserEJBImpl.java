package pt.folque.easuy.ejb.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Date;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import pt.folque.easuy.dao.UserDao;
import pt.folque.easuy.ejb.UserEJB;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserDetails;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class UserEJBImpl implements UserEJB{

    @Resource
    private SessionContext sessionContext;
    
    @EJB
    private UserDao userDao;
    
    public void createNewUser(User user){
        userDao.persist(user);
    }
    
    public void createNewUser(String email, String password, String firstname, String lastname, Date dob){
        User user = new User();
        UserDetails userDetails = new UserDetails();
        
        user.setEmail(email);
        user.setPassword(encryptPassword(password));
        
        userDetails.setFirstname(firstname);
        userDetails.setLastname(lastname);
        userDetails.setDob(dob);
        
        user.setUserDetails(userDetails);
        
        createNewUser(user);
        
    }
    
    public String encryptPassword(String password){
        String result = null;
        try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < bytes.length; i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        result = sb.toString();
        
        return result;
        } catch(NoSuchAlgorithmException e){
        }
        
        return null;
    }
    
    
    public Principal getPrincipal(){
        Principal principal = sessionContext.getCallerPrincipal();
        return principal;
    }
    

    public String getText(){
        return "text";
    }
}
