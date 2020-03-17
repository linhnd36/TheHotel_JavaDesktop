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
    //đếm số lượng loại phòng trong 1 khách sạn
    public int countOfRoomInHotel(String idKindOfRoom,String idHotel) throws Exception {
        int count = 0;
        em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(r.kindOfRoom) FROM RoomInHotel r WHERE r.kindOfRoom.idKindRoom = ?1 AND r.hotel.hotelID = ?2 AND r.statusRoom = 'ready' ");
            query.setParameter(1, idKindOfRoom);
            query.setParameter(2, idHotel);
            count = Integer.parseInt(query.getSingleResult().toString());
        } finally {
            em.close();
        }
        return count;
    }


    // Đếm số phòng của 1 loại phòng trong 1 khách sạn của 1 booking
    public int countKindOfRoomBooking(String idKindOfRoom, String idHotel, String idBooking) throws Exception {
        int count = 0;
        em = getEntityManager();
        try {
            Query query = em.createQuery(" SELECT SUM(d.numberOfRoom) FROM DetailBooking d where d.booking.idBooking = ?1 AND d.hotel.hotelID = ?2 AND d.detailBookingPK.idKindOfRoom = ?3 ");
            // tính tổng các phòng đc book 1 loại phòng 1 khách sạn 1 booking
            query.setParameter(1, idBooking);
            query.setParameter(2, idHotel);
            query.setParameter(3, idKindOfRoom);
            if (query.getSingleResult() == null) {
                count = 0;
            } else {
                count = Integer.parseInt(query.getSingleResult().toString());
            }
        } finally {
            em.close();
        }
        return count;
    }

}
