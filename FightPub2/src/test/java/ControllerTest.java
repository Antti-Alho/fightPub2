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
    @BeforeEach
	setUp() {
		Character char1 = new Character(true, "enam");
		Character char2 = new Character(false, "enam");
		MapModel map = new MapModel();
		private final Controller controller = new Controller(char1, char2, map, 2, 99); //hahmo1, hahmo2, kartta, tarvittavat erävoitot, erän aikaraja
	}

    @Test
    void startLocation(){
        assertEquals(1200, controller.getPlayer1().getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1800, controller.getPlayer2().getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }

	@Test
	void turn() {
			char1.setLocation(2000,0);
			controller.checkNextFrame();
			controller.advance();
			assertEquals(false, char1.getFacingRight(), "Hahmo 1 ei kääntynyt");
			assertEquals(true, char2.getFacingRight(), "Hahmo 2 ei kääntynyt");
	}

	@Test
	void border() {
		char1.setNextLocation(0, 0);
		controller.checkNextFrame();
		controller.advance();
		assertEquals(50, char1.getxCoord(), "Hahmo seinän sisällä");
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

