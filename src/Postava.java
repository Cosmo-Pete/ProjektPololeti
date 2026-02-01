import java.util.List;
import java.util.ArrayList;

public class Postava {
    private String jmeno;
    private String dialog;
    private boolean jeNepritel;
    private List<Karta> balicekKaret;

    public Postava(String jmeno, String dialog, boolean jeNepritel) {
        this.jmeno = jmeno;
        this.dialog = dialog;
        this.jeNepritel = jeNepritel;
        this.balicekKaret = new ArrayList<>();
    }

    public String promluv() {
        return dialog;
    }

    
    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getDialog() {
        return dialog;
    }

    public void setDialog(String dialog) {
        this.dialog = dialog;
    }

    public boolean isJeNepritel() {
        return jeNepritel;
    }

    public void setJeNepritel(boolean jeNepritel) {
        this.jeNepritel = jeNepritel;
    }

    public List<Karta> getBalicekKaret() {
        return balicekKaret;
    }

    public void setBalicekKaret(List<Karta> balicekKaret) {
        this.balicekKaret = balicekKaret;
    }
}
