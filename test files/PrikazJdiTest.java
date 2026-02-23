import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrikazJdiTest {

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
