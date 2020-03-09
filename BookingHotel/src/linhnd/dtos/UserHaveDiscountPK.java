/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Duc Linh
 */
@Embeddable
public class UserHaveDiscountPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "codeDiscount")
    private String codeDiscount;

    public UserHaveDiscountPK() {
    }

    public UserHaveDiscountPK(String username, String codeDiscount) {
        this.username = username;
        this.codeDiscount = codeDiscount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCodeDiscount() {
        return codeDiscount;
    }

    public void setCodeDiscount(String codeDiscount) {
        this.codeDiscount = codeDiscount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (codeDiscount != null ? codeDiscount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHaveDiscountPK)) {
            return false;
        }
        UserHaveDiscountPK other = (UserHaveDiscountPK) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        if ((this.codeDiscount == null && other.codeDiscount != null) || (this.codeDiscount != null && !this.codeDiscount.equals(other.codeDiscount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.UserHaveDiscountPK[ username=" + username + ", codeDiscount=" + codeDiscount + " ]";
    }
    
}
