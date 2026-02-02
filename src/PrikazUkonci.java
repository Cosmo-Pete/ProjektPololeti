public class PrikazUkonci implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) {
        hra.setKonecHry(true);
        return "Děkuji za hraní! Hra byla ukončena.";
    }

    @Override
    public String getNazev() {
        return "konec";
    }
}
