/**
 * Rozhraní pro všechny příkazy ve hře.
 * Definuje základní metody, které musí implementovat každý příkaz.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public interface IPrikaz {
    
    /**
     * Provede příkaz s danými parametry.
     *
     * @param parametry Parametry příkazu
     * @param hra Instance hry
     * @return Výsledek provedení příkazu
     */
    String proved(String[] parametry, Hra hra);

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu
     */
    String getNazev();
}
