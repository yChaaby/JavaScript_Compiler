package AST;
import java.util.ArrayList;
import java.util.List;
public class Tools {
    public static int countNewLines(String input) {
        String[] lines = input.split("\n", -1); // Utilisez "\r\n" si nécessaire
        return lines.length-1;
    }
    public static boolean containsAnyElement(String str, List<String> elements) {
        for (String element : elements) {
            if (str.contains(element)) {
                return true;
            }
        }
        return false;
    }
}