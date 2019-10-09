package controller;

import model.PlayerEntity;
import org.hibernate.Session;

/**
 *
 * @author Heidi
 */
public class Database {
    
    int height, width;

    
    public PlayerEntity getPlayerEntity(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        //third load() method example
        PlayerEntity playerE = new PlayerEntity();
        session.load(playerE , name);
        System.out.println(playerE.getName() + " " + playerE.getStandingHeight());

        session.getTransaction().commit();
        return playerE;
    }
    
}
