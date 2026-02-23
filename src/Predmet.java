/**
 * Třída reprezentující předmět ve hře.
 * Předměty mohou být sebírány, používány nebo ukládány v batohu.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class Predmet {
    /** Název předmětu */
    private String nazev;
    
    /** Popis předmětu */
    private String popis;
    
    /** Zda je předmět přenositelný */
    private boolean prenositelny;

    /**
     * Vytvoří nový předmět s danými parametry.
     *
     * @param nazev Název předmětu
     * @param popis Popis předmětu
     * @param prenositelny Zda je předmět přenositelný
     */
    public Predmet(String nazev, String popis, boolean prenositelny) {
        this.nazev = nazev;
        this.popis = popis;
        this.prenositelny = prenositelny;
    }

    /**
     * Vrací název předmětu.
     *
     * @return Název předmětu
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * Vrací popis předmětu.
     *
     * @return Popis předmětu
     */
    public String getPopis() {
        return popis;
    }

    /**
     * Vrací, zda je předmět přenositelný.
     *
     * @return true pokud je předmět přenositelný, false jinak
     */
    public boolean isPrenositelny() {
        return prenositelny;
    }
}
