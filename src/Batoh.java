import java.util.ArrayList;
import java.util.List;

/**
 * Třída reprezentující batoh hráče.
 * Umožňuje ukládání a manipulaci s předměty a kartami.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class Batoh {
    /** Maximální kapacita batohu pro předměty */
    private static final int MAX_KAPACITA = 5;
    
    /** Seznam předmětů v batohu */
    private List<Predmet> predmety;
    
    /** Seznam karet v batohu (karty se do limitu nepočítají) */
    private List<Karta> karty;

    /**
     * Vytvoří nový prázdný batoh.
     */
    public Batoh() {
        this.predmety = new ArrayList<>();
        this.karty = new ArrayList<>();
    }

    /**
     * Přidá předmět do batohu.
     *
     * @param p Předmět k přidání
     * @return true pokud byl předmět úspěšně přidán, false jinak
     */
    public boolean pridejPredmet(Predmet p) {
        if (p == null || !p.isPrenositelny()) {
            return false;
        }
        if (predmety.size() >= MAX_KAPACITA) {
            return false;
        }
        predmety.add(p);
        return true;
    }

    /**
     * Přidá kartu do batohu.
     *
     * @param k Karta k přidání
     */
    public void pridejKartu(Karta k) {
        if (k != null) {
            karty.add(k);
        }
    }

    /**
     * Vyhodí předmět z batohu podle názvu.
     *
     * @param nazev Název předmětu k vyhození
     * @return Vyhozený předmět nebo null pokud předmět nebyl nalezen
     */
    public Predmet vyhodPredmet(String nazev) {
        if (nazev == null) return null;
        for (Predmet p : predmety) {
            if (p.getNazev().equalsIgnoreCase(nazev)) {
                predmety.remove(p);
                return p;
            }
        }
        return null;
    }

    /**
     * Najde kartu v batohu podle názvu.
     *
     * @param nazev Název hledané karty
     * @return Nalezená karta nebo null pokud karta nebyla nalezena
     */
    public Karta najdiKartu(String nazev) {
        if (nazev == null) return null;
        for (Karta k : karty) {
            if (k.getJmeno().equalsIgnoreCase(nazev)) {
                return k;
            }
        }
        return null;
    }

    /**
     * Odebere kartu z batohu.
     *
     * @param karta Karta k odebrání
     */
    public void odeberKartu(Karta karta) {
        karty.remove(karta);
    }

    /**
     * Vrací seznam karet v batohu.
     *
     * @return Seznam karet
     */
    public List<Karta> getKarty() {
        return karty;
    }

    /**
     * Vrací seznam předmětů v batohu.
     *
     * @return Seznam předmětů
     */
    public List<Predmet> getPredmety() {
        return predmety;
    }

    /**
     * Vytvoří textový výpis obsahu batohu.
     *
     * @return Textový popis obsahu batohu
     */
    public String vypisObsah() {
        String vysledek = "Batoh obsahuje:\n";
        
        if (predmety.isEmpty() && karty.isEmpty()) {
            vysledek += "  Batoh je prázdný.\n";
        } else {
            if (!predmety.isEmpty()) {
                vysledek += "  Předměty (" + predmety.size() + "/" + MAX_KAPACITA + "):\n";
                for (Predmet p : predmety) {
                    vysledek += "    - " + p.getNazev() + ": " + p.getPopis() + "\n";
                }
            }
            if (!karty.isEmpty()) {
                vysledek += "  Karty (" + karty.size() + "):\n";
                for (Karta k : karty) {
                    vysledek += "    - " + k.getJmeno() + 
                               " [Útok: " + k.getUtok() + 
                               ", Obrana: " + k.getObrana() + 
                               ", Životy: " + k.getZivoty() + "]\n";
                }
            }
        }
        return vysledek;
    }
}
