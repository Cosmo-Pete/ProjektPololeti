public class PrikazPomoc implements IPrikaz {
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
               "- obetuj [předmět]: Obětuje předmět.\n" +
               "- poloz [předmět]: Položí předmět do místnosti.\n" +
               "- pouzij [předmět]: Použije předmět.\n" +
               "- vylepsi [předmět]: Vylepší předmět.\n" +
               "- ukonci: Ukončí hru.\n" +
               "- napoveda: Zobrazí tuto nápovědu.";
    }

    @Override
    public String getNazev() {
        return "pomoc";
    }
}