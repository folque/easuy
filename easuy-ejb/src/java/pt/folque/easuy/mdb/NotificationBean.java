///*
//* To change this license header, choose License Headers in Project Properties.
//* To change this template file, choose Tools | Templates
//* and open the template in the editor.
//*/
//
//package pt.folque.easuy.mdb;
//
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.MessageDriven;
//import javax.jms.JMSDestinationDefinition;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.ObjectMessage;
//import pt.folque.easuy.model.User;
//
///**
// *
// * @author Diogo
// */
//@JMSDestinationDefinition(name = "NotificationQueue", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "NotificationQueue")
//@MessageDriven(activationConfig = {
//    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
//    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "NotificationQueue")
//})
//public class NotificationBean implements MessageListener {
//    
//    public NotificationBean() {
//    }
//    
//    @Override
//    public void onMessage(Message message) {
//        try
//        {
//            Object msgObj = ((ObjectMessage)message).getObject();
//            if (msgObj != null)
//            {
//                User user = (User)msgObj;
//                System.out.println("Customer with the following details has been updated:");
//                StringBuilder sb = new StringBuilder();
//                sb.append("Customer ID=");
//                sb.append(user.getId());
//                sb.append(", ");
//                sb.append("Name=");
//                sb.append(user.getUserDetails().getFirstname() + " " + user.getUserDetails().getLastname());
//                sb.append(", ");
//                sb.append("Email=");
//                sb.append(user.getEmail());
//                System.out.println(sb.toString());
//            }
//        }
//        catch (JMSException ex)
//        {
//            Logger.getLogger(NotificationBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//}
