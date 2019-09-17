
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
    
    private final Controller controller = new Controller();
    private final Character char1 = controller.getCharacter(1);
    private final Character char2 = controller.getCharacter(2);
    private final HurtBox hurtBox = new HurtBox(20,20,20, 0, 0, controller.char1); //Hurtbox parametrit? ehdotus (xcoord, leveys, korkeus, xoffset, yoffset, omistaja)

    
    @BeforeAll
    public static void setUpClass() {
        
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
        HurtBox h2 = new HurtBox(10, 20, 20, 0, 0, controller.char2);
        assertEquals(true, controller.checkCollision(), "Boxes should collide");
        h2.setxCoord(1000);
        assertEquals(false, controller.checkCollision(), "Boxes should not collide");
    }

    
}