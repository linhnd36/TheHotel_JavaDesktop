/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import linhnd.dtos.DetailBooking;
import linhnd.dtos.DetailBookingPK;

/**
 *
 * @author Duc Linh
 */
public class DetailBookingDAO implements Serializable {

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }

    ;
    
    public int countRoomInDetailByIdBooking(String idBooking) throws Exception {
        EntityManager em = getEntityManager();
        int count = 0;
        try {
            Query query = em.createQuery(" SELECT SUM(d.numberOfRoom) FROM DetailBooking d WHERE d.booking.idBooking = ?1 ");
            // Đếm số lượng phòng được booking bằng idBooking
            query.setParameter(1, idBooking);
            count = Integer.parseInt(query.getSingleResult().toString());
        } finally {
            em.close();
        }
        return count;
    }

    public boolean insertDetailBooking(DetailBooking dto) throws Exception {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dto);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Exception commit DetailBooking :", e);
            e.printStackTrace();
        } finally {
            em.close();
        }
        return true;
    }

}
