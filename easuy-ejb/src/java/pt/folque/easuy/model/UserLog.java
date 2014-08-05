/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import pt.folque.easuy.enums.UserLogType;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "user_log")
@NamedQueries({
    @NamedQuery(name = "UserLog.findAll", query = "SELECT u FROM UserLog u"),
    @NamedQuery(name = "UserLog.findByUserId", query = "SELECT u FROM UserLog u WHERE u.user.id = :userId"),
    @NamedQuery(name = "UserLog.findByDate", query = "SELECT u FROM UserLog u WHERE u.date = :date"),
    @NamedQuery(name = "UserLog.findByType", query = "SELECT u FROM UserLog u WHERE u.type = :type")})
public class UserLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserLogType type;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

    public UserLog() {
    }

    public Long getId() {
        return id;
    }
    
    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }
     
    public UserLogType getType() {
        return type;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setType(UserLogType type) {
        this.type = type;
    }    
}
