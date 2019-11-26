
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

    /**
     * before each test set the character to certain places and their values
     */
    @BeforeEach
    public void setHitbox() {
        controller.getCharacter1().setxCoord(400);
        controller.getCharacter2().setxCoord(1200);
        controller.getCharacter1().setFacing(PlayerEntity.Facing.RIGHT);
        controller.getCharacter2().setFacing(PlayerEntity.Facing.LEFT);
        controller.getCharacter1().setStandingHeight(400);
        controller.getCharacter2().setStandingHeight(400);
        controller.getCharacter1().setStandingWidth(200);
        controller.getCharacter2().setStandingWidth(200);
    }

    /**
     * tests if the characters are in their starting location defined by controllers constructor method.
     * Controller should set them in positions 400 and 1200
     */
    @Test
    public void startLocation() {
        assertEquals(400, controller.getCharacter1().getxCoord(), "Hahmo 1 ei ole aloituspaikassaan");
        assertEquals(1200, controller.getCharacter2().getxCoord(), "Hahmo 2 ei ole aloituspaikallaan");
    }

    /**
     * Tests the collisionCheck method, that returns true if character
     * "hurtboxes" collide.
     */
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

    }

    /**
     * Tests the checkFacing method, that keeps player characters facing each
     * other even if they end up switching sides.
     */
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
    /**
     * Tests the checkHitboxCollision method, which should return true if and
     * only if hitbox is colliding with another characters "hurtbox".
     */
    @Test
    void checkHitBoxCollision() {
        controller.getCharacter1().setxCoord(1000);
        controller.getCharacter2().setxCoord(1201);
        controller.getCharacter1().getHitBox().setAll(10, 150, 20, 100, 30, 5, 40, HitBox.HitLocation.HIGH);
        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter1(), controller.getCharacter2()), "Iskun pitäisi osua");
        assertEquals(false, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun ei pitäisi osua");
        controller.getCharacter2().getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.HIGH);
        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun pitäisi osua (hahmo 2 iskee oikealta)");
        controller.getCharacter2().setxCoord(780);
        controller.masterCheck();
        controller.getCharacter2().getHitBox().setAll(10, 150, 20, 100, 30, 5, 40, HitBox.HitLocation.HIGH);

        assertEquals(true, controller.checkHitboxCollision(controller.getCharacter2(), controller.getCharacter1()), "Iskun pitäisi osua (hahmo 2 vasemmalta");
    }

    /**
     * checks that the other character goes into a hitstun after the hitting character has succesfully landed a hit
     * also it tests that the character goes back to a neutral state after a certain period of frames.
     */
    @Test
    void checkStateChanged() {
        PlayerEntity char1 = controller.getCharacter1();
        PlayerEntity char2 = controller.getCharacter2();
        char1.setxCoord(1000);
        char2.setxCoord(1201);
        char2.getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.HIGH);
        System.out.println(controller.checkHitboxCollision(char2, char1));
        controller.hitter();
        assertEquals(PlayerEntity.State.HITSTUN, char1.getState(), "char1 pitäisi olla hitstunnissa");
        for (int i = 0; i < 3; i++) {
            controller.reduceStateDuration();
        }
        assertEquals(PlayerEntity.State.HITSTUN, char1.getState(), "char1 pitäisi edelleen olla hitstunnissa");
        for (int i = 0; i < 20; i++) {
            controller.reduceStateDuration();
        }
        assertEquals(PlayerEntity.State.NEUTRAL, char1.getState(), "char1 pitäisi olla palautunut neutral stateen");
    }

    /**
     * checks that the standing character can block high and middle hitting
     * attacks, and cannot block low attacks when
     */
    @Test
    void standingBlock() {
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
        char1.setStance(PlayerEntity.Stance.STANDING);
        char2.getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.HIGH);
        controller.hitter();
        assertEquals(PlayerEntity.State.BLOCKSTUN, char1.getState(), "char1:n pitäisi olla blockstun statessa");
        char1.setState(PlayerEntity.State.NEUTRAL);
        char2.getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.MID);
        controller.hitter();
        assertEquals(PlayerEntity.State.BLOCKSTUN, char1.getState(), "char1:n pitäisi olla blockstun statessa");
        char1.setState(PlayerEntity.State.NEUTRAL);
        char2.getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.LOW);
        controller.hitter();
        assertEquals(PlayerEntity.State.HITSTUN, char1.getState(), "char1:n pitäisi olla HIT statessa");
    }
    /**
     * Tests that Hitbox gets deactivated after hit connects to another
     * player characters "hurtbox"
     */
    @Test
    void HitBoxDeactivation() {
        PlayerEntity char1 = controller.getCharacter1();
        PlayerEntity char2 = controller.getCharacter2();
        char1.setxCoord(1000);
        char2.setxCoord(1201);
        char2.getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.HIGH);
        controller.hitter();
        assertEquals(0, char2.getHitBox().getWidth(), "char2:n hitboxin width pitäisi olla 0");
        assertEquals(0, char2.getHitBox().getHeight(), "char2:n hitboxin height pitäisi olla 0");
    }
    /**
     * Tests that crouching player can block low and mid attacks, but gets 
     * hit by high attacks
     */
    @Test
    void crouchingBlock() {
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
        char1.setStance(PlayerEntity.Stance.CROUCHING);
        char2.getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.LOW);
        controller.hitter();
        assertEquals(PlayerEntity.State.BLOCKSTUN, char1.getState(), "char1:n pitäisi olla blockstun statessa");
        char1.setState(PlayerEntity.State.NEUTRAL);
        char2.getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.MID);
        controller.hitter();
        assertEquals(PlayerEntity.State.BLOCKSTUN, char1.getState(), "char1:n pitäisi olla blockstun statessa");
        char1.setState(PlayerEntity.State.NEUTRAL);
        char2.getHitBox().setAll(10, 150, 20, -100, 30, 5, 40, HitBox.HitLocation.HIGH);
        controller.hitter();
        assertEquals(PlayerEntity.State.HITSTUN, char1.getState(), "char1:n pitäisi olla HIT statessa");
    }
    /**
     * Tests that attacks reduce health
     */
    @Test
    void reduceHealth() {
        PlayerEntity char1 = controller.getCharacter1();
        PlayerEntity char2 = controller.getCharacter2();
        char1.setxCoord(1000);
        char2.setxCoord(1201);
        char1.setBlocking(true);
        char2.setBlocking(false);
        char1.setHealth(100);
        char2.setHealth(100);
        char2.setState(PlayerEntity.State.NEUTRAL);
        char2.setStance(PlayerEntity.Stance.STANDING);
        char1.getHitBox().setAll(10, 300, 300, 0, 0, 10, 20, HitBox.HitLocation.LOW);
        controller.hitter();
        assertEquals(90, char2.getHealth(), "char2:n hp:n pitäisi olla 90");
    }
    /**
     * Checks that both players can get hit simultaneously, if both get hit on
     * exactly same frame.
     */
    @Test
    void paskaa() {
        PlayerEntity char1 = controller.getCharacter1();
        PlayerEntity char2 = controller.getCharacter2();
        char1.setxCoord(1000);
        char2.setxCoord(1201);
        char1.setxCoord(1000);
        char2.setxCoord(1201);
        char1.setBlocking(false);
        char2.setBlocking(false);
        char1.setHealth(100);
        char2.setHealth(100);
        char1.setState(PlayerEntity.State.NEUTRAL);
        char2.setState(PlayerEntity.State.NEUTRAL);
        char1.getHitBox().setAll( 10, 300, 300, 0, 0, 10, 20, HitBox.HitLocation.MID);
        char2.getHitBox().setAll( 10, 300, 300, char2.getWidth() - 300, 0, 10, 20, HitBox.HitLocation.MID);
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
