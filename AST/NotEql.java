package AST;

public class NotEql extends ExpressionA_Binaire {

    public NotEql(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "NotEqual";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "NotEql\n";
    }
}
