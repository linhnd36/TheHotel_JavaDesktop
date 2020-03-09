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
@Table(name = "Discount")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d")
    , @NamedQuery(name = "Discount.findByCodeDiscount", query = "SELECT d FROM Discount d WHERE d.codeDiscount = :codeDiscount")
    , @NamedQuery(name = "Discount.findByPercentDiscount", query = "SELECT d FROM Discount d WHERE d.percentDiscount = :percentDiscount")
    , @NamedQuery(name = "Discount.findByDateDisFrom", query = "SELECT d FROM Discount d WHERE d.dateDisFrom = :dateDisFrom")
    , @NamedQuery(name = "Discount.findByDateDisTo", query = "SELECT d FROM Discount d WHERE d.dateDisTo = :dateDisTo")
    , @NamedQuery(name = "Discount.findByDesDiscount", query = "SELECT d FROM Discount d WHERE d.desDiscount = :desDiscount")
    , @NamedQuery(name = "Discount.findByStatusDiscount", query = "SELECT d FROM Discount d WHERE d.statusDiscount = :statusDiscount")})
public class Discount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codeDiscount")
    private String codeDiscount;
    @Basic(optional = false)
    @Column(name = "percentDiscount")
    private int percentDiscount;
    @Basic(optional = false)
    @Column(name = "dateDisFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDisFrom;
    @Basic(optional = false)
    @Column(name = "dateDisTo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDisTo;
    @Column(name = "desDiscount")
    private String desDiscount;
    @Column(name = "statusDiscount")
    private String statusDiscount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discount")
    private Collection<UserHaveDiscount> userHaveDiscountCollection;

    public Discount() {
    }

    public Discount(String codeDiscount) {
        this.codeDiscount = codeDiscount;
    }

    public Discount(String codeDiscount, int percentDiscount, Date dateDisFrom, Date dateDisTo) {
        this.codeDiscount = codeDiscount;
        this.percentDiscount = percentDiscount;
        this.dateDisFrom = dateDisFrom;
        this.dateDisTo = dateDisTo;
    }

    public String getCodeDiscount() {
        return codeDiscount;
    }

    public void setCodeDiscount(String codeDiscount) {
        this.codeDiscount = codeDiscount;
    }

    public int getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(int percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public Date getDateDisFrom() {
        return dateDisFrom;
    }

    public void setDateDisFrom(Date dateDisFrom) {
        this.dateDisFrom = dateDisFrom;
    }

    public Date getDateDisTo() {
        return dateDisTo;
    }

    public void setDateDisTo(Date dateDisTo) {
        this.dateDisTo = dateDisTo;
    }

    public String getDesDiscount() {
        return desDiscount;
    }

    public void setDesDiscount(String desDiscount) {
        this.desDiscount = desDiscount;
    }

    public String getStatusDiscount() {
        return statusDiscount;
    }

    public void setStatusDiscount(String statusDiscount) {
        this.statusDiscount = statusDiscount;
    }

    @XmlTransient
    public Collection<UserHaveDiscount> getUserHaveDiscountCollection() {
        return userHaveDiscountCollection;
    }

    public void setUserHaveDiscountCollection(Collection<UserHaveDiscount> userHaveDiscountCollection) {
        this.userHaveDiscountCollection = userHaveDiscountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeDiscount != null ? codeDiscount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discount)) {
            return false;
        }
        Discount other = (Discount) object;
        if ((this.codeDiscount == null && other.codeDiscount != null) || (this.codeDiscount != null && !this.codeDiscount.equals(other.codeDiscount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.Discount[ codeDiscount=" + codeDiscount + " ]";
    }
    
}
