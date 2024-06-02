package AST;

// Classe pour représenter une affectation de variable
public class Assignment extends Commande {
    private String varName;
    private ExpressionA expression;

    public Assignment(String varName, ExpressionA expr) {
        this.varName = varName;
        this.expression = expr;
    }

    @Override
    public String toAssembly() {
        return expression.toAssembly() + "SetVar " + varName + "\n";
    }

    
    public Object evaluate() {
        Object value = expression.evaluate();
        SymbolTable.assignVariable(varName, value);
        return value;
    }
}
