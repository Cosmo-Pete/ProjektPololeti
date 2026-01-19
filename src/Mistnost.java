import java.util.Map;

public class Mistnost {
    private String nazev;
    private String popis;
    private Map<String, Mistnost> vychody;
    private Map<String, Predmet> predmety;
    private Postava postava;

    public void pridejVychod(String smer, Mistnost cil) { }
    public Mistnost getVychod(String smer) { return null; }
    public void vlozPredmet(Predmet p) { }
    public Predmet odeberPredmet(String nazev) { return null; }
    public String dlouhyPopis() { return ""; } // Vypíše název, popis, východy, předměty a postavu
}

