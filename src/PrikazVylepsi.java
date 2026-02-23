/**
 * Příkaz pro vylepšení karty.
 * Umožňuje hráčovi vylepšit statistiky své karty u moudrého stromu.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazVylepsi implements IPrikaz {
    
    /**
     * Provede příkaz vylepsi - vylepší statistiky karty.
     *
     * @param parametry Parametry příkazu (název karty)
     * @param hra Instance hry
     * @return Zpráva o výsledku vylepšení
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        if (parametry == null || parametry.length == 0) {
            return "Musíš zadat název karty, kterou chceš vylepšit.";
        }

        String nazevKarty = parametry[0];
        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        Batoh batoh = hra.getBatoh();
        
        if (aktualniMistnost == null) {
            return "Není nastavena aktuální místnost.";
        }

        if (batoh == null) {
            return "Batoh není dostupný.";
        }

        // Kontrola, zda je hráč u moudrého stromu
        if (!aktualniMistnost.getNazev().equals("Prostranství se stromem")) {
            return "Vylepšování karet je možné pouze u moudrého stromu.";
        }

        Karta karta = batoh.najdiKartu(nazevKarty);

        if (karta == null) {
            return "Karta '" + nazevKarty + "' není v batohu.";
        }

        // Budoucí implementace placení za vylepšení
        // int cena = 10; // Například 10 zlatých
        // if (!hra.odeberPenez(cena)) {
        //     return "Nemáš dostatek peněz na vylepšení karty.";
        // }

        // Vylepšení karty
        if (!karta.vylepsiStatistiky()) {
            return "Kartu '" + karta.getJmeno() + "' již nelze vylepšit. Počkej na další boj.";
        }
        return "Vylepšil jsi kartu: " + karta.getJmeno() + ". Nové statistiky: Útok: " + karta.getUtok() + ", Obrana: " + karta.getObrana() + ", Životy: " + karta.getZivoty() + ".";
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("vylepsi")
     */
    @Override
    public String getNazev() {
        return "vylepsi";
    }
}
