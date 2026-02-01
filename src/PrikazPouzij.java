public class PrikazPouzij implements IPrikaz {
    @Override
    public String proved(String[] parametry, Hra hra) { /* Spustí souboj mezi vyloženou kartou a NPC */
        return "";
    }

    @Override
    public String getNazev() {
        return "item který se použil + na co se použil";
    }
}