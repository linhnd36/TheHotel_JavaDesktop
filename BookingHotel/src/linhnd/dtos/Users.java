/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Duc Linh
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByRoleUser", query = "SELECT u FROM Users u WHERE u.roleUser = :roleUser")
    , @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email")
    , @NamedQuery(name = "Users.findByStatusUser", query = "SELECT u FROM Users u WHERE u.statusUser = :statusUser")
    , @NamedQuery(name = "Users.findByDateCreate", query = "SELECT u FROM Users u WHERE u.dateCreate = :dateCreate")
    , @NamedQuery(name = "Users.findByFullName", query = "SELECT u FROM Users u WHERE u.fullName = :fullName")
    , @NamedQuery(name = "Users.findByAddressUser", query = "SELECT u FROM Users u WHERE u.addressUser = :addressUser")
    , @NamedQuery(name = "Users.findByNumberPhone", query = "SELECT u FROM Users u WHERE u.numberPhone = :numberPhone")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "roleUser")
    private String roleUser;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "statusUser")
    private String statusUser;
    @Basic(optional = false)
    @Column(name = "dateCreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreate;
    @Basic(optional = false)
    @Column(name = "fullName")
    private String fullName;
    @Basic(optional = false)
    @Column(name = "addressUser")
    private String addressUser;
    @Basic(optional = false)
    @Column(name = "numberPhone")
    private String numberPhone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<UserHaveDiscount> userHaveDiscountCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private Collection<Booking> bookingCollection;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, String password, String roleUser, String email, String statusUser, Date dateCreate, String fullName, String addressUser, String numberPhone) {
        this.username = username;
        this.password = password;
        this.roleUser = roleUser;
        this.email = email;
        this.statusUser = statusUser;
        this.dateCreate = dateCreate;
        this.fullName = fullName;
        this.addressUser = addressUser;
        this.numberPhone = numberPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @XmlTransient
    public Collection<UserHaveDiscount> getUserHaveDiscountCollection() {
        return userHaveDiscountCollection;
    }

    public void setUserHaveDiscountCollection(Collection<UserHaveDiscount> userHaveDiscountCollection) {
        this.userHaveDiscountCollection = userHaveDiscountCollection;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.Users[ username=" + username + " ]";
    }
    
}
