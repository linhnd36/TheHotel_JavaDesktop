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
public class RoomInHotelPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codeRoom")
    private String codeRoom;
    @Basic(optional = false)
    @Column(name = "hotelID")
    private String hotelID;
    @Basic(optional = false)
    @Column(name = "IdKindRoom")
    private String idKindRoom;

    public RoomInHotelPK() {
    }

    public RoomInHotelPK(String codeRoom, String hotelID, String idKindRoom) {
        this.codeRoom = codeRoom;
        this.hotelID = hotelID;
        this.idKindRoom = idKindRoom;
    }

    public String getCodeRoom() {
        return codeRoom;
    }

    public void setCodeRoom(String codeRoom) {
        this.codeRoom = codeRoom;
    }

    public String getHotelID() {
        return hotelID;
    }

    public void setHotelID(String hotelID) {
        this.hotelID = hotelID;
    }

    public String getIdKindRoom() {
        return idKindRoom;
    }

    public void setIdKindRoom(String idKindRoom) {
        this.idKindRoom = idKindRoom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeRoom != null ? codeRoom.hashCode() : 0);
        hash += (hotelID != null ? hotelID.hashCode() : 0);
        hash += (idKindRoom != null ? idKindRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomInHotelPK)) {
            return false;
        }
        RoomInHotelPK other = (RoomInHotelPK) object;
        if ((this.codeRoom == null && other.codeRoom != null) || (this.codeRoom != null && !this.codeRoom.equals(other.codeRoom))) {
            return false;
        }
        if ((this.hotelID == null && other.hotelID != null) || (this.hotelID != null && !this.hotelID.equals(other.hotelID))) {
            return false;
        }
        if ((this.idKindRoom == null && other.idKindRoom != null) || (this.idKindRoom != null && !this.idKindRoom.equals(other.idKindRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.RoomInHotelPK[ codeRoom=" + codeRoom + ", hotelID=" + hotelID + ", idKindRoom=" + idKindRoom + " ]";
    }
    
}
