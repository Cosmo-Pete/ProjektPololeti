import java.util.Map;

/**
 * DTO třída pro místnost.
 * Používá se pro serializaci/deserializaci místností v JSON souborech.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class MistnostDTO {
    /** Název místnosti */
    public String nazev;
    
    /** Popis místnosti */
    public String popis;
    
    /** Mapa východů (směr -> cílová místnost) */
    public Map<String, String> vychody;
    
    /** Pole předmětů v místnosti */
    public PredmetDTO[] predmety;
    
    /** Postava v místnosti */
    public PostavaDTO postava;
}
