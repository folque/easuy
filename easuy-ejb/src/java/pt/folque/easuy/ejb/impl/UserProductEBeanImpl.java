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
import pt.folque.easuy.dao.UserProductDao;
import pt.folque.easuy.ejb.AuthEBean;
import pt.folque.easuy.ejb.MailEBean;
import pt.folque.easuy.ejb.ProductEBean;
import pt.folque.easuy.ejb.UserProductEBean;
import pt.folque.easuy.ejb.UserEBean;
import pt.folque.easuy.ejb.UserLogEBean;
import pt.folque.easuy.enums.UserLogType;
import pt.folque.easuy.model.Product;
import pt.folque.easuy.model.User;
import pt.folque.easuy.model.UserProduct;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class UserProductEBeanImpl implements UserProductEBean {
    
    @Inject
    private UserProductDao userProductDao;
    @Inject
    private AuthEBean authEBean;
    @Inject
    private UserEBean userEBean;
    @Inject
    private ProductEBean productEBean;
    @Inject
    private MailEBean mailEBean;
    @Inject
    private UserLogEBean userLogEBean;

    
    @Override
    public void createNewOrder(Long id) {
        UserProduct userProduct = new UserProduct();
        Product product = productEBean.findById(id);
        User user = userEBean.findByEmail(authEBean.getPrincipal().getName()); 
        userProduct.setProduct(product);
        userProduct.setUser(user);
        userProduct.setDate(new Date());
        userProduct.setPurchased(false);
        userLogEBean.setEvent(UserLogType.order, user);
       /* try {
         Thread.sleep(3000);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }*/
       // mailEBean.sendMsg(user.getEmail(), "Your order info", MailTemplate.order(product));
        userProductDao.persist(userProduct);
    }
    
    @Override
    public void buy(Long userId){
        List<UserProduct> userProducts = userProductDao.findByUserAndPurchased(userId, Boolean.FALSE);
        
        for (UserProduct userProduct : userProducts) {
            buyProduct(userProduct.getId());
        }
    }
    
    public void buyProduct(Long id){
        UserProduct userProduct = userProductDao.findById(id);
        userProduct.setPurchased(true);
        Product product = userProduct.getProduct();
        System.out.println(product);
        User user = userProduct.getUser();
        product.setStock(product.getStock() - 1);
        userProductDao.merge(userProduct);
        userLogEBean.setEvent(UserLogType.purchase, user);
    }
    
    @Override
    public List<UserProduct> getUnpurchased(Long userId){
        return userProductDao.findByUserAndPurchased(userId, Boolean.FALSE);
    }
    
    @Override
    public List<UserProduct> getPurchased(Long userId){
        return userProductDao.findByUserAndPurchased(userId, Boolean.TRUE);
    }

    @Override
    public List<UserProduct> findByUserId(long userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserProduct> findByProductId(long productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserProduct findByProductAndUserId(long productId, long userId) {
//        userProductDao.find
        return null;
    }


}
