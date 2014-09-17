package pt.folque.easuy.ejb.impl;

import java.security.Principal;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import pt.folque.easuy.ejb.AuthEBean;

/**
 *
 * @author Diogo Teixeira
 */
@Stateless
@LocalBean
public class AuthEBeanImpl implements AuthEBean {
    
    @Resource
    private SessionContext sessionContext;
    
    @Override
    public Principal getPrincipal(){
        Principal principal = sessionContext.getCallerPrincipal();
        return principal;
    }
    
    
}
