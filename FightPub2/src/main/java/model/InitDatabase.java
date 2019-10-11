
package model;

import controller.HibernateUtil;
import model.PlayerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import controller.HibernateUtil;
import java.io.Serializable;
import org.hibernate.SessionFactory;
/**
 * This class adds characters to the Hahmo-table 
 * @author Heidi
 */
public class InitDatabase {
    public InitDatabase() {
        
        SessionFactory sessionf = HibernateUtil.getSessionFactory();
        Session session = sessionf.getCurrentSession();
        Transaction tx = null;
        

        try {
            tx = session.beginTransaction();
            PlayerEntity pEntity = new PlayerEntity(1, PlayerEntity.Facing.RIGHT);
            pEntity.setName("Pekka");
            pEntity.setHealth(5);
            pEntity.setStandingHeight(400);
            pEntity.setStandingWidth(200);

            //Save the employee in database
            session.save(pEntity);
            
            PlayerEntity pEntity2 = new PlayerEntity(1, PlayerEntity.Facing.RIGHT);
            pEntity2.setName("Jukka");
            pEntity2.setHealth(5);
            pEntity2.setStandingHeight(400);
            pEntity2.setStandingWidth(200);

            //Save the employee in database
            session.save(pEntity2);

            //Commit the transaction
            session.getTransaction().commit();
            }

        catch (Exception e) {
           if (tx!=null) tx.rollback();
           e.printStackTrace(); 
        } finally {
           session.close();
        }
    }

}
    
    
              
