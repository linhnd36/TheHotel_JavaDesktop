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
 * @author PC
 */
@Entity
@Table(name = "KindOfRoom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KindOfRoom.findAll", query = "SELECT k FROM KindOfRoom k")
    , @NamedQuery(name = "KindOfRoom.findByIdKindRoom", query = "SELECT k FROM KindOfRoom k WHERE k.idKindRoom = :idKindRoom")
    , @NamedQuery(name = "KindOfRoom.findByNameKindRoom", query = "SELECT k FROM KindOfRoom k WHERE k.nameKindRoom = :nameKindRoom")
    , @NamedQuery(name = "KindOfRoom.findByNumberOfPeopleRoom", query = "SELECT k FROM KindOfRoom k WHERE k.numberOfPeopleRoom = :numberOfPeopleRoom")
    , @NamedQuery(name = "KindOfRoom.findByDesRoom", query = "SELECT k FROM KindOfRoom k WHERE k.desRoom = :desRoom")
    , @NamedQuery(name = "KindOfRoom.findByPriceOfRoom", query = "SELECT k FROM KindOfRoom k WHERE k.priceOfRoom = :priceOfRoom")})
public class KindOfRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IdKindRoom")
    private String idKindRoom;
    @Basic(optional = false)
    @Column(name = "nameKindRoom")
    private String nameKindRoom;
    @Basic(optional = false)
    @Column(name = "numberOfPeopleRoom")
    private int numberOfPeopleRoom;
    @Column(name = "desRoom")
    private String desRoom;
    @Basic(optional = false)
    @Column(name = "priceOfRoom")
    private String priceOfRoom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kindOfRoom")
    private Collection<RoomInHotel> roomInHotelCollection;

    public KindOfRoom() {
    }
    public Vector toVectorTypeRoom(){
        Vector v = new Vector();
        v.add(idKindRoom);
        v.add(nameKindRoom);
        v.add(numberOfPeopleRoom);
        v.add(priceOfRoom);
        return v;
    }

    public KindOfRoom(String idKindRoom) {
        this.idKindRoom = idKindRoom;
    }

    public KindOfRoom(String idKindRoom, String nameKindRoom, int numberOfPeopleRoom, String priceOfRoom) {
        this.idKindRoom = idKindRoom;
        this.nameKindRoom = nameKindRoom;
        this.numberOfPeopleRoom = numberOfPeopleRoom;
        this.priceOfRoom = priceOfRoom;
    }

    public String getIdKindRoom() {
        return idKindRoom;
    }

    public void setIdKindRoom(String idKindRoom) {
        this.idKindRoom = idKindRoom;
    }

    public String getNameKindRoom() {
        return nameKindRoom;
    }

    public void setNameKindRoom(String nameKindRoom) {
        this.nameKindRoom = nameKindRoom;
    }

    public int getNumberOfPeopleRoom() {
        return numberOfPeopleRoom;
    }

    public void setNumberOfPeopleRoom(int numberOfPeopleRoom) {
        this.numberOfPeopleRoom = numberOfPeopleRoom;
    }

    public String getDesRoom() {
        return desRoom;
    }

    public void setDesRoom(String desRoom) {
        this.desRoom = desRoom;
    }

    public String getPriceOfRoom() {
        return priceOfRoom;
    }

    public void setPriceOfRoom(String priceOfRoom) {
        this.priceOfRoom = priceOfRoom;
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
        hash += (idKindRoom != null ? idKindRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KindOfRoom)) {
            return false;
        }
        KindOfRoom other = (KindOfRoom) object;
        if ((this.idKindRoom == null && other.idKindRoom != null) || (this.idKindRoom != null && !this.idKindRoom.equals(other.idKindRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "linhnd.dtos.KindOfRoom[ idKindRoom=" + idKindRoom + " ]";
    }
    
}
