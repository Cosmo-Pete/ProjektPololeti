/**
 * Příkaz pro ukončení hry.
 * Umožňuje hráčovi ukončit hru.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazUkonci implements IPrikaz {
    
    /**
     * Provede příkaz ukonci - ukončí hru.
     *
     * @param parametry Parametry příkazu (nepoužívají se)
     * @param hra Instance hry
     * @return Rozloučení a potvrzení ukončení hry
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        hra.setKonecHry(true);
        return "Děkuji za hraní! Hra byla ukončena.";
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("konec")
     */
    @Override
    public String getNazev() {
        return "konec";
    }
}
