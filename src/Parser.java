public class Parser {

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
