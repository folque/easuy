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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import pt.folque.easuy.enums.UserLogType;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "user_log")
@NamedQueries({
    @NamedQuery(name = "UserLog.findAll", query = "SELECT u FROM UserLog u"),
    @NamedQuery(name = "UserLog.findByUserId", query = "SELECT u FROM UserLog u WHERE u.userLogPK.userId = :userId"),
    @NamedQuery(name = "UserLog.findByDate", query = "SELECT u FROM UserLog u WHERE u.userLogPK.date = :date"),
    @NamedQuery(name = "UserLog.findByType", query = "SELECT u FROM UserLog u WHERE u.type = :type")})
public class UserLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserLogPK userLogPK;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserLogType type;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserLog() {
    }

    public UserLog(UserLogPK userLogPK) {
        this.userLogPK = userLogPK;
    }

    public UserLog(long userId, Date date) {
        this.userLogPK = new UserLogPK(userId, date);
    }

    public UserLogPK getUserLogPK() {
        return userLogPK;
    }

    public void setUserLogPK(UserLogPK userLogPK) {
        this.userLogPK = userLogPK;
    }

    public UserLogType getType() {
        return type;
    }

    public void setType(UserLogType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userLogPK != null ? userLogPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLog)) {
            return false;
        }
        UserLog other = (UserLog) object;
        if ((this.userLogPK == null && other.userLogPK != null) || (this.userLogPK != null && !this.userLogPK.equals(other.userLogPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.folque.easuy.model.UserLog[ userLogPK=" + userLogPK + " ]";
    }
    
}
