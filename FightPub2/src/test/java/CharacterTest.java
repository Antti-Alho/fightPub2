

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Model.Character;

/**
 *
 * @author Heidi
 */
public class CharacterTest {


    private final Character character1 = new Character(true, "eman");

    @Test
    void walk() {
        character1.setxCoord(1500); /* walkspeed asetettu arvoon 4*/
        character1.walk(left);
        assertEquals(1496, character1.getNextxCoord());
        character1.walk(right);
        assertEquals(1500, character1.getNextxCoord());
    }

    @Test
    void outOfBounds () {
        character1.setxCoord(0);
        character1.walk(left);
        assertEquals(-4, character1.getNextxCoord());
        character1.setxCoord(3000);
        character1.move(right);
        assertEquals(3004, character1.getNextxCoord());
    }




}
