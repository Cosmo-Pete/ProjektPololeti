import java.util.HashMap;
import java.util.Map;

public class Hra {
    private Mistnost aktualniMistnost;
    private Batoh batoh;
    private boolean konecHry;
    private Map<String, IPrikaz> mapaPrikazu;

    public Hra() {
        this.konecHry = false;
        this.mapaPrikazu = new HashMap<>();
    }

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

    public String zpracujPrikaz(String radek) { // Rozpozná příkaz a zavolá proved()
        return "";
    }

    public boolean jeKonec() {
        return konecHry;
    }

    public void setKonecHry(boolean konec) {
        this.konecHry = konec;
    }

    public void zkontrolujVitezstvi() { /* Ověří, zda byl poražen boss v Bráně šampionů */ }

    public Mistnost getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(Mistnost aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }

    public Batoh getBatoh() {
        return batoh;
    }

    public void setBatoh(Batoh batoh) {
        this.batoh = batoh;
    }
}

