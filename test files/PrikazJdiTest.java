import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro příkaz Jdi.
 * Obsahuje testy pro pohyb mezi místnostmi.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazJdiTest {

    /**
     * Test provedení příkazu jdi.
     * Ověřuje správný pohyb mezi místnostmi a chování při neplatných směrech.
     */
    @Test
    public void testPrikazJdiProved() {
        Hra hra = new Hra();
        Mistnost mistnost1 = new Mistnost("les", "Temný les");
        Mistnost mistnost2 = new Mistnost("louka", "Zelená louka");
        mistnost1.pridejVychod("vychod", mistnost2);
        hra.setAktualniMistnost(mistnost1);
        
        PrikazJdi prikaz = new PrikazJdi();
        String vysledek = prikaz.proved(new String[]{"vychod"}, hra);
        
        assertTrue(vysledek.contains("louka"));
        assertEquals(mistnost2, hra.getAktualniMistnost());
        
        vysledek = prikaz.proved(new String[]{"sever"}, hra);
        assertTrue(vysledek.contains("nelze pohnout"));
    }
}
