/**
 * Třída pro parsování vstupních příkazů od hráče.
 * Rozděluje vstup na název příkazu a jeho parametry.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class Parser {

    /**
     * Rozdělí vstupní řádek na název příkazu a parametry.
     *
     * @param vstup Vstupní řádek od hráče
     * @return Pole stringů, kde první prvek je název příkazu a druhý jsou parametry,
     *         nebo prázdné pole pokud je vstup neplatný
     */
    public String[] parsujVstup(String vstup) {
        if (vstup == null || vstup.trim().isEmpty()) {
            return new String[0];
        }

        String[] casti = vstup.trim().split("\\s+", 2);
        
        if (casti.length == 0) {
            return new String[0];
        }

        String nazevPrikazu = casti[0].toLowerCase();
        String parametry = (casti.length > 1) ? casti[1] : "";
        
        if (parametry.isEmpty()) {
            return new String[]{nazevPrikazu};
        }

        return new String[]{nazevPrikazu, parametry};
    }
}
