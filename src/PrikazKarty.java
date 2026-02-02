public class PrikazKarty implements IPrikaz {
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

    @Override
    public String getNazev() {
        return "karty";
    }
}
