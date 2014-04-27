/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Diogo
 */
@ManagedBean(name="menu")
@SessionScoped
public class MenuMBean {

    private List<String> activeList;
    public MenuMBean() {
        activeList = new ArrayList<String>();
        activeList.add("/list.xhtml");
        activeList.add("/history.xhtml");
    }
    
    public List<String> getActiveList(){
        return activeList;
    }
    
}
