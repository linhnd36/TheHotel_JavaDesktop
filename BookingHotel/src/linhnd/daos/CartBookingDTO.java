/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class CartBookingDTO implements Serializable {

    private String idHotel, nameHotel, idKindOfRoom, namekindOfRoom, numberOfDate, numberOfRoom, total;
    private Date dateFrom, dateTo;

    public CartBookingDTO() {
    }

    public CartBookingDTO(String idHotel, String nameHotel, String idKindOfRoom, String namekindOfRoom, String numberOfDate, String numberOfRoom, String total, Date dateFrom, Date dateTo) {
        this.idHotel = idHotel;
        this.nameHotel = nameHotel;
        this.idKindOfRoom = idKindOfRoom;
        this.namekindOfRoom = namekindOfRoom;
        this.numberOfDate = numberOfDate;
        this.numberOfRoom = numberOfRoom;
        this.total = total;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
    public Vector toVector(){
        Vector v = new Vector();
        v.add(nameHotel);
        v.add(namekindOfRoom);
        v.add(new SimpleDateFormat("dd-MM-yyy").format(dateFrom));
        v.add(numberOfDate);
        v.add(numberOfRoom);
        v.add(total);
        return v;
    }
    public String getNameHotel() {
        return nameHotel;
    }

    public String getNamekindOfRoom() {
        return namekindOfRoom;
    }

    public void setNameHotel(String nameHotel) {
        this.nameHotel = nameHotel;
    }

    public void setNamekindOfRoom(String namekindOfRoom) {
        this.namekindOfRoom = namekindOfRoom;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public String getIdKindOfRoom() {
        return idKindOfRoom;
    }

    public String getNumberOfDate() {
        return numberOfDate;
    }

    public String getNumberOfRoom() {
        return numberOfRoom;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    public void setIdKindOfRoom(String idKindOfRoom) {
        this.idKindOfRoom = idKindOfRoom;
    }

    public void setNumberOfDate(String numberOfDate) {
        this.numberOfDate = numberOfDate;
    }

    public void setNumberOfRoom(String numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

}
