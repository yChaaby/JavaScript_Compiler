package AST;

// Classe pour représenter une commande if-then-else
public class IfElseCommand extends Commande {
    private ExpressionA condition;
    private Commande trueBranch;
    private Commande falseBranch;

    public IfElseCommand(ExpressionA condition, Commande trueBranch, Commande falseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    @Override
    public String toAssembly() {

        String t = trueBranch.toAssembly();
        String f = falseBranch.toAssembly();
        String e = this.condition.toAssembly();



        return e + "Conjmp "+ Tools.countNewLines(t) +"\n"+ t + "Jump "+ Tools.countNewLines(f) + "\n" + t ;
    }
}
