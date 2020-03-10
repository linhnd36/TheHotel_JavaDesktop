/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import linhnd.dtos.Booking;
import linhnd.dtos.Hotel;

/**
 *
 * @author Duc Linh
 */
public class HotelDAO implements Serializable {

    EntityManager em = null;

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }

    public HotelDAO() {
    }

    public Hotel getHotelByID(String id) throws Exception{
        em = getEntityManager();
        Hotel dto = null;
        try {
            dto = em.find(Hotel.class, id);
        }finally{
            em.close();
        }
        return dto;
    }

    public Map<String, String> getIdHotelByIdBooking(List<Booking> listBooking) throws Exception {
        em = getEntityManager();
        Map<String, String> result = new HashMap<>();
        try {
            Query query = em.createQuery("SELECT  h.hotelID FROM Hotel h,DetailBooking db,Booking b WHERE b.idBooking = db.booking.idBooking AND db.hotel.hotelID = h.hotelID AND b.idBooking = ?1 ");
            for (Booking booking : listBooking) {
                query.setParameter(1, booking.getIdBooking());
                String idHotel = query.getSingleResult().toString();
                result.put(booking.getIdBooking(), idHotel);
            }
        } finally {
            em.close();
        }
        return result;
    }

    public List<Hotel> getlistHotelSearch(List<String> listIdHotelNotValid, String textSearch) throws Exception {

        em = getEntityManager();
        List<Hotel> result = null;
        try {
            String jsql = null;
            if (listIdHotelNotValid.isEmpty()) {
                jsql = "SELECT DISTINCT h FROM Hotel h WHERE h.nameHotel LIKE :textSearch OR h.addressHotel LIKE :textSearch ORDER BY h.rateHotel ";
                Query query = em.createQuery(jsql);
                query.setParameter("textSearch", "%" + textSearch + "%");
                result = query.getResultList();
                return result;
            } else {
                jsql = "SELECT DISTINCT h FROM Hotel h WHERE h.hotelID NOT IN (:listHotelNotValid) h.nameHotel LIKE :textSearch OR h.addressHotel LIKE :textSearch ORDER BY h.rateHotel ";
                Query query = em.createQuery(jsql);
                query.setParameter("listHotelNotValid", listIdHotelNotValid);
                query.setParameter("textSearch", "%" + textSearch + "%");
                result = query.getResultList();
                return result;
            }
        } finally {
            em.close();
        }

    }

    public List<Hotel> getListHotelVaildNow(List<String> listIdHotelNotValid) throws Exception {
        em = getEntityManager();
        List<Hotel> result = null;
        try {
            String jsql = null;
            if (listIdHotelNotValid.isEmpty()) {
                jsql = "SELECT h FROM Hotel h ORDER BY h.rateHotel ";
                Query query = em.createQuery(jsql);
                result = query.getResultList();
                return result;
            } else {
                jsql = "SELECT h FROM Hotel h WHERE h.hotelID NOT IN (:listHotelNotValid) ORDER BY h.rateHotel ";
                Query query = em.createQuery(jsql);
                query.setParameter("listHotelNotValid", listIdHotelNotValid);
                result = query.getResultList();
                return result;
            }
        } finally {
            em.close();
        }
    }

}
