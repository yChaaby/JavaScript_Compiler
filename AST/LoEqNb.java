package AST;

public class LoEqNb extends ExpressionA_Binaire {

    public LoEqNb(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "LoEqNb";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "LoEqNb\n";
    }
}
