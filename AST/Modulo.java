package AST;

public class Modulo extends ExpressionA_Binaire {

    public Modulo(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

    public String symbole() {return "Modulo";};
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "ModuNb\n";
    }
}
