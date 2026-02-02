public class PrikazPoloz implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) {
        if (parametry == null || parametry.length == 0) {
            return "Musíš zadat název předmětu, který chceš položit.";
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

        Predmet predmet = batoh.vyhodPredmet(nazevPredmetu);
        
        if (predmet == null) {
            return "Předmět '" + nazevPredmetu + "' není v batohu.";
        }

        aktualniMistnost.vlozPredmet(predmet);
        
        return "Položil jsi předmět: " + predmet.getNazev() + " do místnosti.";
    }

    @Override
    public String getNazev() {
        return "poloz";
    }
}