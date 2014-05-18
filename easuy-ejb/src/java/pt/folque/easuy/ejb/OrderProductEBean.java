/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

import java.util.List;
import pt.folque.easuy.model.OrderProduct;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo
 */
public interface OrderProductEBean {
    
    public void createNewOrder(long productId);
    public void createNewOrder(OrderProduct orderProduct);
    public List<OrderProduct> findByUserId(long userId);
    public List<OrderProduct> findByProductId(long productId);
    public OrderProduct findByProductAndUserId(long productId, long userId);
    
}
