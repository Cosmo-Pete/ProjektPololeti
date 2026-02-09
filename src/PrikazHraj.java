public class PrikazHraj implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) {
        if (parametry == null || parametry.length == 0) {
            return "Kterou kartu chceš hrát? Zadej název karty.";
        }

        Batoh batoh = hra.getBatoh();
        if (batoh == null) {
            return "Batoh není inicializován.";
        }

        String nazevKarty = String.join(" ", parametry);
        Karta karta = batoh.najdiKartu(nazevKarty);

        if (karta == null) {
            return "Kartu '" + nazevKarty + "' nemáš v batohu.";
        }

        // Nastavení aktivní karty
        hra.setAktivniKarta(karta);
        
        // Zobrazení statistik karty
        return "Hraješ kartu: " + karta.getJmeno() + 
               " [Útok: " + karta.getUtok() + 
               ", Obrana: " + karta.getObrana() + 
               ", Životy: " + karta.getZivoty() + "]";
    }

    @Override
    public String getNazev() {
        return "hraj";
    }
}
