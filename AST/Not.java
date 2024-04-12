package AST;

public class Not extends ExpressionA {

    public ExpressionA arg;

    public Not(ExpressionA arg) {
        this.arg = arg;
    }

    public String toString() {
        return String.format("Not(%1$s)", arg.toString());
    }
    public String toAssembly() {
        return  (arg.toAssembly())+"Not\n";
    }
}
