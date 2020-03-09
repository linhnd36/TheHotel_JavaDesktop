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
public class RoomInHotelDAO implements Serializable{
    private EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }
    
    public int countRoomInHotelByHotelid(String idHotel) throws Exception{
        EntityManager em = getEntityManager();
        int count = 0;
        try {
            Query query = em.createQuery("SELECT COUNT(r.roomInHotelPK.codeRoom) FROM RoomInHotel r WHERE r.hotel.hotelID = ?1 ");
            query.setParameter(1, idHotel);
            count = Integer.parseInt(query.getSingleResult().toString());
        }finally{
            em.close();
        }
        return count;
    }
}
