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
 * @author PC
 */
@Entity
@Table(name = "DetailBooking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailBooking.findAll", query = "SELECT d FROM DetailBooking d")
    , @NamedQuery(name = "DetailBooking.findByCodeRoom", query = "SELECT d FROM DetailBooking d WHERE d.codeRoom = :codeRoom")
    , @NamedQuery(name = "DetailBooking.findByNumberOfRoom", query = "SELECT d FROM DetailBooking d WHERE d.numberOfRoom = :numberOfRoom")
    , @NamedQuery(name = "DetailBooking.findByPriceDetail", query = "SELECT d FROM DetailBooking d WHERE d.priceDetail = :priceDetail")
    , @NamedQuery(name = "DetailBooking.findByHotelID", query = "SELECT d FROM DetailBooking d WHERE d.detailBookingPK.hotelID = :hotelID")
    , @NamedQuery(name = "DetailBooking.findByIdBooking", query = "SELECT d FROM DetailBooking d WHERE d.detailBookingPK.idBooking = :idBooking")
    , @NamedQuery(name = "DetailBooking.findByIdKindOfRoom", query = "SELECT d FROM DetailBooking d WHERE d.detailBookingPK.idKindOfRoom = :idKindOfRoom")})
public class DetailBooking implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetailBookingPK detailBookingPK;
    @Column(name = "codeRoom")
    private String codeRoom;
    @Basic(optional = false)
    @Column(name = "numberOfRoom")
    private int numberOfRoom;
    @Basic(optional = false)
    @Column(name = "priceDetail")
    private String priceDetail;
    @JoinColumn(name = "IdBooking", referencedColumnName = "IdBooking", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Booking booking;
    @JoinColumn(name = "hotelID", referencedColumnName = "hotelID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hotel hotel;

    public DetailBooking() {
    }

    public DetailBooking(DetailBookingPK detailBookingPK) {
        this.detailBookingPK = detailBookingPK;
    }

    public DetailBooking(DetailBookingPK detailBookingPK, int numberOfRoom, String priceDetail) {
        this.detailBookingPK = detailBookingPK;
        this.numberOfRoom = numberOfRoom;
        this.priceDetail = priceDetail;
        this.codeRoom = "";
    }

    public DetailBooking(String hotelID, String idBooking, String idKindOfRoom) {
        this.detailBookingPK = new DetailBookingPK(hotelID, idBooking, idKindOfRoom);
    }

    public DetailBookingPK getDetailBookingPK() {
        return detailBookingPK;
    }

    public void setDetailBookingPK(DetailBookingPK detailBookingPK) {
        this.detailBookingPK = detailBookingPK;
    }

    public String getCodeRoom() {
        return codeRoom;
    }

    public void setCodeRoom(String codeRoom) {
        this.codeRoom = codeRoom;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public String getPriceDetail() {
        return priceDetail;
    }

    public void setPriceDetail(String priceDetail) {
        this.priceDetail = priceDetail;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detailBookingPK != null ? detailBookingPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailBooking)) {
            return false;
        }
        DetailBooking other = (DetailBooking) object;
        if ((this.detailBookingPK == null && other.detailBookingPK != null) || (this.detailBookingPK != null && !this.detailBookingPK.equals(other.detailBookingPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.DetailBooking[ detailBookingPK=" + detailBookingPK + " ]";
    }

}
