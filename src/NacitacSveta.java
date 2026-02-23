import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Třída pro načítání světa hry ze souboru.
 * Používá Gson knihovnu pro deserializaci JSON souboru.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class NacitacSveta {
    
    /**
     * Načte svět hry ze souboru a vytvoří instanci hry.
     *
     * @param cesta Cesta k souboru se světem
     * @return Inicializovaná instance hry
     * @throws IOException Pokud dojde k chybě při čtení souboru
     */
    public Hra nactiZeSouboru(String cesta) throws IOException {
        Gson gson = new Gson();
        // Načítání světa přímo do DTO
        SvetDTO svetDTO = gson.fromJson(new FileReader(cesta), SvetDTO.class);

        // Vytvoření místností
        Map<String, Mistnost> mistnosti = Mistnost.vytvorMistnosti(svetDTO.mistnosti);

        // Propojení východů
        Mistnost.propojVychody(svetDTO.mistnosti, mistnosti);

        // Vytvoření hry
        Hra hra = new Hra();
        hra.setAktualniMistnost(mistnosti.get(svetDTO.startovniMistnost));
        hra.setBatoh(new Batoh());
        
        // Přidání startovní karty
        Karta startovniKarta = new Karta("Rekrut", 8, 6, 15);
        hra.getBatoh().pridejKartu(startovniKarta);
        
        return hra;
    }
}
