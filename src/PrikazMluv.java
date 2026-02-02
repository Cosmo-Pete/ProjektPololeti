public class PrikazMluv implements IPrikaz {
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

    @Override
    public String getNazev() {
        return "mluv";
    }
}
