/**
 * Hlavní třída aplikace - vstupní bod hry.
 * Stará se o inicializaci hry a hlavní herní smyčku.
 *
 * @author Petr Pospíchal
 * @version 1.0
 */
package cz.petrp;

import java.util.Scanner;

public class Main {
    
    /**
     * Hlavní metoda - vstupní bod aplikace.
     * Inicializuje hru, registruje příkazy a spouští hlavní herní smyčku.
     *
     * @param args Parametry příkazové řádky (nepoužívají se)
     */
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
        hra.getMapaPrikazu().put("mluv", new PrikazMluv());
        hra.getMapaPrikazu().put("napoveda", new PrikazNapoveda());
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("===================================================");
        System.out.println("Vítej ve hře!");
        System.out.println("===================================================");
        System.out.println("Jsi na začátku svého dobrodružství.");
        System.out.println("Máš k dispozici startovní kartu a batoh.");
        System.out.println("Zadej příkaz (např. 'pomoc' pro nápovědu):");
        
        // Hlavní herní smyčka
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