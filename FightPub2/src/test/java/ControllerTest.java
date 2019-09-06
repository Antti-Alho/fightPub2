import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.MapModel;
import Model.Character;
import controller.Controller;

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
        assertEquals(1200, controller.getCharacter1.getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1800, controller.getCharacter2.getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }
    //character.getHurtboxFontside()
    
  
}