
package fightpub2;

import view.View;
import model.PlayerEntity;
import controller.HibernateUtil;
import model.InitDatabase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        model.InitDatabase initDatabase = new InitDatabase();
        view.View view = new View();
        view.run();
    }
}
