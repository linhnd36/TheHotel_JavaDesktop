/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import linhnd.dtos.UserDTO;
import linhnd.dtos.Users;

/**
 *
 * @author Duc Linh
 */
public class UserDAO implements Serializable{
    
    EntityManager em = null;
    
    private EntityManager getEntityManager(){
        return Persistence.createEntityManagerFactory("BookingHotelPU").createEntityManager();
    }
    
    public String checkLogin(String username, String password) throws Exception{
        String check = "failed"; 
        em = getEntityManager();
        try {
            Users user = em.find(Users.class, username);
            if (user.getPassword().equals(password)) {
                check = user.getRoleUser();
                UserDTO.Username = user.getUsername();
            }
        }finally{
            em.close();
        }
        return check;
    }
    public boolean checkUsername(String username) throws Exception{
        em = getEntityManager();
        boolean check = true;
        try {
            Query query = em.createQuery("SELECT u.username FROM Users u WHERE u.username = ?1  ");
            query.setParameter(1, username);
            List<String> result = query.getResultList();
            if (result.isEmpty()) {
                check = false;
            }
        }finally{
            em.close();
        }
        return check;
    }
    
    public boolean insertUser(Users dto) throws Exception{
        em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dto);
            em.getTransaction().commit();
            
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE,"exception caught",e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return true;
    }
}
