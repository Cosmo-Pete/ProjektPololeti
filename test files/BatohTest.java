import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BatohTest {

    @Test
    public void testPridejPredmet() {
        Batoh batoh = new Batoh();
        Predmet predmet = new Predmet("mec", "Ostrý meč", true);
        
        assertTrue(batoh.pridejPredmet(predmet));
        assertEquals(1, batoh.getPredmety().size());
        
        assertFalse(batoh.pridejPredmet(null));
        
        Predmet neprenositelny = new Predmet("kamen", "Těžký kámen", false);
        assertFalse(batoh.pridejPredmet(neprenositelny));
        
        for (int i = 0; i < 5; i++) {
            batoh.pridejPredmet(new Predmet("predmet" + i, "Popis", true));
        }
        assertFalse(batoh.pridejPredmet(new Predmet("extra", "Extra", true)));
    }

    @Test
    public void testVyhodPredmet() {
        Batoh batoh = new Batoh();
        Predmet predmet = new Predmet("mec", "Ostrý meč", true);
        batoh.pridejPredmet(predmet);
        
        Predmet vyhozeny = batoh.vyhodPredmet("mec");
        assertNotNull(vyhozeny);
        assertEquals("mec", vyhozeny.getNazev());
        assertEquals(0, batoh.getPredmety().size());
        
        assertNull(batoh.vyhodPredmet("neexistujici"));
    }
}
