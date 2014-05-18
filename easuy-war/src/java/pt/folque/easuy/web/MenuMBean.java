/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Diogo
 */
@Named("menu")
@SessionScoped
public class MenuMBean implements Serializable{
    
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
            
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
