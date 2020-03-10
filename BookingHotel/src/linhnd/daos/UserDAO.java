/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.daos;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
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
}
