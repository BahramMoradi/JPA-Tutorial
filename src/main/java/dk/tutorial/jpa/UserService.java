/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.tutorial.jpa;

import javax.persistence.EntityManager;

/**
 *
 * @author Bahram
 */
public class UserService {
    
    private EntityManager entityManager;
    
    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public User createUser(int id, String name, int age) {
        User u = new User();
        u.setName(name);
        u.setAge(age);
        entityManager.persist(u);
        return u;
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
    
}
