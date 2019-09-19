
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.Character;
import controller.Menu;
/**
 *
 * @author Joonas
 */
public class MenuTest {
    static Menu menu;
    @BeforeAll
    static void setUp() {
        menu = new Menu();
    }
    
    @Test
    void activeElement() {
        assertEquals(0, menu.getActiveElement(), "0. Väärä elementti");
    }
    
    @Test
    void downElement() {
        menu.downElement();
        assertEquals(1, menu.getActiveElement(), "1. Väärä elementti");
        menu.downElement();
        assertEquals(0, menu.getActiveElement(), "2. Väärä elementti");
        menu.downElement();
        assertEquals(1, menu.getActiveElement(), "3. Väärä elementti");
    }
    @Test
    void upElement() {
        menu.upElement();
        assertEquals(0, menu.getActiveElement(), "4. Väärä elementti");
        menu.upElement();
        assertEquals(1, menu.getActiveElement(), "5. Väärä elementti");
        menu.upElement();
        assertEquals(0, menu.getActiveElement(), "6. Väärä elementti");
    }
    
    
}
