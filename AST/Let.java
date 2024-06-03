package AST;

public class Let extends Commande {
    public String varName;

    public Let(String varName) {
        this.varName = varName;
    }

    @Override
    public String toAssembly() {
        return "DclVar " + varName + "\n";
    }
}