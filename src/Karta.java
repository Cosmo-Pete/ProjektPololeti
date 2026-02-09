public class Karta {
    private String jmeno;
    private int utok;
    private int obrana;
    private int zivoty;
    private int maxZivoty;
    private int pocetVylepseni;

    public Karta(String jmeno, int utok, int obrana, int zivoty) {
        this.jmeno = jmeno;
        this.utok = utok;
        this.obrana = obrana;
        this.zivoty = zivoty;
        this.maxZivoty = zivoty;
        this.pocetVylepseni = 0;
    }

    public boolean vylepsiStatistiky() {
        if (pocetVylepseni >= 1) {
            return false;
        }
        utok += 2;
        obrana += 2;
        maxZivoty += 5;
        zivoty = maxZivoty;
        pocetVylepseni++;
        return true;
    }

    public void utociNa(Karta souper) {
        if (souper == null) return;
        int poskozeni = Math.max(1, utok - souper.obrana);
        souper.zivoty -= poskozeni;
        if (souper.zivoty < 0) {
            souper.zivoty = 0;
        }
    }

    public void setUtok(int utok) {
        this.utok = utok;
    }

    public void setObrana(int obrana) {
        this.obrana = obrana;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = Math.min(zivoty, maxZivoty);
    }

    public boolean jeZiva() {
        return zivoty > 0;
    }

    public void resetVylepseni() {
        pocetVylepseni = 0;
    }

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
