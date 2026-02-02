public class PrikazProzkoumej implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) {
        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        if (aktualniMistnost == null) {
            return "Není nastavena aktuální místnost.";
        }

        return aktualniMistnost.dlouhyPopis();
    }

    @Override
    public String getNazev() {
        return "prozkoumej";
    }
}
