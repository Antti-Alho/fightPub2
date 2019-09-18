
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.HurtBox;
import Model.Character;
import controller.Controller;

/**
 *
 * @author Heidi, Joonas
 */
public class HurtBoxTest {
    
    static Controller controller;
    static HurtBox hurtBox;

    //this class is useless. Dont use controller in a hurtBoxTest. dont test controller methods in a hurtbox test. dont test data classes.
    //for the purposes youre trying to achieve here we have the controllerTest class to use. 
    
    @BeforeAll
    public static void setUpClass() {
        controller = new Controller();
        hurtBox = new HurtBox(20,20,20, 0, 0, controller.getCharacter(1)); //Hurtbox parametrit? ehdotus (xcoord, leveys, korkeus, xoffset, yoffset, omistaja)
   
        
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
        HurtBox h2 = new HurtBox(10, 20, 20, 0, 0, controller.getCharacter(2));
        assertEquals(true, controller.checkCollision(), "Boxes should collide");
        h2.setxCoord(1000);
        assertEquals(false, controller.checkCollision(), "Boxes should not collide");
    }

    
}