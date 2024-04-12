package AST;

public class GrStNb extends ExpressionA_Binaire {

    public GrStNb(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "GrStNb";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "GrStNb\n";
    }
}
