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
        return false;
    }

    public void pridejKartu(Karta k) {
    }

    public Predmet vyhodPredmet(String nazev) {
        return null;
    }

    public String vypisObsah() {
        return "";
    }
}
