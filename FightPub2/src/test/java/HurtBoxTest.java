
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.HurtBox;
import model.Character;
import controller.Controller;
import model.MapModel;

/**
 *
 * @author Heidi, Joonas
 */
public class HurtBoxTest {
    
    static Controller controller;
    static HurtBox hurtBox;
    
    @BeforeAll
    public static void setUpClass() {
        controller = new Controller("asd", "asd2", new MapModel(), 0, 0);
        hurtBox = new HurtBox(20,20,20, 0, 0, controller.getCharacter1());
    }
    
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    void checkCollision() {
        HurtBox h2 = new HurtBox(10, 20, 20, 0, 0, controller.getCharacter2());
        assertEquals(true, controller.checkCollision(), "Boxes should collide");
        h2.setxCoord(1000);
        assertEquals(false, controller.checkCollision(), "Boxes should not collide");
    }

    
}