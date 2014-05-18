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
import pt.folque.easuy.dao.OrderProductDao;
import pt.folque.easuy.ejb.AuthEBean;
import pt.folque.easuy.ejb.OrderProductEBean;
import pt.folque.easuy.ejb.UserEBean;
import pt.folque.easuy.model.OrderProduct;
import pt.folque.easuy.model.OrderProductPK;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class OrderProductEBeanImpl implements OrderProductEBean {
    
    @Inject
    private OrderProductDao orderProductDao;
    @Inject
    private AuthEBean authEBean;
    @Inject
    private UserEBean userEBean;

    @Override
    public void createNewOrder(long productId) {
        OrderProduct orderProduct = new OrderProduct();
        OrderProductPK orderProductPK = new OrderProductPK();
        orderProductPK.setProductId(productId);
        orderProductPK.setUserId(userEBean.findByEmail(authEBean.getPrincipal().getName()).getId());
        orderProductPK.setDate(new Date());
        orderProduct.setOrderProductPK(orderProductPK);
        
        createNewOrder(orderProduct);
    }

    @Override
    public void createNewOrder(OrderProduct orderProduct) {
        orderProductDao.persist(orderProduct);
    }

    @Override
    public List<OrderProduct> findByUserId(long userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderProduct> findByProductId(long productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderProduct findByProductAndUserId(long productId, long userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
