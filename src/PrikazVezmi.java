/**
 * Příkaz pro sebírání předmětů.
 * Umožňuje hráčovi vzít předměty z místnosti do batohu.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazVezmi implements IPrikaz {
    
    /**
     * Provede příkaz vezmi - přenese předmět z místnosti do batohu.
     *
     * @param parametry Parametry příkazu (název předmětu)
     * @param hra Instance hry
     * @return Zpráva o výsledku provedení příkazu
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        if (parametry == null || parametry.length == 0) {
            return "Musíš zadat název předmětu, který chceš vzít.";
        }

        String nazevPredmetu = parametry[0];
        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        Batoh batoh = hra.getBatoh();
        
        if (aktualniMistnost == null) {
            return "Není nastavena aktuální místnost.";
        }

        if (batoh == null) {
            return "Batoh není dostupný.";
        }

        Predmet predmet = aktualniMistnost.odeberPredmet(nazevPredmetu);
        
        if (predmet == null) {
            return "Předmět '" + nazevPredmetu + "' není v této místnosti.";
        }

        if (!predmet.isPrenositelny()) {
            return "Předmět '" + nazevPredmetu + "' není přenositelný.";
        }

        if (!batoh.pridejPredmet(predmet)) {
            aktualniMistnost.vlozPredmet(predmet); // Vrátí předmět zpět, pokud se nepodařilo přidat do batohu
            return "Batoh je plný. Nemůžeš vzít předmět '" + nazevPredmetu + "'.";
        }

        return "Vzal jsi předmět: " + predmet.getNazev() + ".";
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("vezmi")
     */
    @Override
    public String getNazev() {
        return "vezmi";
    }
}
