package AST;

public class Return extends Commande {
    private ExpressionA expr;
    public Return(ExpressionA expr) {
        this.expr = expr;
    }
    public String toAssembly(){
        return expr.toAssembly()+"Return \n";
    }
    public Object evaluate(){
        return null;
    }
}