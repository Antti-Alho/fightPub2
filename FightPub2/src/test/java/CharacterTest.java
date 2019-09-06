

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
    void move() {
        character1.setxCoord(1500);
        character1.move(-4);
        assertEquals(1496, character1.getxCoord());
        character1.move(4);
        assertEquals(1500, character1.getxCoord());
    }
    
    @Test
    void outOfBounds () {
        character1.setxCoord(0);
        character1.move(4);
        assertEquals(0, character1.getxCoord());
        character1.setxCoord(3000);
        character1.move(4);
        assertEquals(3000, character1.getxCoord());
    }
    

}
