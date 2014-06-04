/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb.impl;

import java.util.Date;
import java.util.List;
import javax.ejb.Asynchronous;
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
import pt.folque.easuy.model.UserProductPK;
import pt.folque.easuy.templates.MailTemplate;

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
    @Asynchronous
    public void createNewOrder(long id) {
        UserProduct userProduct = new UserProduct();
        UserProductPK userProductPK = new UserProductPK();
        Product product = productEBean.findById(id);
        User user = userEBean.findByEmail(authEBean.getPrincipal().getName());
        userProductPK.setProductId(product.getId());
        userProductPK.setUserId(user.getId());
        userProductPK.setDate(new Date());
        userProduct.setProduct(product);
        userProduct.setUser(user);
        userProduct.setUserProductPK(userProductPK);
        product.setStock(product.getStock() - 1);
        productEBean.update(product);
        userLogEBean.setEvent(UserLogType.order, user);
        mailEBean.sendMsg(user.getEmail(), "Your order info", MailTemplate.order(product));
        createNewOrder(userProduct);
    }

    @Override
    public void createNewOrder(UserProduct userProduct) {
        userProductDao.persist(userProduct);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
