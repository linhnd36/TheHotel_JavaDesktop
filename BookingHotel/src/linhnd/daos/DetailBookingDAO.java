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
import linhnd.dtos.DetailBooking;
import linhnd.dtos.Hotel;

/**
 *
 * @author Duc Linh
 */
public class DetailBookingDAO implements Serializable {

    private EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    };
    
    public int countRoomInDetailByIdBooking(String idBooking) throws Exception{
        EntityManager em = getEntityManager();
        int count = 0;
        try {
            Query query = em.createQuery("SELECT COUNT(d.codeRoom) FROM DetailBooking d WHERE d.booking.idBooking = ?1 ");
            query.setParameter(1, idBooking);
            count = Integer.parseInt(query.getSingleResult().toString());
        }finally{
            em.close();
        }
        return count;
    }


}
