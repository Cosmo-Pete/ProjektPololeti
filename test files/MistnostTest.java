import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro třídu Mistnost.
 * Obsahuje testy pro manipulaci s východy mezi místnostmi.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class MistnostTest {

    /**
     * Test přidávání východů mezi místnostmi.
     * Ověřuje správné propojení místností.
     */
    @Test
    public void testPridejVychod() {
        Mistnost mistnost1 = new Mistnost("les", "Temný les");
        Mistnost mistnost2 = new Mistnost("louka", "Zelená louka");
        
        mistnost1.pridejVychod("vychod", mistnost2);
        assertNotNull(mistnost1.getVychod("vychod"));
        assertEquals(mistnost2, mistnost1.getVychod("vychod"));
    }
}
