/**
 * DTO třída pro kartu.
 * Používá se pro serializaci/deserializaci karet v JSON souborech.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class KartaDTO {
    /** Název karty */
    public String jmeno;
    
    /** Útočná síla karty */
    public int utok;
    
    /** Obranná síla karty */
    public int obrana;
    
    /** Životy karty */
    public int zivoty;
}
