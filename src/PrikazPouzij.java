/**
 * Příkaz pro použití předmětu.
 * Umožňuje hráčovi použít předměty z batohu pro různé účely.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazPouzij implements IPrikaz {
    
    /**
     * Provede příkaz pouzij - použije předmět z batohu.
     *
     * @param parametry Parametry příkazu (název předmětu)
     * @param hra Instance hry
     * @return Zpráva o výsledku použití předmětu
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        if (parametry == null || parametry.length == 0) {
            return "Musíš zadat název předmětu, který chceš použít.";
        }

        String nazevPredmetu = parametry[0];
        Batoh batoh = hra.getBatoh();
        
        if (batoh == null) {
            return "Batoh není dostupný.";
        }

        Predmet predmet = null;
        for (Predmet p : batoh.getPredmety()) {
            if (p.getNazev().equalsIgnoreCase(nazevPredmetu)) {
                predmet = p;
                break;
            }
        }

        if (predmet == null) {
            return "Předmět '" + nazevPredmetu + "' není v batohu.";
        }

        // Použití předmětu
        if (predmet.getNazev().equals("Léčivý lektvar")) {
            // Vylepší všechny karty v batohu
            for (Karta karta : batoh.getKarty()) {
                karta.setZivoty(karta.getZivoty() + 15);
            }
            batoh.getPredmety().remove(predmet);
            return "Použil jsi léčivý lektvar. Všechny karty mají nyní o 15 životů více.";
        } else if (predmet.getNazev().equals("Amulet síly")) {
            // Zvýší útok všech karet v batohu
            for (Karta karta : batoh.getKarty()) {
                karta.setUtok(karta.getUtok() + 5);
            }
            batoh.getPredmety().remove(predmet);
            return "Použil jsi amulet síly. Všechny karty mají nyní o 5 útoku více.";
        } else if (predmet.getNazev().equals("Magický kámen")) {
            // Zvýší obranu všech karet v batohu
            for (Karta karta : batoh.getKarty()) {
                karta.setObrana(karta.getObrana() + 5);
            }
            batoh.getPredmety().remove(predmet);
            return "Použil jsi magický kámen. Všechny karty mají nyní o 5 obrany více.";
        } else if (predmet.getNazev().equals("Velký lektvar")) {
            // Vylepší všechny karty v batohu
            for (Karta karta : batoh.getKarty()) {
                karta.setZivoty(karta.getZivoty() + 30);
            }
            batoh.getPredmety().remove(predmet);
            return "Použil jsi velký lektvar. Všechny karty mají nyní o 30 životů více.";
        } else if (predmet.getNazev().equals("Svitok síly")) {
            // Zvýší útok všech karet v batohu
            for (Karta karta : batoh.getKarty()) {
                karta.setUtok(karta.getUtok() + 8);
            }
            batoh.getPredmety().remove(predmet);
            return "Použil jsi svitek síly. Všechny karty mají nyní o 8 útoku více.";
        } else if (predmet.getNazev().equals("Amulet ochrany")) {
            // Zvýší obranu všech karet v batohu
            for (Karta karta : batoh.getKarty()) {
                karta.setObrana(karta.getObrana() + 5);
            }
            batoh.getPredmety().remove(predmet);
            return "Použil jsi amulet ochrany. Všechny karty mají nyní o 5 obrany více.";
        } else if (predmet.getNazev().equals("Svitok moudrosti")) {
            // Zvýší útok, obranu i životy všech karet v batohu
            for (Karta karta : batoh.getKarty()) {
                karta.setUtok(karta.getUtok() + 3);
                karta.setObrana(karta.getObrana() + 3);
                karta.setZivoty(karta.getZivoty() + 10);
            }
            batoh.getPredmety().remove(predmet);
            return "Použil jsi svitek moudrosti. Všechny karty mají nyní o 3 útoku, 3 obrany a 10 životů více.";
        } else {
            return "Předmět '" + predmet.getNazev() + "' nemá žádný účinek.";
        }
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("pouzij")
     */
    @Override
    public String getNazev() {
        return "pouzij";
    }
}