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
import linhnd.dtos.Discount;

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

    public Discount getDiscount(String disCode,String username) throws Exception {
        Discount dto = null;
        em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT d FROM Discount d, UserHaveDiscount u WHERE d.codeDiscount = ?1 AND d.statusDiscount = 'active' AND u.users.username = ?2 AND u.discount.codeDiscount = d.codeDiscount ");
            query.setParameter(1, disCode);
            query.setParameter(2, username);
            dto = (Discount) query.getSingleResult();
        } finally {
            em.close();
        }
        return dto;
    }
}
