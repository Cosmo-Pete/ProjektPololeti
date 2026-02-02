import java.util.ArrayList;
import java.util.List;

public class Batoh {
    private static final int MAX_KAPACITA = 5;
    private List<Predmet> predmety;
    private List<Karta> karty; // Karty se do limitu 5 nepočítají

    public Batoh() {
        this.predmety = new ArrayList<>();
        this.karty = new ArrayList<>();
    }

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

    public void pridejKartu(Karta k) {
        if (k != null) {
            karty.add(k);
        }
    }

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

    public Karta najdiKartu(String nazev) {
        if (nazev == null) return null;
        for (Karta k : karty) {
            if (k.getJmeno().equalsIgnoreCase(nazev)) {
                return k;
            }
        }
        return null;
    }

    public void odeberKartu(Karta karta) {
        karty.remove(karta);
    }

    public List<Karta> getKarty() {
        return karty;
    }

    public List<Predmet> getPredmety() {
        return predmety;
    }

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
