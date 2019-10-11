package controller;

import model.PlayerEntity;
import org.hibernate.Session;

/**
 *
 * @author Heidi, Antti
 */
public class Database {
    
    int height, width;

    /**
     * Constructor that loads selected player entity from database.
     * @param name PlayerEntitys name and id same time.
     * @return playerE data
     */
    public PlayerEntity getPlayerEntity(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        PlayerEntity playerE = new PlayerEntity();
        session.load(playerE , name);
        session.getTransaction().commit();
        return playerE;
    }
    
}
