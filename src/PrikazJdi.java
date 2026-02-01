public class PrikazJdi implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) {
        if (parametry == null || parametry.length == 0) {
            return "Kam chceš jít? Musíš zadat směr (sever, jih, východ, západ).";
        }

        String smer = parametry[0].toLowerCase();
        
        
        if (smer.equals("východ") || smer.equals("vychod")) {
            smer = "vychod";
        } else if (smer.equals("západ") || smer.equals("zapad")) {
            smer = "zapad";
        }

        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        if (aktualniMistnost == null) {
            return "Není nastavena aktuální místnost.";
        }

        Mistnost cilovaMistnost = aktualniMistnost.getVychod(smer);
        

        if (cilovaMistnost == null) {
            return "Tímto směrem se nelze pohnout. Zůstáváš v " + aktualniMistnost.getNazev() + ".";
        }


        hra.setAktualniMistnost(cilovaMistnost);
        return "Přesunul jsi se do " + cilovaMistnost.getNazev() + ".\n" + cilovaMistnost.getPopis();
    }

    @Override
    public String getNazev() {
        return "jdi";
    }
}

