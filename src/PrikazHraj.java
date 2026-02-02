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

        // Karta se přidá do batohu (už tam je), ale můžeme zobrazit její statistiky
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
