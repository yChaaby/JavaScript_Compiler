package AST;

public class LoStNb extends ExpressionA_Binaire {

    public LoStNb(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "LoStNb";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "LoStNb\n";
    }
}
