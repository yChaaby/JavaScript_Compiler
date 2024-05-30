package AST;

// Classe pour représenter une variable
public class VariableExpr extends ExpressionA {
    private String name;

    public VariableExpr(String name) {
        this.name = name;
    }

    @Override
    public String toAssembly() {
        return "GetVar " + name + "\n";
    }

    @Override
    public Object evaluate() {
        return SymbolTable.getVariable(name);
    }
}
