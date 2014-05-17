package pt.folque.easuy.ejb.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.inject.Inject;
import pt.folque.easuy.dao.UserDao;
import pt.folque.easuy.ejb.UserEBean;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class UserEBeanImpl implements UserEBean {

    @Resource
    private SessionContext sessionContext;
    
    @Inject
    private UserDao userDao;
    
    @Override
    public void createNewUser(User user){
        userDao.persist(user);
    }
    
    @Override
    public void createNewUser(String email, String password, String role){
        User user = new User();
        
        user.setEmail(email);
        user.setPassword(encryptPassword(password));
        user.setRole(role);
        
        createNewUser(user);
    }
    
    @Override
    public String encryptPassword(String password){
        String result = null;
        try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
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
        
        return result;
    }
    
    
    @Override
    public Principal getPrincipal(){
        Principal principal = sessionContext.getCallerPrincipal();
        return principal;
    }
    
    @Override
    public User findById(long id){
        User user = null;
        try {
            user = userDao.findById(id);
        }catch(Exception e){
            System.err.println("Error while retrieving user by id with cause: " + e.getCause());
        }
        return user;
    }
    
    @Override
    public User findByEmail(String email){
        User user = null;
        try {
            user = userDao.findByEmail(email);
        }catch(Exception e){
            System.err.println("Error while retrieving user by email with cause: " + e.getCause());
        }
        return user;
    }
    
    @Override
    public List<User> findAll(){
        List<User> users = null;
        try {
            users = userDao.findAll();
        }catch(Exception e){
            System.err.println("Error while retrieving all users with reason: " + e.getCause());
        }
        return users;
    }
}
