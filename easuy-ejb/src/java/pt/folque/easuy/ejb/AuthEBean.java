package pt.folque.easuy.ejb;

import java.security.Principal;

/**
 *
 * @author Diogo Teixeira
 */
public interface AuthEBean {
    
    // Returns the principal object
    public Principal getPrincipal();
    
}
