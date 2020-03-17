/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Duc Linh
 */
public class RoomInHotelDAO implements Serializable {
    
    EntityManager em = null;
    
    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }
    
    public int countRoomInHotelByHotelid(String idHotel) throws Exception {
        em = getEntityManager();
        int count = 0;
        try {
            Query query = em.createQuery("SELECT COUNT(r.roomInHotelPK.codeRoom) FROM RoomInHotel r WHERE r.hotel.hotelID = ?1 ");
            //Đếm xem có bao nhiêu phòng trong khách sạn bằng iDHotel trong bảng Room in Hotel
            query.setParameter(1, idHotel);
            count = Integer.parseInt(query.getSingleResult().toString());
        } finally {
            em.close();
        }
        return count;
    }
    
    public int countOfRoomInHotel(String idKindOfRoom) throws Exception {
        int count = -1;
        em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(r.kindOfRoom) FROM RoomInHotel r WHERE r.kindOfRoom.idKindRoom = ?1 ");
            query.setParameter(1, idKindOfRoom);
            count = Integer.parseInt(query.getSingleResult().toString());
        } finally {
            em.close();
        }
        return count;
    }
    // Kiểm tra lại ==============================================================
    // Đếm số phòng của 1 loại phòng trong 1 khách sạn của 1 booking
    public int countKindOfRoomBooking(String idKindOfRoom, String idHotel, String idBooking) throws Exception {
        int count = 0;
        em = getEntityManager();
        try {
            Query query = em.createQuery(" SELECT SUM(d.numberOfNice) FROM DetailBooking d where d.booking.idBooking = ?1 AND d.hotel.hotelID = ?2 AND d.idKindOfRoom = ?3");
            // tính tổng các phòng đc book 1 loại phòng 1 khách sạn 1 booking
            query.setParameter(1, idBooking);
            query.setParameter(2, idHotel);
            query.setParameter(1, idKindOfRoom);
            count = (int) query.getSingleResult();
        } finally {
            em.close();
        }
        return count;
    }
    
}
