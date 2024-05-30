package AST;
public class Ident extends ExpressionA{
    private String arg;
    public Ident(String t){
        this.arg = t;
    }
    public String toString() {
        return arg;
    }

    public String toAssembly() {
        return  "GetVar " + this.arg + "\n";
    }
    @Override
    public Object evaluate() {
        return SymbolTable.getVariable(arg);
    }
}