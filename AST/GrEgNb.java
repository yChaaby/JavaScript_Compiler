package AST;

public class GrEgNb extends ExpressionA_Binaire {

    public GrEgNb(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "GrEqNb";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "GrEqNb\n";
    }
}
