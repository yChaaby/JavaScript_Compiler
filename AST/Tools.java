package AST;

public class Tools {
    public static int countNewLines(String input) {
        String[] lines = input.split("\n", -1); // Utilisez "\r\n" si nécessaire
        return lines.length;
    }
}