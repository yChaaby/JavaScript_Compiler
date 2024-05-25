package AST;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class Import extends Commande {

    public Commande arg;

    public Import(Commande arg) {
        this.arg = arg;
    }

    public String toString() {
        return String.format("Import(%1$s)", arg.toString());
    }
    @Override
    public String toAssembly() {
        String content="";
        try {
            List<String> lines = Files.readAllLines(Paths.get(String.format("%1$s", arg.toString())));
            for (String line : lines) {
                content+=("\n"+line);
            }
        }catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return  (arg.toAssembly())+content;
    }
}
