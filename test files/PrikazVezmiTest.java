import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro příkaz Vezmi.
 * Obsahuje testy pro sebírání předmětů.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazVezmiTest {

    /**
     * Test provedení příkazu vezmi.
     * Ověřuje správné sebírání předmětů a chování při neexistujících předmětech.
     */
    @Test
    public void testPrikazVezmiProved() {
        Hra hra = new Hra();
        Batoh batoh = new Batoh();
        hra.setBatoh(batoh);
        
        Mistnost mistnost = new Mistnost("les", "Temný les");
        Predmet predmet = new Predmet("mec", "Ostrý meč", true);
        mistnost.vlozPredmet(predmet);
        hra.setAktualniMistnost(mistnost);
        
        PrikazVezmi prikaz = new PrikazVezmi();
        String vysledek = prikaz.proved(new String[]{"mec"}, hra);
        
        assertTrue(vysledek.contains("Vzal jsi"));
        assertEquals(1, batoh.getPredmety().size());
        assertNull(mistnost.odeberPredmet("mec"));
        
        vysledek = prikaz.proved(new String[]{"neexistujici"}, hra);
        assertTrue(vysledek.contains("není v této místnosti"));
    }
}
