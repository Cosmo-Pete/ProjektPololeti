public class Karta {
    private String jmeno;
    private int utok;
    private int obrana;
    private int zivoty;

    public Karta(String jmeno, int utok, int obrana, int zivoty) {
        this.jmeno = jmeno;
        this.utok = utok;
        this.obrana = obrana;
        this.zivoty = zivoty;
    }

    public void vylepsiStatistiky() { /* Logika pro Moudrý strom */ }

    public void utociNa(Karta souper) { /* Logika souboje */ }

    public String getJmeno() {
        return jmeno;
    }

    public int getUtok() {
        return utok;
    }

    public int getObrana() {
        return obrana;
    }

    public int getZivoty() {
        return zivoty;
    }
}
