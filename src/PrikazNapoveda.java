public class PrikazNapoveda implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) {
        return "Vítej v nápovědě k hře Projekt Pololeti!\n\n" +
               "Seznam příkazů:\n" +
               "- jdi [smer]: Přesun do jiné místnosti.\n" +
               "- vezmi [predmet]: Vezme předmět z místnosti.\n" +
               "- poloz [predmet]: Položí předmět do místnosti.\n" +
               "- utok: Zaútočí na nepřítele s aktivní kartou.\n" +
               "- karty: Zobrazí karty v batohu.\n" +
               "- hraj [karta]: Vyloží kartu pro souboj.\n" +
               "- vylepsi [karta]: Vylepší kartu u moudrého stromu.\n" +
               "- obetuj [karta1] [karta2]: Obětuje kartu1 a posílí kartu2.\n" +
               "- pomoc: Zobrazí nápovědu.\n" +
               "- ukonci: Ukončí hru.\n" +
               "- pouzij [predmet]: Použije předmět z batohu.\n" +
               "- prozkoumej: Prozkoumá aktuální místnost.\n" +
               "- mluv: Promluví s postavou v místnosti.\n" +
               "- napoveda: Zobrazí tuto nápovědu.\n\n" +
               "Podrobnosti o kartách:\n" +
               "- Každá karta má útok, obranu a životy.\n" +
               "- Karty lze vylepšovat u moudrého stromu.\n" +
               "- Karty lze obětovat u vlčího šamana.\n" +
               "- Karty lze použít v soubojích s protivníky.\n\n" +
               "Podrobnosti o soubojích:\n" +
               "- Souboje probíhají v jednom kole.\n" +
               "- Nejprve vylož kartu pomocí příkazu 'hraj'.\n" +
               "- Poté zaútoč pomocí příkazu 'utok'.\n" +
               "- Po porazení protivníka získáš jeho kartu.\n" +
               "- Pokud nemáš žádné karty, prohraješ.\n\n" +
               "Podrobnosti o vylepšování karet:\n" +
               "- Karty lze vylepšovat u moudrého stromu.\n" +
               "- Karta může být vylepšena pouze jednou.\n" +
               "- Po boji lze kartu vylepšit znovu.\n" +
               "- Vylepšení zvýší útok, obranu a životy karty.\n\n" +
               "Podrobnosti o předmětech:\n" +
               "- Předměty lze použít k vylepšení karet.\n" +
               "- Předměty lze získat v místnostech.\n" +
               "- Předměty lze použít pomocí příkazu 'pouzij'.\n" +
               "- Předměty mají různé účinky.\n\n" +
               "Podrobnosti o obětování karet:\n" +
               "- Karty lze obětovat u vlčího šamana.\n" +
               "- Obětování posílí jinou kartu.\n" +
               "- Obětování odebere obětovanou kartu.\n" +
               "- Obětování lze provést pouze v jeskyni.\n";
    }


    @Override
    public String getNazev() {
        return "napoveda";
    }
}