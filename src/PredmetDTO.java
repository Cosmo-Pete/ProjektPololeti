/**
 * DTO třída pro předmět.
 * Používá se pro serializaci/deserializaci předmětů v JSON souborech.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PredmetDTO {
    /** Název předmětu */
    public String nazev;
    
    /** Popis předmětu */
    public String popis;
    
    /** Zda je předmět přenositelný */
    public boolean prenositelny;
}
