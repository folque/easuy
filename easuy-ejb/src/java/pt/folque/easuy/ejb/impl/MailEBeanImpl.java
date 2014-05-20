/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb.impl;

import java.util.Properties;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import pt.folque.easuy.ejb.MailEBean;

/**
 *
 * @author Diogo
 */
@Stateless
@LocalBean
public class MailEBeanImpl implements MailEBean{
    
    @Override
    public void sendMsg(String address, String title, String content){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication(){
                        return new PasswordAuthentication("easuy@gmail.com", "easuyadmin");
                    }
                });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("folque@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, InternetAddress.parse(address)[0]);
            message.setSubject(title);
            message.setText(content);
            Transport.send(message);
            
            System.out.println("Message with title \"" + title + "\" sent with success");
            
        } catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
