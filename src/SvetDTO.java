/**
 * DTO třída pro celý svět hry.
 * Obsahuje informace o počáteční místnosti a všech místnostech ve světě.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class SvetDTO {
    /** Název startovní místnosti */
    public String startovniMistnost;
    
    /** Pole všech místností ve světě */
    public MistnostDTO[] mistnosti;
}
