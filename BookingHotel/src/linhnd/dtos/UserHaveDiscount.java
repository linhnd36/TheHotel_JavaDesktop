/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Duc Linh
 */
@Entity
@Table(name = "UserHaveDiscount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHaveDiscount.findAll", query = "SELECT u FROM UserHaveDiscount u")
    , @NamedQuery(name = "UserHaveDiscount.findByStatusUserDis", query = "SELECT u FROM UserHaveDiscount u WHERE u.statusUserDis = :statusUserDis")
    , @NamedQuery(name = "UserHaveDiscount.findByUsername", query = "SELECT u FROM UserHaveDiscount u WHERE u.userHaveDiscountPK.username = :username")
    , @NamedQuery(name = "UserHaveDiscount.findByCodeDiscount", query = "SELECT u FROM UserHaveDiscount u WHERE u.userHaveDiscountPK.codeDiscount = :codeDiscount")})
public class UserHaveDiscount implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHaveDiscountPK userHaveDiscountPK;
    @Basic(optional = false)
    @Column(name = "statusUserDis")
    private String statusUserDis;
    @JoinColumn(name = "codeDiscount", referencedColumnName = "codeDiscount", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Discount discount;
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public UserHaveDiscount() {
    }

    public UserHaveDiscount(UserHaveDiscountPK userHaveDiscountPK) {
        this.userHaveDiscountPK = userHaveDiscountPK;
    }

    public UserHaveDiscount(UserHaveDiscountPK userHaveDiscountPK, String statusUserDis) {
        this.userHaveDiscountPK = userHaveDiscountPK;
        this.statusUserDis = statusUserDis;
    }

    public UserHaveDiscount(String username, String codeDiscount) {
        this.userHaveDiscountPK = new UserHaveDiscountPK(username, codeDiscount);
    }

    public UserHaveDiscountPK getUserHaveDiscountPK() {
        return userHaveDiscountPK;
    }

    public void setUserHaveDiscountPK(UserHaveDiscountPK userHaveDiscountPK) {
        this.userHaveDiscountPK = userHaveDiscountPK;
    }

    public String getStatusUserDis() {
        return statusUserDis;
    }

    public void setStatusUserDis(String statusUserDis) {
        this.statusUserDis = statusUserDis;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userHaveDiscountPK != null ? userHaveDiscountPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHaveDiscount)) {
            return false;
        }
        UserHaveDiscount other = (UserHaveDiscount) object;
        if ((this.userHaveDiscountPK == null && other.userHaveDiscountPK != null) || (this.userHaveDiscountPK != null && !this.userHaveDiscountPK.equals(other.userHaveDiscountPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.UserHaveDiscount[ userHaveDiscountPK=" + userHaveDiscountPK + " ]";
    }
    
}
