import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.MapModel;
import Model.Character;
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
        assertEquals(1200, controller.getCharacter(1).getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1800, controller.getCharacter(2).getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }

    @Test
    public void turn() {
        char1.setLocation(2000,0);
        controller.checkNextFrame();
        controller.advance();
        assertEquals(false, char1.getFacingRight(), "Hahmo 1 ei kääntynyt");
        assertEquals(true, char2.getFacingRight(), "Hahmo 2 ei kääntynyt");
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
        controller.getCharacter(1).setxCoord(1480);
        controller.getCharacter(2).setxCoord(1500);
        assertEquals(true, controller.checkCollision(), "Hahmot ovat toistensa päällä");
    }
    
    @Test
    void cameraPosition(){
        
    }
    
    @Test
    public void inputs(){
        
    }
}

