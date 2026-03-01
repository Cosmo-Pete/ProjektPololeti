/**
 * Příkaz pro zobrazení nápovědy.
 * Zobrazuje seznam dostupných příkazů ve hře.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
public class PrikazPomoc implements IPrikaz {
    
    /**
     * Provede příkaz pomoc - zobrazí nápovědu.
     *
     * @param parametry Parametry příkazu (nepoužívají se)
     * @param hra Instance hry
     * @return Text s nápovědou
     */
    @Override
    public String proved(String[] parametry, Hra hra) {
        return "Dostupné příkazy ve hře:\n" +
               "- jdi [směr]: Přesun do jiné místnosti (sever, jih, východ, západ).\n" +
               "- vezmi [předmět]: Vezme předmět z místnosti.\n" +
               "- utok: Útok na nepřítele.\n" +
               "- mluv [postava]: Mluví s postavou v místnosti.\n" +
               "- prozkoumej [předmět/postava]: Prozkoumá předmět nebo postavu.\n" +
               "- pomoc: Zobrazí obecnou nápovědu.\n" +
               "- karty: Zobrazí karty v batohu.\n" +
               "- hraj [karta]: Zahraje kartu.\n" +
               "- obetuj [obětovaná karta,karta posílená].\n" +
               "- poloz [předmět]: Položí předmět do místnosti.\n" +
               "- pouzij [předmět]: Použije předmět.\n" +
               "- vylepsi [předmět]: Vylepší předmět.\n" +
               "- ukonci: Ukončí hru.\n" +
               "- napoveda: Zobrazí tuto nápovědu.";
    }

    /**
     * Vrací název příkazu.
     *
     * @return Název příkazu ("pomoc")
     */
    @Override
    public String getNazev() {
        return "pomoc";
    }
}