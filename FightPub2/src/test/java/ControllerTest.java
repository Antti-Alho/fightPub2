import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.MapModel;
import model.Character;
import controller.Controller;
import java.awt.event.KeyEvent;

/**
 *
 * @author Heidi, Pate
 */
public class ControllerTest {

    Character char1;
    Character char2;
    MapModel map;
    Controller controller;
    
    //dont use Character classes instances here pls. only use control classes methods. you can get your desired character with controller.getCharacter.
    
    @BeforeEach
    void setUp() {
        char1 = new Character(true, "enam");
        char2 = new Character(false, "enam");
        map = new MapModel("asd");
        controller = new Controller("Pekka", "Erkki", map, 0, 0);
        
    }

    @Test
    public void startLocation(){
        assertEquals(1200, controller.getCharacter1().getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1800, controller.getCharacter2().getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }

    @Test
    public void turn() {
        assertEquals(Character.Facing.RIGHT , char1.getFacing() , "Hahmo 1 ei katso vasemmalle lähtöpaikassaan.");
        assertEquals(Character.Facing.LEFT , char2.getFacing() , "Hahmo 2 ei katso oikealle lähtopaikassaan.");
        char1.setLocation(2000,0);
        assertEquals(Character.Facing.LEFT , char1.getFacing() , "Hahmo 1 ei katso oikealle liikuttuaan toisen pelaajan ohi.");
        assertEquals(Character.Facing.RIGHT, char2.getFacing() , "Hahmo 2 ei katso vasemmalle liikuttuaan toisen pelaajan ohi.");
    }
        
    @Test
    public void border() {
        char1.setNextLocation(0, 0);
        controller.checkNextFrame();
        controller.advance();
        assertEquals(50, char1.getxCoord(), "Hahmo seinän sisällä");
    }
    
   
    @Test
    void characterCollission(){
        controller.getCharacter1().setxCoord(1500);
        controller.getCharacter2().setxCoord(1500);
        assertEquals(true, controller.checkCollision(), "Hahmot ovat toistensa päällä");
    }
    
    @Test
    void cameraPosition(){
        
    }
    
    @Test
    public void inputs(){
        
    }
}

