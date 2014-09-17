package pt.folque.easuy.templates;

import pt.folque.easuy.model.Product;
import pt.folque.easuy.model.User;

/**
 *
 * @author Diogo Teixeira
 */
public class MailTemplate {
    
    public static String registration(User user){
        String msg = 
                "Your account has been successfully registered.\n\n"
                + "Your account information is:\n"
                + "Email: "
                + user.getEmail() + "\n"
                + "Password: "
                + "It's a secret\n\n"
                + "Easuy team";
        
        return msg;
    }
    
    public static String order(Product product){
        String msg = 
                "Your order of " + product.getName() + " has been successfull processed.\n\n"
                + "Thank you for using our service.\n\n"
                + "Easuy team";
        
        return msg;
    }
    
}
