import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.MapModel;
import model.Character;
import model.HitBox;
import controller.Controller;
import java.awt.event.KeyEvent;
import model.HurtBox;

/**
 *
 * @author Heidi, Pate, Joonas, Antti
 */
public class ControllerTest {

    MapModel map;
    Controller controller;
    HitBox hitBox;
    
    @BeforeEach
    void setUp() {
        map = new MapModel("asd");
        controller = new Controller(new Character(false, "asd"), new Character(true, "asd"), map, 0, 0);
    }

    @Test
    public void startLocation(){
        assertEquals(1200, controller.getCharacter1().getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1800, controller.getCharacter2().getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }

    @Test
    public void turn() {
        assertEquals(Character.Facing.RIGHT , controller.getCharacter1().getFacing() , "Hahmo 1 ei katso vasemmalle lähtöpaikassaan.");
        assertEquals(Character.Facing.LEFT , controller.getCharacter2().getFacing() , "Hahmo 2 ei katso oikealle lähtopaikassaan.");
        controller.getCharacter1().setxCoord(2000);
        assertEquals(Character.Facing.LEFT , controller.getCharacter1().getFacing() , "Hahmo 1 ei katso oikealle liikuttuaan toisen pelaajan ohi.");
        assertEquals(Character.Facing.RIGHT, controller.getCharacter2().getFacing() , "Hahmo 2 ei katso vasemmalle liikuttuaan toisen pelaajan ohi.");
    }
        
    @Test
    public void border() {
        controller.getCharacter1().setxCoord(0);
        controller.checkNextFrame();
        controller.advance();
        assertEquals(50, controller.getCharacter1().getxCoord(), "Hahmo seinän sisällä");
    }
    
   
    @Test
    void characterCollission(){
        controller.getCharacter1().setxCoord(1500);
        controller.getCharacter2().setxCoord(1500);
        assertEquals(true, controller.checkCollision(), "Hahmot ovat toistensa päällä");
        controller.getCharacter1().setxCoord(1000);
        assertEquals(false, controller.checkCollision(), "Hahmojen ei pitäisi olla toistensa päällä");
        
    }
    @Test
    void hitBoxCollision(){
        assertEquals(true, controller.checkHitboxCollision(), "Iskun olisi pitänyt osua hahmo 2:seen.");
        controller.getCharacter2().setxCoord(2800);
        assertEquals(true, controller.checkHitboxCollision(), "Iskun ei pitäisi osua hahmo 2:seen.");
    }
    
    @Test
    void cameraPosition(){
        
    }
    
    @Test
    public void inputs(){
        
    }
}

