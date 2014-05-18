/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.folque.easuy.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Diogo
 */
@Entity
@Table(name = "user_product")
@NamedQueries({
    @NamedQuery(name = "UserProduct.findAll", query = "SELECT up FROM UserProduct up"),
    @NamedQuery(name = "UserProduct.findByProductId", query = "SELECT up FROM UserProduct up WHERE up.userProductPK.productId = :productId"),
    @NamedQuery(name = "UserProduct.findByUserId", query = "SELECT up FROM UserProduct up WHERE up.userProductPK.userId = :userId"),
    @NamedQuery(name = "UserProduct.findByDate", query = "SELECT up FROM UserProduct up WHERE up.userProductPK.date = :date")})
public class UserProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserProductPK userProductPK;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public UserProduct() {
    }

    public UserProduct(UserProductPK userProductPK) {
        this.userProductPK = userProductPK;
    }

    public UserProduct(long productId, long userId, Date date) {
        this.userProductPK = new UserProductPK(productId, userId, date);
    }

    public UserProductPK getUserProductPK() {
        return userProductPK;
    }

    public void setUserProductPK(UserProductPK userProductPK) {
        this.userProductPK = userProductPK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userProductPK != null ? userProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserProduct)) {
            return false;
        }
        UserProduct other = (UserProduct) object;
        if ((this.userProductPK == null && other.userProductPK != null) || (this.userProductPK != null && !this.userProductPK.equals(other.userProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.folque.easuy.model.UserProduct[ userProductPK=" + userProductPK + " ]";
    }
}
