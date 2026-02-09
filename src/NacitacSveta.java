import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class NacitacSveta {
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
        Karta startovniKarta = new Karta("Začátečnická karta", 5, 5, 10);
        hra.getBatoh().pridejKartu(startovniKarta);
        
        return hra;
    }
}
