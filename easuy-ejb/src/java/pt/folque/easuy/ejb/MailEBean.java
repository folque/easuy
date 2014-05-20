/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

/**
 *
 * @author Diogo
 */
public interface MailEBean {
    
    public void sendMsg(String address, String title, String content);
    
}
