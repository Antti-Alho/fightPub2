
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
import model.HurtBox;

/**
 *
 * @author Heidi, Pate
 */
public class ControllerTest {

    Character char1;
    Character char2;
    MapModel map;
    Controller controller = new Controller(new Character(true, "Pekka"), new Character(false, "Jukka"), new MapModel("Kaisla"),99, 2);
    
    //dont use Character classes instances here pls. only use control classes methods. you can get your desired character with controller.getCharacter.
    
 

    @Test
    public void startLocation(){
        assertEquals(1200, controller.getCharacter1().getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1800, controller.getCharacter2().getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }

    @Test
    public void turn() {
        assertEquals(Character.Facing.RIGHT , char1.getFacing() , "Hahmo 1 ei katso vasemmalle lähtöpaikassaan.");
        assertEquals(Character.Facing.LEFT , char2.getFacing() , "Hahmo 2 ei katso oikealle lähtopaikassaan.");
        char1.setxCoord(2000);
        assertEquals(Character.Facing.LEFT , char1.getFacing() , "Hahmo 1 ei katso oikealle liikuttuaan toisen pelaajan ohi.");
        assertEquals(Character.Facing.RIGHT, char2.getFacing() , "Hahmo 2 ei katso vasemmalle liikuttuaan toisen pelaajan ohi.");
    }
    
   
    @Test
    void characterCollission(){
      
        controller.getCharacter1().setxCoord(1490);  
        controller.getCharacter2().setxCoord(1500);
        assertEquals(true, controller.checkHorizontalCollision(), "Hahmot ovat toistensa päällä");
        
        controller.getCharacter1().setxCoord(1521);  

        assertEquals(false, controller.checkHorizontalCollision(), "Hahmot eivät ole toistensa päällä");
    }
    
    @Test
    void collisionCheck() {
        controller.getCharacter1().setxCoord(1000);
        controller.getCharacter2().setxCoord(2000);
        assertEquals(false, controller.checkHorizontalCollision(), "Hahmot eivät osu toisiinsa");
    }

   
    @Test
    
    void horizontalCollisionCheck () {
        
        assertEquals(true, controller.checkVerticalCollision(), "Hahmot osuvat vertikaali toisiinsa");
        
        controller.getCharacter1().getHurtbox().setyOffSet(30);
        
        assertEquals(false, controller.checkVerticalCollision(), "Hahmot eivät osu vertikaali toisiinsa");

        
        
        
    }
    
    @Test
    void cameraPosition(){
        
    }
    
    @Test
    public void inputs(){
        
    }
}

