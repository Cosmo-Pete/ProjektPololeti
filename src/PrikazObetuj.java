/**
 * Příkaz pro obětování karty.
 * Umožňuje hráčovi obětovat jednu kartu pro posílení jiné karty u vlčího šamana.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazObetuj implements IPrikaz {
    
    /**
     * Provede příkaz obetuj - obětuje jednu kartu pro posílení jiné.
     *
     * @param parametry Parametry příkazu (název obětované karty, název posilované karty)
     * @param hra Instance hry
     * @return Zpráva o výsledku obětování
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        if (parametry == null || parametry.length < 2) {
            return "Musíš zadat dvě karty: obětovanou kartu a kartu, kterou chceš posílit.";
        }

        String nazevObetovaneKarty = parametry[0];
        String nazevPosilovaneKarty = parametry[1];
        Batoh batoh = hra.getBatoh();
        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        
        if (batoh == null) {
            return "Batoh není dostupný.";
        }

        // Kontrola, zda je hráč v jeskyni u vlčího šamana
        if (aktualniMistnost == null || !aktualniMistnost.getNazev().equals("Šamanova jeskyně")) {
            return "Obětování karty je možné pouze v jeskyni u vlčího šamana.";
        }

        Postava postava = aktualniMistnost.getPostava();
        if (postava == null || !postava.getJmeno().equals("Vlčí šaman")) {
            return "Obětování karty je možné pouze v jeskyni u vlčího šamana.";
        }

        Karta obetovanaKarta = batoh.najdiKartu(nazevObetovaneKarty);
        Karta posilovanaKarta = batoh.najdiKartu(nazevPosilovaneKarty);

        if (obetovanaKarta == null) {
            return "Karta '" + nazevObetovaneKarty + "' není v batohu.";
        }

        if (posilovanaKarta == null) {
            return "Karta '" + nazevPosilovaneKarty + "' není v batohu.";
        }

        // Obětování karty: odebrání obětované karty a posílení druhé karty
        batoh.odeberKartu(obetovanaKarta);
        posilovanaKarta.vylepsiStatistiky();

        return "Obětoval jsi kartu '" + obetovanaKarta.getJmeno() + "' a posílil jsi kartu '" + posilovanaKarta.getJmeno() + "'.";
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("obetuj")
     */
    @Override
    public String getNazev() {
        return "obetuj";
    }
}