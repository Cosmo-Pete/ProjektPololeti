public class PrikazUtok implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) {
        if (parametry == null || parametry.length == 0) {
            return "Musíš zadat název karty, kterou chceš vyložit pro boj.";
        }

        String nazevKarty = parametry[0];
        Batoh batoh = hra.getBatoh();
        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        
        if (batoh == null) {
            return "Batoh není dostupný.";
        }

        if (aktualniMistnost == null) {
            return "Není nastavena aktuální místnost.";
        }

        Karta karta = batoh.najdiKartu(nazevKarty);
        
        if (karta == null) {
            return "Karta '" + nazevKarty + "' není v batohu.";
        }

        Postava postava = aktualniMistnost.getPostava();
        
        if (postava == null) {
            return "V této místnosti není žádný nepřítel.";
        }

        if (!postava.isJeNepritel()) {
            return "Tato postava není nepřítelem.";
        }

        if (postava.getBalicekKaret().isEmpty()) {
            return "Nepřítel nemá žádné karty.";
        }

        Karta nepritelovaKarta = postava.getBalicekKaret().get(0);
        
        // Boj mezi kartami
        karta.utociNa(nepritelovaKarta);
        
        if (!nepritelovaKarta.jeZiva()) {
            postava.getBalicekKaret().remove(nepritelovaKarta);
            return "Porazil jsi nepřítele! Karta '" + karta.getJmeno() + "' porazila kartu '" + nepritelovaKarta.getJmeno() + "'.";
        }

        nepritelovaKarta.utociNa(karta);
        
        if (!karta.jeZiva()) {
            batoh.odeberKartu(karta);
            return "Nepřítel porazil tvou kartu '" + karta.getJmeno() + "'.";
        }

        return "Boj pokračuje. Karta '" + karta.getJmeno() + "' má " + karta.getZivoty() + " životů.";
    }

    @Override
    public String getNazev() {
        return "utok";
    }
}
