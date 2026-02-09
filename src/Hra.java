import java.util.HashMap;
import java.util.Map;

public class Hra {
    private Mistnost aktualniMistnost;
    private Batoh batoh;
    private boolean konecHry;
    private Map<String, IPrikaz> mapaPrikazu;
    private Karta aktivniKarta;

    public Hra() {
        this.konecHry = false;
        this.mapaPrikazu = new HashMap<>();
        this.aktivniKarta = null;
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

    public Map<String, IPrikaz> getMapaPrikazu() {
        return mapaPrikazu;
    }

    public Karta getAktivniKarta() {
        return aktivniKarta;
    }

    public void setAktivniKarta(Karta aktivniKarta) {
        this.aktivniKarta = aktivniKarta;
    }
}

