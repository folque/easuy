package pt.folque.easuy.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diogo Teixeira
 */
@Entity
@Table(name = "user_product")
@NamedQueries({
    @NamedQuery(name = "UserProduct.findAll", query = "SELECT u FROM UserProduct u ORDER BY u.date DESC"),
    @NamedQuery(name = "UserProduct.findByProductId", query = "SELECT u FROM UserProduct u WHERE u.product.id = :productId"),
    @NamedQuery(name = "UserProduct.findByUserId", query = "SELECT u FROM UserProduct u WHERE u.user.id = :userId ORDER BY u.date DESC"),
    @NamedQuery(name = "UserProduct.findByDate", query = "SELECT u FROM UserProduct u WHERE u.date = :date"),
    @NamedQuery(name = "UserProduct.findByProductAndUser", query = "SELECT u FROM UserProduct u WHERE u.product.id = :productId AND u.user.id = :userId"),
    @NamedQuery(name = "UserProduct.findbyUserAndPurchased", query = "SELECT u FROM UserProduct u WHERE u.user.id = :userId AND u.purchased = :purchased ORDER BY u.date DESC")})
public class UserProduct implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    @Column(name = "purchased")
    private Boolean purchased;
    
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;
    
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Product product;

    public UserProduct() {
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


    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

    public UserProduct(Long id) {
        this.id = id;
    }

    public UserProduct(Long id, Date date) {
        this.id = id;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "pt.folque.easuy.model.UserProduct[ id=" + id + " product=" + product + " user=" + user +  "date=" + date + "purchased=" + purchased + "]";
    }
    
}