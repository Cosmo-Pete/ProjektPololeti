import java.util.HashMap;
import java.util.Map;

public class Mistnost {
    private String nazev;
    private String popis;
    private Map<String, Mistnost> vychody;
    private Map<String, Predmet> predmety;
    private Postava postava;

    public Mistnost(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashMap<>();
        this.predmety = new HashMap<>();
        this.postava = null;
    }

    public static Map<String, Mistnost> vytvorMistnosti(MistnostDTO[] mistnostiDTO) {
        Map<String, Mistnost> mistnosti = new HashMap<>();
        
        for (MistnostDTO dto : mistnostiDTO) {
            Mistnost mistnost = new Mistnost(dto.nazev, dto.popis);
            
            // Načtení předmětů
            if (dto.predmety != null) {
                for (PredmetDTO predmetDTO : dto.predmety) {
                    Predmet predmet = new Predmet(predmetDTO.nazev, predmetDTO.popis, predmetDTO.prenositelny);
                    mistnost.vlozPredmet(predmet);
                }
            }
            
            // Načtení postavy
            if (dto.postava != null) {
                Postava postava = new Postava(dto.postava.jmeno, dto.postava.dialog, dto.postava.jeNepritel);
                
                // Načtení karet
                if (dto.postava.balicekKaret != null) {
                    for (KartaDTO kartaDTO : dto.postava.balicekKaret) {
                        Karta karta = new Karta(kartaDTO.jmeno, kartaDTO.utok, kartaDTO.obrana, kartaDTO.zivoty);
                        postava.getBalicekKaret().add(karta);
                    }
                }
                
                mistnost.setPostava(postava);
            }
            
            mistnosti.put(mistnost.getNazev(), mistnost);
        }
        
        return mistnosti;
    }

    public static void propojVychody(MistnostDTO[] mistnostiDTO, Map<String, Mistnost> mistnosti) {
        for (MistnostDTO dto : mistnostiDTO) {
            Mistnost mistnost = mistnosti.get(dto.nazev);
            if (mistnost == null) continue;
            
            if (dto.vychody != null) {
                for (Map.Entry<String, String> vychod : dto.vychody.entrySet()) {
                    String smer = vychod.getKey();
                    String cilNazev = vychod.getValue();
                    Mistnost cil = mistnosti.get(cilNazev);
                    if (cil != null) {
                        mistnost.pridejVychod(smer, cil);
                    }
                }
            }
        }
    }

    public void pridejVychod(String smer, Mistnost cil) {
        vychody.put(smer, cil);
    }

    public Mistnost getVychod(String smer) {
        return vychody.get(smer);
    }

    public void vlozPredmet(Predmet p) {
        predmety.put(p.getNazev(), p);
    }

    public Predmet odeberPredmet(String nazev) {
        return predmety.remove(nazev);
    }

    public String dlouhyPopis() {
        return ""; // Vypíše název, popis, východy, předměty a postavu
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public Map<String, Mistnost> getVychody() {
        return vychody;
    }

    public Postava getPostava() {
        return postava;
    }

    public void setPostava(Postava postava) {
        this.postava = postava;
    }
}

