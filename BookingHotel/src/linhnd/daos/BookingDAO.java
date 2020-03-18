/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import linhnd.dtos.Booking;

/**
 *
 * @author Duc Linh
 */
public class BookingDAO implements Serializable {

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }

    public BookingDAO() {
    }

    public List<Booking> getListBookingNotValid(Date dateFrom, Date dateTo) throws Exception {
        EntityManager em = getEntityManager();
        List<Booking> resutl = null;
        try {
            Query query = em.createQuery("SELECT b FROM Booking b WHERE b.idBooking NOT IN (SELECT b.idBooking FROM Booking b WHERE b.dateBookingFrom >= :dateCheckOut OR b.dateBookingTo <= :dateCheckIn ) AND b.statusBooking = 'checking' ");
            query.setParameter("dateCheckOut", dateTo, TemporalType.DATE);
            query.setParameter("dateCheckIn", dateFrom, TemporalType.DATE);
            resutl = query.getResultList();
        } finally {
            em.close();
        }
        return resutl;
        //trả về list booking có trong 2 ngày AB
    }

    public List<Booking> getListBookingInHotel(Date dateFrom, Date dateTo, String idHotel) throws Exception {
        EntityManager em = getEntityManager();
        List<Booking> resutl = null;
        try {
            Query query = em.createQuery("SELECT b FROM Booking b,DetailBooking d WHERE b.idBooking NOT IN (SELECT b.idBooking FROM Booking b WHERE b.dateBookingFrom >= :dateCheckOut OR b.dateBookingTo <= :dateCheckIn ) AND b.statusBooking = 'checking' AND b.idBooking = d.booking.idBooking AND d.hotel.hotelID = :IdHotel ");
            query.setParameter("dateCheckOut", dateTo, TemporalType.DATE);
            query.setParameter("dateCheckIn", dateFrom, TemporalType.DATE);
            query.setParameter("IdHotel", idHotel);
            resutl = query.getResultList();
        } finally {
            em.close();
        }
        return resutl;
        //trả về list booking của 1 khách sạn trong 2 ngày AB
    }

    // lấy những booking đang có ở ngày now và check phòng xem còn không thì mới show lên firstController
    public List<Booking> getListBookingNow() throws Exception {
        EntityManager em = getEntityManager();
        List<Booking> result = null;
        Date date = new Date();
        try {
            Query query = em.createQuery("SELECT b FROM Booking b WHERE b.dateBookingFrom < :date AND :date < b.dateBookingTo ");
            query.setParameter("date", date, TemporalType.DATE);
            result = query.getResultList();
        } finally {
            em.close();
        }
        return result;

    }

    public boolean insertBooking(Booking dto) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dto);
            em.getTransaction().commit();

        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ex);
            ex.printStackTrace();
        } finally {
            em.close();
        }
        return true;
    }

    public List<Booking> getListBookingbyUsername(String username) throws Exception {
        EntityManager em = getEntityManager();
        List<Booking> result = null;
        try {
            result = em.createQuery("SELECT b FROM Booking b WHERE b.username.username = ?1 ").setParameter(1, username).getResultList();
        } finally {
            em.close();
        }
        return result;
    }


    public boolean updateStatusBooking(String idBooking) throws Exception {
        EntityManager em = getEntityManager();
        boolean check = false;
        try {
            Booking dto = em.find(Booking.class, idBooking);
            dto.setStatusBooking("delete");
            em.getTransaction().begin();
            em.merge(dto);
            em.getTransaction().commit();
            check = true;
        } finally {
            em.close();
        }
        return check;
    }

    public List<Booking> getListBookingbySerarch(String username, String search) throws Exception {
        EntityManager em = getEntityManager();
        List<Booking> result = null;
        try {
            Query query = em.createQuery("SELECT b FROM Booking b,DetailBooking d WHERE b.username.username = ?1 AND b.idBooking = d.booking.idBooking AND d.hotel.nameHotel LIKE ?2 ");
            query.setParameter(1, username);
            query.setParameter(2, "%" + search + "%");
            result = query.getResultList();

        } finally {
            em.close();
        }
        return result;
    }


    public List<Booking> getListBookingbySerarch(String username, String search, Date dateFrom, Date dateTo) throws Exception {
        EntityManager em = getEntityManager();
        List<Booking> result = null;
        try {
            Query query = em.createQuery("SELECT b FROM Booking b,DetailBooking d WHERE b.username.username = ?1 AND b.idBooking = d.booking.idBooking AND d.hotel.nameHotel LIKE ?2 AND b.dateBookingFrom > ?3 AND b.dateBookingTo < ?4");
            query.setParameter(1, username);
            query.setParameter(2, "%" + search + "%");
            query.setParameter(3, dateFrom);
            query.setParameter(4, dateTo);
            result = query.getResultList();

        } finally {
            em.close();
        }
        return result;
    }

    public List<Booking> getListBookingbySerarch(String username, Date dateFrom, Date dateTo) throws Exception {
        EntityManager em = getEntityManager();
        List<Booking> result = null;
        try {
            Query query = em.createQuery("SELECT b FROM Booking b,DetailBooking d WHERE b.username.username = ?1 AND b.idBooking = d.booking.idBooking AND b.dateBookingFrom > ?3 AND b.dateBookingTo < ?4");
            query.setParameter(1, query);
            query.setParameter(3, dateFrom);
            query.setParameter(4, dateTo);
            result = query.getResultList();

        } finally {
            em.close();
        }
        return result;
    }

}
