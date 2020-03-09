/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import linhnd.dtos.Booking;
import linhnd.dtos.Hotel;

/**
 *
 * @author Duc Linh
 */
public class BookingDAO implements Serializable{

    private EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }

    public BookingDAO() {
    }
    
    public List<Booking> getListBookingNotValid(Date dateFrom, Date dateTo) throws Exception{
        EntityManager em = getEntityManager();
        List<Booking> resutl = null;
        try {
            Query query =  em.createQuery("SELECT b FROM Booking b WHERE b.idBooking NOT IN (SELECT b.idBooking FROM Booking b WHERE b.dateBookingFrom >= :dateCheckOut OR b.dateBookingTo <= :dateCheckIn ) AND b.statusBooking = 'checking' ");
            query.setParameter("dateCheckOut", dateTo, TemporalType.DATE);
            query.setParameter("dateCheckIn", dateFrom, TemporalType.DATE);
            resutl = query.getResultList();
        } finally{
            em.close();
        }
        return resutl;
        //trả về list booking có trong 2 ngày AB
    }
    

   
}
