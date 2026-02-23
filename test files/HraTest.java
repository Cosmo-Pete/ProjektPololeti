import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro třídu Hra.
 * Obsahuje testy pro inicializaci hry a zpracování příkazů.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class HraTest {

    /**
     * Test inicializace hry.
     * Ověřuje, že po inicializaci jsou nastaveny aktuální místnost a batoh.
     */
    @Test
    public void testInicializujHru() {
        Hra hra = new Hra();
        hra.inicializujHru();
        assertNotNull(hra.getAktualniMistnost());
        assertNotNull(hra.getBatoh());
    }

    /**
     * Test zpracování příkazů.
     * Ověřuje správné chování při neplatných příkazech.
     */
    @Test
    public void testZpracujPrikaz() {
        Hra hra = new Hra();
        hra.inicializujHru();
        
        String vysledek = hra.zpracujPrikaz("neplatny");
        assertTrue(vysledek.contains("není známý"));
        
        vysledek = hra.zpracujPrikaz("");
        assertTrue(vysledek.contains("Neplatný příkaz"));
    }
}
