
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
import model.InitDatabase;

/**
 *
 * @author Heidi, Pate, Joonas
 */
public class ControllerTest {
    
    InitDatabase init = new InitDatabase();
    Controller controller = new Controller("Pekka", "Pekka", new MapModel("Kaisla"), 99, 2);

    @BeforeEach
    public void setHitbox() {
        controller.getCharacter1().setxCoord(400);
        controller.getCharacter2().setxCoord(1200);
        controller.getCharacter1().setFacing(PlayerEntity.Facing.RIGHT);
        controller.getCharacter2().setFacing(PlayerEntity.Facing.LEFT);
        controller.getCharacter1().getHurtbox().setHeight(400);
        controller.getCharacter2().getHurtbox().setHeight(400);
        controller.getCharacter1().getHurtbox().setWidth(200);
        controller.getCharacter2().getHurtbox().setWidth(200);
    }

    @Test
    public void startLocation() {
        assertEquals(400, controller.getCharacter1().getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1200, controller.getCharacter2().getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }

    @Test
    public void turn() {
        assertEquals(PlayerEntity.Facing.RIGHT, controller.getCharacter1().getFacing(), "Hahmo 1 ei katso oikealle lähtöpaikassaan.");
        assertEquals(PlayerEntity.Facing.LEFT, controller.getCharacter2().getFacing(), "Hahmo 2 ei katso vasemmalle lähtopaikassaan.");
        controller.getCharacter1().setxCoord(2000);
        controller.checkFacing();
        assertEquals(PlayerEntity.Facing.LEFT, controller.getCharacter1().getFacing(), "Hahmo 1 ei katso vasemmalle liikuttuaan toisen pelaajan ohi.");
        assertEquals(PlayerEntity.Facing.RIGHT, controller.getCharacter2().getFacing(), "Hahmo 2 ei katso oikealle liikuttuaan toisen pelaajan ohi.");
    }

    @Test
    void collisionCheck() {

        controller.getCharacter1().setxCoord(1200);
        controller.getCharacter2().setxCoord(1800);
        assertEquals(false, controller.checkCollision(), "Hahmot ovat alotuis paikalla ei pitäisi osua");

        controller.getCharacter1().setxCoord(1000);
        controller.getCharacter2().setxCoord(1100);
        assertEquals(true, controller.checkCollision(), "Hahmojen pitäisi osua");

        controller.getCharacter2().setyCoord(1500);
        assertEquals(false, controller.checkCollision(), "Hahmo 2 nostettu reilusti ylös. Hahmojen  ei pitäisi osua");

        controller.getCharacter1().setxCoord(1000);
        controller.getCharacter2().setxCoord(1000);
        controller.getCharacter2().setyCoord(0);
        assertEquals(true, controller.checkCollision(), "Hahmojen pitäisi osua. Samassa paikassa kummatkin");

        controller.getCharacter1().setxCoord(1300);
        controller.getCharacter2().setxCoord(900);
        assertEquals(false, controller.checkCollision(), "Hahmojen ei pitäisi osua ");

        controller.getCharacter1().setyCoord(500);
        assertEquals(false, controller.checkCollision(), "Hahmojen ei pitäisi osua. 1 hahmo viistosti ylhäällä 2 hahmoa kohden.");

        controller.getCharacter2().setxCoord(1300);
        assertEquals(false, controller.checkCollision(), "Hahmojen ei pitäisi osua. Hahmo 1 suoraan 2 hahmon yläpuolella.");

        controller.getCharacter1().setyCoord(399);
        assertEquals(true, controller.checkCollision(), "Hahmojen pitäisi osua. Hahmo 1 suoraan yläpuolella, mutta osuvasti.");

        controller.getCharacter1().setyCoord(0);
    }

    @Test
    void CheckFacing() {
        PlayerEntity char1 = controller.getCharacter1();
        PlayerEntity char2 = controller.getCharacter2();
        char1.setxCoord(2500);
        char2.setxCoord(1800);
        controller.checkFacing();
        assertEquals(PlayerEntity.Facing.LEFT, char1.getFacing(), "Hahmo 1 ei kääntynyt");
        assertEquals(PlayerEntity.Facing.RIGHT, char2.getFacing(), "Hahmo 2 ei kääntynyt");
        controller.checkFacing();
        assertEquals(PlayerEntity.Facing.LEFT, char1.getFacing(), "Hahmo 1  kääntynyt vaikka ei saisi");
        assertEquals(PlayerEntity.Facing.RIGHT, char2.getFacing(), "Hahmo 2 kääntynyt vaikka ei saisi");

    }

    @Test
    void checkHitBoxCollision() {
        controller.getCharacter1().setxCoord(1000);
        controller.getCharacter2().setxCoord(1201);

        controller.getCharacter1().attack('A');
        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter1(), controller.getCharacter2()), "Iskun pitäisi osua");
        assertEquals(false, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun ei pitäisi osua");
        controller.getCharacter2().attack('A');
        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun pitäisi osua (hahmo 2 iskee oikealta)");
        controller.getCharacter2().setxCoord(780);
        controller.checkFacing();
        controller.getCharacter2().attack('A');
        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun pitäisi osua (hahmo 2 vasemmalta");
    }

    @Test
    void checkStateChanged() {
        PlayerEntity char1 = controller.getCharacter1();
        PlayerEntity char2 = controller.getCharacter2();
        char1.setxCoord(1000);
        char2.setxCoord(1201);
        char2.attack('A');
        controller.hitter();
        assertEquals(PlayerEntity.State.HITSTUN, char1.getState(), "char1 pitäisi olla hitstunnissa");
        for (int i = 0; i < 3; i++) {
            controller.reduceStateDuration();
        }
        assertEquals(PlayerEntity.State.HITSTUN, char1.getState(), "char1 pitäisi edelleen olla hitstunnissa");
        for (int i = 0; i < 10; i++) {
            controller.reduceStateDuration();
        }
        assertEquals(PlayerEntity.State.NEUTRAL, char1.getState(), "char1 pitäisi olla palautunut neutral stateen");
    }

    @Test
    void blocking() {
        PlayerEntity char1 = controller.getCharacter1();
        PlayerEntity char2 = controller.getCharacter2();
        char1.setxCoord(1000);
        char2.setxCoord(1201);
        char1.setBlocking(true);
        char2.setBlocking(true);
        char1.setHealth(100);
        char2.setHealth(100);
        char1.setState(PlayerEntity.State.NEUTRAL);
        char2.setState(PlayerEntity.State.NEUTRAL);
        System.out.println(char2.getHealth());
        char2.attack('A');
        controller.hitter();
        assertEquals(PlayerEntity.State.BLOCKSTUN, char1.getState(), "char1:n pitäisi olla blockstun statessa");
        assertEquals(0, char2.getHitBox().getWidth(), "char2:n hitboxin width pitäisi olla 0");
        assertEquals(0, char2.getHitBox().getHeight(), "char2:n hitboxin height pitäisi olla 0");
        //next case
        char2.setStance(PlayerEntity.Stance.CROUCHING);
        char1.getHitBox().setAll( 0, 300, 300, 0, 0, 10, 20, HitBox.HitLocation.HIGH);
        controller.hitter();
        assertEquals(PlayerEntity.State.HITSTUN, char2.getState(), "char2:n staten pitäisi olla hitstun");
        //next case
        char2.setState(PlayerEntity.State.NEUTRAL);
        char2.setStance(PlayerEntity.Stance.STANDING);
        char1.getHitBox().setAll( 0, 300, 300, 0, 0, 10, 20, HitBox.HitLocation.LOW);
        controller.hitter();
        assertEquals(PlayerEntity.State.HITSTUN, char2.getState(), "char2:n staten pitäisi olla hitstun");
        controller.reduceStateDuration();
        char2.setBlocking(true);
        char1.getHitBox().setAll( 10, 300, 300, 0, 0, 10, 20, HitBox.HitLocation.MID);
        controller.hitter();
        assertEquals(PlayerEntity.State.HITSTUN, char2.getState(), "char2: pitäisi edelleen olla hitstunnissa.");
        assertEquals(90, char2.getHealth(), "char2:n hp:n pitäisi olla 90");
        char1.setxCoord(1000);
        char2.setxCoord(1201);
        char1.setBlocking(false);
        char2.setBlocking(false);
        char1.setHealth(100);
        char2.setHealth(100);
        char1.setState(PlayerEntity.State.NEUTRAL);
        char2.setState(PlayerEntity.State.NEUTRAL);
        char1.getHitBox().setAll( 10, 300, 300, 0, 0, 10, 20, HitBox.HitLocation.MID);
        char2.getHitBox().setAll( 10, 300, 300, char2.getHurtbox().getWidth() - 300, 0, 10, 20, HitBox.HitLocation.MID);
        System.out.println(controller.checkHitboxCollision(char2, char1));
        System.out.println(char2.getFacing());
        System.out.println(char1.getFacing());
        controller.hitter();
        assertEquals(PlayerEntity.State.HITSTUN, char1.getState(), "2. Hahmot löivät samaan aikaan. molempien charactereiden pitäisi olla hitstunnissa.");
        assertEquals(PlayerEntity.State.HITSTUN, char2.getState(), "1. Hahmot löivät samaan aikaan. molempien charactereiden pitäisi olla hitstunnissa.");

        assertEquals(90, char2.getHealth(), "1. char2:n hp:n pitäisi olla 90");
        assertEquals(90, char2.getHealth(), "2. char2:n hp:n pitäisi olla 90");
    }
    /*
    @Test
    void cameraPosition() {

    }

    @Test
    public void inputs() {

    }
     */
}
