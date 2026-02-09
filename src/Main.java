//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.inicializujHru();
        
        // Registrace příkazů
        hra.getMapaPrikazu().put("jdi", new PrikazJdi());
        hra.getMapaPrikazu().put("vezmi", new PrikazVezmi());
        hra.getMapaPrikazu().put("poloz", new PrikazPoloz());
        hra.getMapaPrikazu().put("utok", new PrikazUtok());
        hra.getMapaPrikazu().put("karty", new PrikazKarty());
        hra.getMapaPrikazu().put("hraj", new PrikazHraj());
        hra.getMapaPrikazu().put("vylepsi", new PrikazVylepsi());
        hra.getMapaPrikazu().put("obetuj", new PrikazObetuj());
        hra.getMapaPrikazu().put("pomoc", new PrikazPomoc());
        hra.getMapaPrikazu().put("ukonci", new PrikazUkonci());
        hra.getMapaPrikazu().put("pouzij", new PrikazPouzij());
        hra.getMapaPrikazu().put("prozkoumej", new PrikazProzkoumej());
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vítej ve hře! Zadej příkaz (např. 'pomoc' pro nápovědu):");
        
        while (!hra.jeKonec()) {
            System.out.print("> ");
            String vstup = scanner.nextLine();
            String vysledek = hra.zpracujPrikaz(vstup);
            System.out.println(vysledek);
        }
        
        scanner.close();
        System.out.println("Hra ukončena.");
    }
}