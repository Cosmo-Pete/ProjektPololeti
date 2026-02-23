/**
 * DTO třída pro postavu.
 * Používá se pro serializaci/deserializaci postav v JSON souborech.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PostavaDTO {
    /** Jméno postavy */
    public String jmeno;
    
    /** Dialog postavy */
    public String dialog;
    
    /** Zda je postava nepřítel */
    public boolean jeNepritel;
    
    /** Balíček karet postavy */
    public KartaDTO[] balicekKaret;
}
