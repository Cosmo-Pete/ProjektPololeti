import java.util.Map;

public class Hra {
    private Mistnost aktualniMistnost;
    private Batoh batoh;
    private boolean konecHry;
    private Map<String, IPrikaz> mapaPrikazu;

    public void inicializujHru() { /* Načte svět přes NacitacSveta */ }
    public String zpracujPrikaz(String radek) { /* Rozpozná příkaz a zavolá proved() */ }
    public boolean jeKonec() { /* Vrací stav hry */ }
    public void setKonecHry(boolean konec) { /* Nastaví konec */ }
    public void zkontrolujVitezstvi() { /* Ověří, zda byl poražen boss v Bráně šampionů */ }

    // Gettery pro Batoh a Mistnost
}

