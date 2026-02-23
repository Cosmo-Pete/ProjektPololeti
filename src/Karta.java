/**
 * Třída reprezentující kartu ve hře.
 * Karty slouží pro bojové souboje mezi hráčem a nepřáteli.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class Karta {
    /** Název karty */
    private String jmeno;
    
    /** Útočná síla karty */
    private int utok;
    
    /** Obranná síla karty */
    private int obrana;
    
    /** Aktuální životy karty */
    private int zivoty;
    
    /** Maximální životy karty */
    private int maxZivoty;
    
    /** Počet vylepšení karty */
    private int pocetVylepseni;

    /**
     * Vytvoří novou kartu s danými parametry.
     *
     * @param jmeno Název karty
     * @param utok Útočná síla
     * @param obrana Obranná síla
     * @param zivoty Počáteční životy
     */
    public Karta(String jmeno, int utok, int obrana, int zivoty) {
        this.jmeno = jmeno;
        this.utok = utok;
        this.obrana = obrana;
        this.zivoty = zivoty;
        this.maxZivoty = zivoty;
        this.pocetVylepseni = 0;
    }

    /**
     * Vylepší statistiky karty.
     *
     * @return true pokud bylo vylepšení úspěšné, false pokud karta již byla vylepšena
     */
    public boolean vylepsiStatistiky() {
        if (pocetVylepseni >= 1) {
            return false;
        }
        utok += 2;
        obrana += 2;
        maxZivoty += 5;
        zivoty = maxZivoty;
        pocetVylepseni++;
        return true;
    }

    /**
     * Provede útok na soupeřovu kartu.
     *
     * @param souper Karta soupeře
     */
    public void utociNa(Karta souper) {
        if (souper == null) return;
        int poskozeni = Math.max(1, utok - souper.obrana);
        souper.zivoty -= poskozeni;
        if (souper.zivoty < 0) {
            souper.zivoty = 0;
        }
    }

    /**
     * Nastaví útočnou sílu karty.
     *
     * @param utok Nová útočná síla
     */
    public void setUtok(int utok) {
        this.utok = utok;
    }

    /**
     * Nastaví obrannou sílu karty.
     *
     * @param obrana Nová obranná síla
     */
    public void setObrana(int obrana) {
        this.obrana = obrana;
    }

    /**
     * Nastaví životy karty.
     *
     * @param zivoty Nové životy (maximálně maxZivoty)
     */
    public void setZivoty(int zivoty) {
        this.zivoty = Math.min(zivoty, maxZivoty);
    }

    /**
     * Vrací, zda je karta ještě naživu.
     *
     * @return true pokud má karta životy > 0, false jinak
     */
    public boolean jeZiva() {
        return zivoty > 0;
    }

    /**
     * Resetuje počet vylepšení karty.
     */
    public void resetVylepseni() {
        pocetVylepseni = 0;
    }

    /**
     * Vrací název karty.
     *
     * @return Název karty
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Vrací útočnou sílu karty.
     *
     * @return Útočná síla
     */
    public int getUtok() {
        return utok;
    }

    /**
     * Vrací obrannou sílu karty.
     *
     * @return Obranná síla
     */
    public int getObrana() {
        return obrana;
    }

    /**
     * Vrací aktuální životy karty.
     *
     * @return Aktuální životy
     */
    public int getZivoty() {
        return zivoty;
    }
}
