/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import linhnd.dtos.Discount;
import linhnd.dtos.UserHaveDiscount;

/**
 *
 * @author PC
 */
public class DiscountDAO implements Serializable {

    EntityManager em = null;

    private EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }

    public DiscountDAO() {
    }

    public Discount getDiscount(String disCode, String username) throws Exception {
        Date dateNow = new Date();
        Discount dto = null;
        em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT d FROM Discount d, UserHaveDiscount u WHERE d.codeDiscount = ?1 AND d.statusDiscount = 'active' AND u.users.username = ?2 AND u.discount.codeDiscount = d.codeDiscount AND u.statusUserDis = 'ready' AND d.dateDisTo > ?3 ");
            query.setParameter(1, disCode);
            query.setParameter(2, username);
            query.setParameter(3, dateNow, TemporalType.DATE);
            dto = (Discount) query.getSingleResult();
        } finally {
            em.close();
        }
        return dto;
    }

    public boolean updateStatusDiscount(String Username, String codeDiscount) throws Exception {
        boolean check = false;
        em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM UserHaveDiscount u WHERE u.discount.codeDiscount = ?1 AND u.users.username = ?2 ");
            query.setParameter(1, codeDiscount);
            query.setParameter(2, Username);
            UserHaveDiscount dto = (UserHaveDiscount) query.getSingleResult();
            dto.setStatusUserDis("noReady");
            em.getTransaction().begin();
            em.merge(dto);
            em.getTransaction().commit();
            check = true;
        } finally {
            em.close();
        }
        return check;
    }
}
