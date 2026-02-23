import java.util.HashMap;
import java.util.Map;

/**
 * Hlavní třída hry Pololeti.
 * Stará se o hlavní logiku hry, zpracování příkazů a stav hry.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class Hra {
    private Mistnost aktualniMistnost;
    private Batoh batoh;
    private boolean konecHry;
    private Map<String, IPrikaz> mapaPrikazu;
    private Karta aktivniKarta;

    /**
     * Vytvoří novou instanci hry.
     * Inicializuje základní parametry hry.
     */
    public Hra() {
        this.konecHry = false;
        this.mapaPrikazu = new HashMap<>();
        this.aktivniKarta = null;
    }

    /**
     * Inicializuje hru načtením světa ze souboru.
     * Nastaví počáteční místnost a batoh.
     */
    public void inicializujHru() {
        NacitacSveta nacitac = new NacitacSveta();
        try {
            Hra nactenaHra = nacitac.nactiZeSouboru("svet.gson");
            if (nactenaHra != null) {
                this.aktualniMistnost = nactenaHra.getAktualniMistnost();
                this.batoh = nactenaHra.getBatoh();
            }
        } catch (Exception e) {
            System.err.println("Chyba při načítání světa: " + e.getMessage());
        }
    }

    /**
     * Zpracuje příkaz zadaný hráčem.
     * Rozdělí vstup na příkaz a parametry, najde odpovídající příkaz a provede ho.
     *
     * @param radek Vstupní příkaz od hráče
     * @return Výsledek provedení příkazu
     */
    public String zpracujPrikaz(String radek) {
        Parser parser = new Parser();
        String[] casti = parser.parsujVstup(radek);
        
        if (casti.length == 0) {
            return "Neplatný příkaz.";
        }
        
        String nazevPrikazu = casti[0];
        String[] parametry = new String[0];
        
        if (casti.length > 1) {
            parametry = new String[]{casti[1]};
        }
        
        IPrikaz prikaz = mapaPrikazu.get(nazevPrikazu);
        
        if (prikaz == null) {
            return "Příkaz '" + nazevPrikazu + "' není známý.";
        }
        
        return prikaz.proved(parametry, this);
    }

    /**
     * Vrací, zda je konec hry.
     *
     * @return true pokud je konec hry, jinak false
     */
    public boolean jeKonec() {
        return konecHry;
    }

    /**
     * Nastaví konec hry.
     *
     * @param konec true pro konec hry, false pro pokračování
     */
    public void setKonecHry(boolean konec) {
        this.konecHry = konec;
    }

    /**
     * Zkontroluje, zda hráč vyhrál hru.
     * Aktuálně prázdná metoda pro budoucí implementaci.
     */
    public void zkontrolujVitezstvi() { /* Ověří, zda byl poražen boss v Bráně šampionů */ }

    /**
     * Vrací aktuální místnost.
     *
     * @return Aktuální místnost
     */
    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    /**
     * Nastaví aktuální místnost.
     *
     * @param aktualniMistnost Nová aktuální místnost
     */
    public void setAktualniMistnost(Mistnost aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }

    /**
     * Vrací batoh hráče.
     *
     * @return Batoh hráče
     */
    public Batoh getBatoh() {
        return batoh;
    }

    /**
     * Nastaví batoh hráče.
     *
     * @param batoh Nový batoh
     */
    public void setBatoh(Batoh batoh) {
        this.batoh = batoh;
    }

    /**
     * Vrací mapu dostupných příkazů.
     *
     * @return Mapa příkazů
     */
    public Map<String, IPrikaz> getMapaPrikazu() {
        return mapaPrikazu;
    }

    /**
     * Vrací aktivní kartu.
     *
     * @return Aktivní karta
     */
    public Karta getAktivniKarta() {
        return aktivniKarta;
    }

    /**
     * Nastaví aktivní kartu.
     *
     * @param aktivniKarta Nová aktivní karta
     */
    public void setAktivniKarta(Karta aktivniKarta) {
        this.aktivniKarta = aktivniKarta;
    }
}

