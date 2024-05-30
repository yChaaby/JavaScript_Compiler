package AST;

// Classe pour représenter une variable
public class DoWhileCommand extends Commande {
    private ExpressionA cond;
    private Commande cmd;

    public DoWhileCommand(Commande cmd, ExpressionA expr) {
        this.cmd=cmd;
        this.cond=expr;
    }
    @Override
    public String toAssembly() {
        String s = (this.cmd).toAssembly();
        String c = (this.cond).toAssembly();
        return s + c + "ConJmp -" + (Tools.countNewLines(s) + Tools.countNewLines(c)-1) + "\n";
    }
}
