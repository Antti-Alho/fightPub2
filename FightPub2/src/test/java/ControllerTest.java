
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.MapModel;
import model.PlayerEntity;
import controller.Controller;
import java.awt.event.KeyEvent;
import model.HurtBox;
import org.junit.jupiter.api.Disabled;
import model.HitBox;

/**
 *
 * @author Heidi, Pate
 */
public class ControllerTest {

    MapModel map;
    //Controller controller = new Controller(new Character(1200, Character.Facing.RIGHT), new Character(false, "Jukka"), new MapModel("Kaisla"), 99, 2);

    Controller controller = new Controller("Pekka","Pekka",new MapModel("Kaisla"), 99, 2);

    //dont use Character classes instances here pls. only use control classes methods. you can get your desired character with controller.getCharacter.
    @BeforeEach
    public void setHitbox() {
        controller.getCharacter1().setxCoord(400);
        controller.getCharacter2().setxCoord(1800);
        controller.getCharacter1().setFacing(PlayerEntity.Facing.RIGHT);
        controller.getCharacter2().setFacing(PlayerEntity.Facing.LEFT);
        controller.getCharacter1().getHurtbox().setHeight(20);
        controller.getCharacter2().getHurtbox().setHeight(20);
        controller.getCharacter1().getHurtbox().setWidth(20);
        controller.getCharacter2().getHurtbox().setWidth(20);
    }
    @Test
    public void startLocation() {
        assertEquals(400, controller.getCharacter1().getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1800, controller.getCharacter2().getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }
    @Test
    @Disabled
    public void turn() {
        assertEquals(PlayerEntity.Facing.RIGHT, controller.getCharacter1().getFacing(), "Hahmo 1 ei katso vasemmalle lähtöpaikassaan.");
        assertEquals(PlayerEntity.Facing.LEFT, controller.getCharacter2().getFacing(), "Hahmo 2 ei katso oikealle lähtopaikassaan.");
        controller.getCharacter1().setxCoord(2000);
        assertEquals(PlayerEntity.Facing.LEFT, controller.getCharacter1().getFacing(), "Hahmo 1 ei katso oikealle liikuttuaan toisen pelaajan ohi.");
        assertEquals(PlayerEntity.Facing.RIGHT, controller.getCharacter2().getFacing(), "Hahmo 2 ei katso vasemmalle liikuttuaan toisen pelaajan ohi.");
    }

    @Test
    void collisionCheck() {

        controller.getCharacter1().setxCoord(1200);
        controller.getCharacter2().setxCoord(1800);

        assertEquals(false, controller.checkCollision(), "Hahmot ovat alotuis paikalla ei pitäisi osua");

        controller.getCharacter1().setxCoord(1000);
        controller.getCharacter2().setxCoord(1010);

        assertEquals(true, controller.checkCollision(), " pitäisi osua");

        controller.getCharacter2().setyCoord(151);

        assertEquals(false, controller.checkCollision(), "char 2 noastettu  ei pitäisi osua");

        controller.getCharacter1().setxCoord(1000);
        controller.getCharacter2().setxCoord(1000);
        controller.getCharacter2().setyCoord(20);

        assertEquals(true, controller.checkCollision(), "pitäisi osua samassa paikassa kummatkin");

        controller.getCharacter1().setxCoord(1000);
        controller.getCharacter2().setxCoord(900);

        assertEquals(false, controller.checkCollision(), " ei pitäisi osua ");

        controller.getCharacter1().setyCoord(50);

        assertEquals(false, controller.checkCollision(), " ei pitäisi osua. 1 pelaaja ylhäällä.");

        controller.getCharacter2().setxCoord(1000);

        assertEquals(false, controller.checkCollision(), " ei pitäisi osua. pelaaja 1 suoraan yläpuolella.");

        controller.getCharacter1().setyCoord(20);

        assertEquals(true, controller.checkCollision(), " pitäisi osua. pelaaja 1 suoraan yläpuolella.");

    }

    @Test
    void CheckFacing() {
        PlayerEntity char1 = controller.getCharacter1();
        PlayerEntity char2 = controller.getCharacter2();
        char1.setxCoord(2500);
        char2.setxCoord(1800);
        controller.checkFacing();
        assertEquals(PlayerEntity.Facing.LEFT, char1.getFacing(), "Hahmo ei kääntynyt");
        assertEquals(PlayerEntity.Facing.RIGHT, char2.getFacing(), "Hahmo 2 ei kääntynyt");
        controller.checkFacing();
        assertEquals(PlayerEntity.Facing.LEFT, char1.getFacing(), "Hahmo  kääntynyt vaikka ei saisi");
        assertEquals(PlayerEntity.Facing.RIGHT, char2.getFacing(), "Hahmo 2 kääntynyt vaikka ei saisi");

    }

    @Test
    void checkHitBoxCollision() {
        controller.getCharacter1().setxCoord(1400);
        controller.getCharacter2().setxCoord(1421);
        controller.getCharacter1().attack('A');
        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter1(), controller.getCharacter2()), "Iskun pitäisi osua");
        assertEquals(false, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun ei pitäisi osua");
        controller.getCharacter2().attack('A');
        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun pitäisi osua (hahmo 2 iskee oikealta)");
        controller.getCharacter2().setxCoord(1379);
        controller.checkFacing();
        controller.getCharacter2().attack('A');
        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun pitäisi osua (hahmo 2 vasemmalta");
    }

    @Test
    void cameraPosition() {

    }

    @Test
    public void inputs() {

    }
}
