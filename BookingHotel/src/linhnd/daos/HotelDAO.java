/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import linhnd.dtos.Booking;
import linhnd.dtos.Hotel;

/**
 *
 * @author Duc Linh
 */
public class HotelDAO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookingHotelPU");
    EntityManager em = emf.createEntityManager();

    public HotelDAO() {
    }

    public List<Hotel> loadAllHotel() throws Exception {
        List<Hotel> result = null;
        try {
            result = em.createQuery("SELECT h FROM Hotel h WHERE h.statusHotel = 'active' ORDER BY h.rateHotel DESC ").getResultList();
        } finally {
            em.close();
        }
        return result;
    }
    
    public Map<String,String> getIdHotelByIdBooking(List<Booking> listBooking) throws Exception{
        Map<String,String> result = new HashMap<>();
        try {
            Query query = em.createQuery("SELECT  h.hotelID FROM Hotel h,DetailBooking db,Booking b WHERE b.idBooking = db.booking.idBooking AND db.hotel.hotelID = h.hotelID AND b.idBooking = ?1 ");
            for (Booking booking : listBooking) {
                query.setParameter(1, booking.getIdBooking());
                String idHotel = query.getSingleResult().toString();
                result.put(booking.getIdBooking(), idHotel);
            }
        }finally{
            em.close();
        }
        return result;
    }

}
