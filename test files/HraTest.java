import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HraTest {

    @Test
    public void testInicializujHru() {
        Hra hra = new Hra();
        hra.inicializujHru();
        assertNotNull(hra.getAktualniMistnost());
        assertNotNull(hra.getBatoh());
    }

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
