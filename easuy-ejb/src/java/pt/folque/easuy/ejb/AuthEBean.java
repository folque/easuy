/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.ejb;

import java.security.Principal;

/**
 *
 * @author Diogo
 */
public interface AuthEBean {
    
    public Principal getPrincipal();
    
}
