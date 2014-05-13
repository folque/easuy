/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Diogo
 */
@Named("index")
@RequestScoped
public class IndexMBean {

    /**
     * Creates a new instance of IndexMBean
     */
    public IndexMBean() {
    }
    
    public String list(){
        return "list";
    }
    
}
