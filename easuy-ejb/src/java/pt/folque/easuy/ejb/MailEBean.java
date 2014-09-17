/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

/**
 *
 * @author Diogo Teixeira
 */
public interface MailEBean {
    
    // Sends message to given address, with given title and content
    public void sendMsg(String address, String title, String content);
    
}
