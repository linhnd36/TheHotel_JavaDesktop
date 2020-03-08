/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import linhns.dtos.Hotel;

/**
 *
 * @author Duc Linh
 */
public class HotelDAO implements Serializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookingHotelPU");
    EntityManager em = emf.createEntityManager();

    public HotelDAO() {
    }

    public List<Hotel> findHotel() throws Exception {
        List<Hotel> result = null;
        try {
            //Query query = em.createQuery("SELECT DISTINCT h FROM Hotel h,RoomInHotel r WHERE r.dateRoomFrom = ?1 AND r.dateRoomTo <= '2020-04-02' OR r.statusRoom = 'ready' and h.statusHotel='active' ",Hotel.class);
            Query query = em.createQuery("SELECT DISTINCT h FROM Hotel h,RoomInHotel r WHERE h.hotelID = r.hotel.hotelID and r.statusRoom = ?1 and r.dateRoomFrom >= ?2 ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            Date date = simpleDateFormat.parse("2020-04-01");
            query.setParameter(1, "checking");
            query.setParameter(2, date, TemporalType.DATE);

            result = query.getResultList();
            for (Hotel hotel : result) {
                System.out.println(hotel.getNameHotel());
            }
        } catch (Exception e) {
            em.close();
        }
        return result;
    }
}
