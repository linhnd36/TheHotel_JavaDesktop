/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.dtos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Vector;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Duc Linh
 */
@Entity
@Table(name = "Hotel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h")
    , @NamedQuery(name = "Hotel.findByHotelID", query = "SELECT h FROM Hotel h WHERE h.hotelID = :hotelID")
    , @NamedQuery(name = "Hotel.findByNameHotel", query = "SELECT h FROM Hotel h WHERE h.nameHotel = :nameHotel")
    , @NamedQuery(name = "Hotel.findByAddressHotel", query = "SELECT h FROM Hotel h WHERE h.addressHotel = :addressHotel")
    , @NamedQuery(name = "Hotel.findByRateHotel", query = "SELECT h FROM Hotel h WHERE h.rateHotel = :rateHotel")
    , @NamedQuery(name = "Hotel.findByStatusHotel", query = "SELECT h FROM Hotel h WHERE h.statusHotel = :statusHotel")
    , @NamedQuery(name = "Hotel.findByDesHotel", query = "SELECT h FROM Hotel h WHERE h.desHotel = :desHotel")})
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "hotelID")
    private String hotelID;
    @Basic(optional = false)
    @Column(name = "nameHotel")
    private String nameHotel;
    @Basic(optional = false)
    @Column(name = "addressHotel")
    private String addressHotel;
    @Basic(optional = false)
    @Column(name = "rateHotel")
    private int rateHotel;
    @Basic(optional = false)
    @Column(name = "statusHotel")
    private String statusHotel;
    @Column(name = "desHotel")
    private String desHotel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private Collection<DetailBooking> detailBookingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
    private Collection<RoomInHotel> roomInHotelCollection;

    public Hotel() {
    }

    public Hotel(String hotelID) {
        this.hotelID = hotelID;
    }

    public Hotel(String hotelID, String nameHotel, String addressHotel, int rateHotel, String statusHotel) {
        this.hotelID = hotelID;
        this.nameHotel = nameHotel;
        this.addressHotel = addressHotel;
        this.rateHotel = rateHotel;
        this.statusHotel = statusHotel;
    }
    public Vector toVecterHotel(){
        Vector v = new Vector();
        v.add(nameHotel);
        v.add(addressHotel);
        v.add(rateHotel);
        return  v;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public String getAddressHotel() {
        return addressHotel;
    }

    public void setAddressHotel(String addressHotel) {
        this.addressHotel = addressHotel;
    }

    public int getRateHotel() {
        return rateHotel;
    }

    public void setRateHotel(int rateHotel) {
        this.rateHotel = rateHotel;
    }

    public String getStatusHotel() {
        return statusHotel;
    }

    public void setStatusHotel(String statusHotel) {
        this.statusHotel = statusHotel;
    }

    public String getDesHotel() {
        return desHotel;
    }

    public void setDesHotel(String desHotel) {
        this.desHotel = desHotel;
    }

    @XmlTransient
    public Collection<DetailBooking> getDetailBookingCollection() {
        return detailBookingCollection;
    }

    public void setDetailBookingCollection(Collection<DetailBooking> detailBookingCollection) {
        this.detailBookingCollection = detailBookingCollection;
    }

    @XmlTransient
    public Collection<RoomInHotel> getRoomInHotelCollection() {
        return roomInHotelCollection;
    }

    public void setRoomInHotelCollection(Collection<RoomInHotel> roomInHotelCollection) {
        this.roomInHotelCollection = roomInHotelCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelID != null ? hotelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.hotelID == null && other.hotelID != null) || (this.hotelID != null && !this.hotelID.equals(other.hotelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.Hotel[ hotelID=" + hotelID + " ]";
    }
    
}
