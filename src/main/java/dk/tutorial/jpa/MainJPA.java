/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.tutorial.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bahram
 */
public class MainJPA {
    public static void main(String[] args) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("UserService");
        EntityManager em=emf.createEntityManager();
        UserService service=new UserService((em));
        
        //create and presist a user
        em.getTransaction().begin();
        User b=service.createUser(1, "Bahram Moradi", 35);
        User d=service.createUser(1, "Diman Moradi", 34);
        User n=service.createUser(1, "Naser Moradi", 29);
        em.getTransaction().commit();
        System.err.println(d.toString());
        System.err.println(b.toString());
        System.err.println(n.toString());
    }
    
}
