import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NacitacSveta {
    public Hra nactiZeSouboru(String cesta) throws IOException {
        Gson gson = new Gson();
        // Načteme svět přímo do HraDTO
        SvetDTO svetDTO = gson.fromJson(new FileReader(cesta), SvetDTO.class);

        // Vytvoření místností
        Map<String, Mistnost> mistnosti = Mistnost.vytvorMistnosti(svetDTO.mistnosti);

        // Propojení východů
        Mistnost.propojVychody(svetDTO.mistnosti, mistnosti);

        // Vytvoření hry
        Hra hra = new Hra();
        hra.setAktualniMistnost(mistnosti.get(svetDTO.startovniMistnost));
        hra.setBatoh(new Batoh());
        return hra;
    }

    // DTO třída pro Gson
    static class SvetDTO {
        String startovniMistnost;
        MistnostDTO[] mistnosti;
    }

    static class MistnostDTO {
        String nazev;
        String popis;
        Map<String, String> vychody;
        PredmetDTO[] predmety;
        PostavaDTO postava;
    }

    static class PredmetDTO {
        String nazev;
        String popis;
        boolean prenositelny;
    }

    static class PostavaDTO {
        String jmeno;
        String dialog;
        boolean jeNepritel;
        KartaDTO[] balicekKaret;
    }

    static class KartaDTO {
        String jmeno;
        int utok;
        int obrana;
        int zivoty;
    }
}
