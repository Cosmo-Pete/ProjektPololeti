import java.util.HashMap;
import java.util.Map;

/**
 * Třída reprezentující místnost ve hře.
 * Obsahuje informace o východech, předmětech a postavách v místnosti.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class Mistnost {
    /** Název místnosti */
    private String nazev;
    
    /** Popis místnosti */
    private String popis;
    
    /** Mapa východů do jiných místností */
    private Map<String, Mistnost> vychody;
    
    /** Mapa předmětů v místnosti */
    private Map<String, Predmet> predmety;
    
    /** Postava v místnosti */
    private Postava postava;

    /**
     * Vytvoří novou místnost s daným názvem a popisem.
     *
     * @param nazev Název místnosti
     * @param popis Popis místnosti
     */
    public Mistnost(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashMap<>();
        this.predmety = new HashMap<>();
        this.postava = null;
    }

    /**
     * Vytvoří místnosti z DTO objektů.
     *
     * @param mistnostiDTO Pole DTO objektů místností
     * @return Mapa vytvořených místností
     */
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

    /**
     * Propojí východy mezi místnostmi podle DTO.
     *
     * @param mistnostiDTO Pole DTO objektů místností
     * @param mistnosti Mapa již vytvořených místností
     */
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

    /**
     * Přidá východ do jiné místnosti.
     *
     * @param smer Směr východu
     * @param cil Cílová místnost
     */
    public void pridejVychod(String smer, Mistnost cil) {
        vychody.put(smer, cil);
    }

    /**
     * Vrací místnost v daném směru.
     *
     * @param smer Směr východu
     * @return Místnost v daném směru nebo null
     */
    public Mistnost getVychod(String smer) {
        return vychody.get(smer);
    }

    /**
     * Vloží předmět do místnosti.
     *
     * @param p Předmět k vložení
     */
    public void vlozPredmet(Predmet p) {
        predmety.put(p.getNazev(), p);
    }

    /**
     * Odebere předmět z místnosti.
     *
     * @param nazev Název předmětu k odebrání
     * @return Odebraný předmět nebo null
     */
    public Predmet odeberPredmet(String nazev) {
        return predmety.remove(nazev);
    }

    /**
     * Vytvoří dlouhý popis místnosti včetně východů, předmětů a postav.
     *
     * @return Textový popis místnosti
     */
    public String dlouhyPopis() {
        String popis = "Místnost: " + nazev + "\n";
        popis += "Popis: " + this.popis + "\n";
        
        if (!vychody.isEmpty()) {
            popis += "Východy: ";
            boolean prvni = true;
            for (String smer : vychody.keySet()) {
                Mistnost cil = vychody.get(smer);
                if (!prvni) {
                    popis += ", ";
                }
                popis += smer + " - " + cil.getNazev();
                prvni = false;
            }
            popis += "\n";
        }
        
        if (!predmety.isEmpty()) {
            popis += "Předměty: ";
            boolean prvni = true;
            for (Predmet predmet : predmety.values()) {
                if (!prvni) {
                    popis += ", ";
                }
                popis += predmet.getNazev() + " - " + predmet.getPopis();
                prvni = false;
            }
            popis += "\n";
        }
        
        if (postava != null) {
            popis += "Postava: " + postava.getJmeno() + "\n";
        }
        
        return popis;
    }

    /**
     * Vrací název místnosti.
     *
     * @return Název místnosti
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrací popis místnosti.
     *
     * @return Popis místnosti
     */
    public String getPopis() {
        return popis;
    }

    /**
     * Vrací mapu východů.
     *
     * @return Mapa východů
     */
    public Map<String, Mistnost> getVychody() {
        return vychody;
    }

    /**
     * Vrací postavu v místnosti.
     *
     * @return Postava v místnosti nebo null
     */
    public Postava getPostava() {
        return postava;
    }

    /**
     * Nastaví postavu v místnosti.
     *
     * @param postava Postava k umístění
     */
    public void setPostava(Postava postava) {
        this.postava = postava;
    }
}

