/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import pt.folque.easuy.enums.UserLogType;

/**
 *
 * @author Diogo
 */
@Embeddable
public class UserLogPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private long userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private UserLogType type;

    public UserLogPK() {
    }

    public UserLogPK(long userId, Date date, UserLogType type) {
        this.userId = userId;
        this.date = date;
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserLogType getType() {
        return type;
    }

    public void setType(UserLogType type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (date != null ? date.hashCode() : 0);
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserLogPK)) {
            return false;
        }
        UserLogPK other = (UserLogPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        if ((this.date == null && other.date != null) || (this.date != null && !this.date.equals(other.date))) {
            return false;
        }
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.folque.easuy.model.UserLogPK[ userId=" + userId + ", date=" + date + ", type=" + type + " ]";
    }
    
}
