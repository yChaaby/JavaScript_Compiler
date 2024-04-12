package AST;

public class Egal extends ExpressionA_Binaire {

    public Egal(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "Equals";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "Equals\n";
    }
}
