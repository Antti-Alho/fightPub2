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
 * @author Heidi
 */
public class ControllerTest {
    
    public ControllerTest() {
    }
    private final Controller controller = new Controller();
    
    @Test
    void startLocation(){
        assertEquals(1200, controller.getPlayer1().getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1800, controller.getPlayer2().getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }
    //character.getHurtboxFontside()
    
    @Test
    void  characterCollission(){
        controller.getPlayer1().setxCoord(1500);
        controller.getPlayer2().setxCoord(1500);
        assertEquals(false, controller.checkCollission(), "Hahmot ovat toistensä päällä");
    }
    
    @Test
    void cameraPosition(){
        
    }
    
    @Test inputs(){
        
    }
}