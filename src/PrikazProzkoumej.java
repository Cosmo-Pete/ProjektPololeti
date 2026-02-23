/**
 * Příkaz pro prozkoumání místnosti.
 * Zobrazuje detailní popis aktuální místnosti.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazProzkoumej implements IPrikaz {
    
    /**
     * Provede příkaz prozkoumej - zobrazí detailní popis místnosti.
     *
     * @param parametry Parametry příkazu (nepoužívají se)
     * @param hra Instance hry
     * @return Detailní popis aktuální místnosti
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        if (aktualniMistnost == null) {
            return "Není nastavena aktuální místnost.";
        }

        return aktualniMistnost.dlouhyPopis();
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("prozkoumej")
     */
    @Override
    public String getNazev() {
        return "prozkoumej";
    }
}
