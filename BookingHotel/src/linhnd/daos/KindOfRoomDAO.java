/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import linhnd.dtos.KindOfRoom;

/**
 *
 * @author Duc Linh
 */
public class KindOfRoomDAO implements Serializable{
    EntityManager em = null;
    private EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }
    
    
    public List<KindOfRoom> getListKindOfRoom(String IdHotel) throws Exception{
        em = getEntityManager();
        List<KindOfRoom> resultList = null;
        try {
            Query query = em.createQuery("SELECT k FROM KindOfRoom k WHERE k.idKindRoom IN (SELECT DISTINCT r.roomInHotelPK.idKindRoom FROM RoomInHotel r WHERE r.hotel.hotelID = ?1  ) ");
            query.setParameter(1, IdHotel);
            resultList = query.getResultList();
        }finally{
            em.close();
        }
        return resultList;
    }
    public KindOfRoom getDetailKindOfRoom(String idKindRoom) throws Exception{
        em = getEntityManager();
        KindOfRoom result = null;
        try {
            Query query = em.createQuery(" SELECT k FROM KindOfRoom k WHERE k.idKindRoom = ?1 ");
            query.setParameter(1, idKindRoom);
            result = (KindOfRoom) query.getSingleResult();
        }finally{
            em.close();
        }
        return result;
    }
    
    
}
