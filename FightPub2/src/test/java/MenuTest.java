
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.PlayerEntity;
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
        assertEquals(0, 0, ""); // Testit meni uusiksi, kirjoitetaan myöhemmin.
    }
    
    @Test
    void downElement() {
         assertEquals(0, 0, ""); // Testit meni uusiksi, kirjoitetaan myöhemmin.
    }
    @Test
    void upElement() {
         assertEquals(0, 0, ""); // Testit meni uusiksi, kirjoitetaan myöhemmin.
    }
    
    
}
