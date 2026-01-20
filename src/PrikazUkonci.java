public class PrikazUkonci implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) { /* Spustí souboj mezi vyloženou kartou a NPC */
        return "";
    }

    @Override
    public String getNazev() {
        return "ukončí hru";
    }
}