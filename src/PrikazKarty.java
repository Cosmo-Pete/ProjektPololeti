/**
 * Příkaz pro zobrazení karet v batohu.
 * Umožňuje hráčovi prohlížet své karty.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazKarty implements IPrikaz {
    
    /**
     * Provede příkaz karty - zobrazí obsah batohu.
     *
     * @param parametry Parametry příkazu (nepoužívají se)
     * @param hra Instance hry
     * @return Obsah batohu nebo chybová zpráva
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        Batoh batoh = hra.getBatoh();
        if (batoh == null) {
            return "Batoh není inicializován.";
        }

        String obsah = batoh.vypisObsah();
        if (obsah.isEmpty()) {
            return "Batoh je prázdný.";
        }
        return obsah;
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("karty")
     */
    @Override
    public String getNazev() {
        return "karty";
    }
}
