package AST;

public class Div extends ExpressionA_Binaire {

    public Div(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "div";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "DivNb\n";
    }
}
