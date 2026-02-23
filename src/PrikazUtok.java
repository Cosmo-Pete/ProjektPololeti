/**
 * Příkaz pro útok na nepřítele.
 * Umožňuje hráčovi bojovat s nepřáteli pomocí karet.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazUtok implements IPrikaz {
    
    /**
     * Provede příkaz utok - zahájí boj s nepřítelem.
     *
     * @param parametry Parametry příkazu (nepoužívají se)
     * @param hra Instance hry
     * @return Zpráva o výsledku boje
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        Batoh batoh = hra.getBatoh();
        Mistnost aktualniMistnost = hra.getAktualniMistnost();
        Karta karta = hra.getAktivniKarta();
        
        if (batoh == null) {
            return "Batoh není dostupný.";
        }

        if (aktualniMistnost == null) {
            return "Není nastavena aktuální místnost.";
        }

        if (karta == null) {
            return "Není vyložena žádná karta. Nejprve vylož kartu pomocí příkazu 'hraj'.";
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
        
        // Výpis statistik nepřitelovy karty
        String vysledek = "Nepřítel vyložil kartu: " + nepritelovaKarta.getJmeno() + " [Útok: " + nepritelovaKarta.getUtok() + ", Obrana: " + nepritelovaKarta.getObrana() + ", Životy: " + nepritelovaKarta.getZivoty() + "]\n";
        
        // Boj mezi kartami
        karta.utociNa(nepritelovaKarta);
        
        if (!nepritelovaKarta.jeZiva()) {
            postava.getBalicekKaret().remove(nepritelovaKarta);
            batoh.pridejKartu(nepritelovaKarta);
            vysledek += "Porazil jsi nepřítele! Karta '" + karta.getJmeno() + "' porazila kartu '" + nepritelovaKarta.getJmeno() + "'. Získal jsi kartu '" + nepritelovaKarta.getJmeno() + "'.";
            
            // Kontrola, zda hráč vyhrál hru
            hra.zkontrolujVitezstvi();
            
            return vysledek;
        }

        nepritelovaKarta.utociNa(karta);
        
        if (!karta.jeZiva()) {
            batoh.odeberKartu(karta);
            vysledek += "Nepřítel porazil tvou kartu '" + karta.getJmeno() + "'.";
            
            // Kontrola, zda hráč má ještě nějaké karty
            if (batoh.getKarty().isEmpty()) {
                hra.setKonecHry(true);
                vysledek += " Nemáš žádné karty. Prohrál jsi!";
                return vysledek;
            }
            
            return vysledek;
        }

        // Resetování počtu vylepšení po boji
        karta.resetVylepseni();

        vysledek += "Boj pokračuje. Karta '" + karta.getJmeno() + "' má " + karta.getZivoty() + " životů.";
        return vysledek;
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("utok")
     */
    @Override
    public String getNazev() {
        return "utok";
    }
}
