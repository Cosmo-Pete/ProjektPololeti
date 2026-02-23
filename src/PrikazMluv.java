/**
 * Příkaz pro mluvení s postavami.
 * Umožňuje hráčovi komunikovat s postavami v místnosti.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazMluv implements IPrikaz {
    
    /**
     * Provede příkaz mluv - zahájí dialog s postavou.
     *
     * @param parametry Parametry příkazu (nepoužívají se)
     * @param hra Instance hry
     * @return Dialog postavy nebo chybová zpráva
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        if (aktualniMistnost == null) {
            return "Není nastavena aktuální místnost.";
        }

        Postava postava = aktualniMistnost.getPostava();
        if (postava == null) {
            return "V této místnosti není nikdo, s kým bys mohl mluvit.";
        }

        return postava.getJmeno() + " říká: " + postava.promluv();
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("mluv")
     */
    @Override
    public String getNazev() {
        return "mluv";
    }
}
