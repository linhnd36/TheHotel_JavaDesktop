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
 * @author PC
 */
@Embeddable
public class DetailBookingPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "hotelID")
    private String hotelID;
    @Basic(optional = false)
    @Column(name = "IdBooking")
    private String idBooking;
    @Basic(optional = false)
    @Column(name = "IdKindOfRoom")
    private String idKindOfRoom;

    public DetailBookingPK() {
    }

    public DetailBookingPK(String hotelID, String idBooking, String idKindOfRoom) {
        this.hotelID = hotelID;
        this.idBooking = idBooking;
        this.idKindOfRoom = idKindOfRoom;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getIdKindOfRoom() {
        return idKindOfRoom;
    }

    public void setIdKindOfRoom(String idKindOfRoom) {
        this.idKindOfRoom = idKindOfRoom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelID != null ? hotelID.hashCode() : 0);
        hash += (idBooking != null ? idBooking.hashCode() : 0);
        hash += (idKindOfRoom != null ? idKindOfRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailBookingPK)) {
            return false;
        }
        DetailBookingPK other = (DetailBookingPK) object;
        if ((this.hotelID == null && other.hotelID != null) || (this.hotelID != null && !this.hotelID.equals(other.hotelID))) {
            return false;
        }
        if ((this.idBooking == null && other.idBooking != null) || (this.idBooking != null && !this.idBooking.equals(other.idBooking))) {
            return false;
        }
        if ((this.idKindOfRoom == null && other.idKindOfRoom != null) || (this.idKindOfRoom != null && !this.idKindOfRoom.equals(other.idKindOfRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.DetailBookingPK[ hotelID=" + hotelID + ", idBooking=" + idBooking + ", idKindOfRoom=" + idKindOfRoom + " ]";
    }
    
}
