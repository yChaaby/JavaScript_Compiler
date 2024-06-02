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

        String t = this.trueBranch.toAssembly();
        String f = this.falseBranch.toAssembly();
        String e = this.condition.toAssembly();
        if(this.condition instanceof Num || this.condition instanceof FloatT){
            e += "NbToBo\n";
        }else if(this.condition instanceof Undefined){
            e += "Drop\nCsteBo false\n";
        }else {
            e += "TypeOf\nCase 3\nJump 15\nNoop\nNoop\nNbToBo\nJump 11\nNoop\nError\nNoop\nNoop\nDrop\nCsteBo false\nJump 4\nError\nNoop\nNoop\nError\n";
        }



        return e + "ConJmp "+ (Tools.countNewLines(t)+1) +"\n"+ t + "Jump "+ (Tools.countNewLines(f)) + "\n" + f ;
    }
}
