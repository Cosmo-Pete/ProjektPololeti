import java.util.List;
import java.util.ArrayList;

/**
 * Třída reprezentující postavu ve hře.
 * Postavy mohou být přátelské nebo nepřátelské a mohou mít balíček karet.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class Postava {
    /** Jméno postavy */
    private String jmeno;
    
    /** Dialog, který postava pronáší */
    private String dialog;
    
    /** Zda je postava nepřítel */
    private boolean jeNepritel;
    
    /** Balíček karet, které postava vlastní */
    private List<Karta> balicekKaret;

    /**
     * Vytvoří novou postavu s danými parametry.
     *
     * @param jmeno Jméno postavy
     * @param dialog Dialog postavy
     * @param jeNepritel Zda je postava nepřítel
     */
    public Postava(String jmeno, String dialog, boolean jeNepritel) {
        this.jmeno = jmeno;
        this.dialog = dialog;
        this.jeNepritel = jeNepritel;
        this.balicekKaret = new ArrayList<>();
    }

    /**
     * Vrací dialog postavy.
     *
     * @return Dialog postavy
     */
    public String promluv() {
        return dialog;
    }

    
    /**
     * Vrací jméno postavy.
     *
     * @return Jméno postavy
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Nastaví jméno postavy.
     *
     * @param jmeno Nové jméno postavy
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * Vrací dialog postavy.
     *
     * @return Dialog postavy
     */
    public String getDialog() {
        return dialog;
    }

    /**
     * Nastaví dialog postavy.
     *
     * @param dialog Nový dialog postavy
     */
    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    /**
     * Vrací, zda je postava nepřítel.
     *
     * @return true pokud je postava nepřítel, false jinak
     */
    public boolean isJeNepritel() {
        return jeNepritel;
    }

    /**
     * Nastaví, zda je postava nepřítel.
     *
     * @param jeNepritel true pokud je postava nepřítel, false jinak
     */
    public void setJeNepritel(boolean jeNepritel) {
        this.jeNepritel = jeNepritel;
    }

    /**
     * Vrací balíček karet postavy.
     *
     * @return Balíček karet
     */
    public List<Karta> getBalicekKaret() {
        return balicekKaret;
    }

    /**
     * Nastaví balíček karet postavy.
     *
     * @param balicekKaret Nový balíček karet
     */
    public void setBalicekKaret(List<Karta> balicekKaret) {
        this.balicekKaret = balicekKaret;
    }
}
