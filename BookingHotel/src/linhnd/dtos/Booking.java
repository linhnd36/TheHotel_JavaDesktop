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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author PC
 */
@Entity
@Table(name = "Booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
    , @NamedQuery(name = "Booking.findByIdBooking", query = "SELECT b FROM Booking b WHERE b.idBooking = :idBooking")
    , @NamedQuery(name = "Booking.findByDateBookingFrom", query = "SELECT b FROM Booking b WHERE b.dateBookingFrom = :dateBookingFrom")
    , @NamedQuery(name = "Booking.findByDateBookingTo", query = "SELECT b FROM Booking b WHERE b.dateBookingTo = :dateBookingTo")
    , @NamedQuery(name = "Booking.findByStatusBooking", query = "SELECT b FROM Booking b WHERE b.statusBooking = :statusBooking")
    , @NamedQuery(name = "Booking.findByDesBooking", query = "SELECT b FROM Booking b WHERE b.desBooking = :desBooking")
    , @NamedQuery(name = "Booking.findByTotalBooking", query = "SELECT b FROM Booking b WHERE b.totalBooking = :totalBooking")
    , @NamedQuery(name = "Booking.findByNumberOfNice", query = "SELECT b FROM Booking b WHERE b.numberOfNice = :numberOfNice")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdBooking")
    private String idBooking;
    @Basic(optional = false)
    @Column(name = "dateBookingFrom")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBookingFrom;
    @Basic(optional = false)
    @Column(name = "dateBookingTo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBookingTo;
    @Basic(optional = false)
    @Column(name = "statusBooking")
    private String statusBooking;
    @Column(name = "desBooking")
    private String desBooking;
    @Basic(optional = false)
    @Column(name = "totalBooking")
    private String totalBooking;
    @Basic(optional = false)
    @Column(name = "numberOfNice")
    private int numberOfNice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "booking")
    private Collection<DetailBooking> detailBookingCollection;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private Users username;

    public Booking() {
    }

    public Booking(String idBooking) {
        this.idBooking = idBooking;
    }

    public Booking(String idBooking, Date dateBookingFrom, Date dateBookingTo, String statusBooking, String desBooking, String totalBooking, int numberOfNice, Users username) {
        this.idBooking = idBooking;
        this.dateBookingFrom = dateBookingFrom;
        this.dateBookingTo = dateBookingTo;
        this.statusBooking = statusBooking;
        this.desBooking = desBooking;
        this.totalBooking = totalBooking;
        this.numberOfNice = numberOfNice;
        this.username = username;
    }

    

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public Date getDateBookingFrom() {
        return dateBookingFrom;
    }

    public void setDateBookingFrom(Date dateBookingFrom) {
        this.dateBookingFrom = dateBookingFrom;
    }

    public Date getDateBookingTo() {
        return dateBookingTo;
    }

    public void setDateBookingTo(Date dateBookingTo) {
        this.dateBookingTo = dateBookingTo;
    }

    public String getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(String statusBooking) {
        this.statusBooking = statusBooking;
    }

    public String getDesBooking() {
        return desBooking;
    }

    public void setDesBooking(String desBooking) {
        this.desBooking = desBooking;
    }

    public String getTotalBooking() {
        return totalBooking;
    }

    public void setTotalBooking(String totalBooking) {
        this.totalBooking = totalBooking;
    }

    public int getNumberOfNice() {
        return numberOfNice;
    }

    public void setNumberOfNice(int numberOfNice) {
        this.numberOfNice = numberOfNice;
    }

    @XmlTransient
    public Collection<DetailBooking> getDetailBookingCollection() {
        return detailBookingCollection;
    }

    public void setDetailBookingCollection(Collection<DetailBooking> detailBookingCollection) {
        this.detailBookingCollection = detailBookingCollection;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBooking != null ? idBooking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.idBooking == null && other.idBooking != null) || (this.idBooking != null && !this.idBooking.equals(other.idBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.Booking[ idBooking=" + idBooking + " ]";
    }
    
}
