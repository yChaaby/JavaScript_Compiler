package AST;

// Classe pour représenter une variable
public class DoWhileCommand extends Commande {
    private ExpressionA cond;
    public Commande cmd;

    public DoWhileCommand(Commande cmd, ExpressionA expr) {
        this.cmd=cmd;
        this.cond=expr;
    }
    @Override
    public String toAssembly() {
        String s = (this.cmd).toAssembly();
        String c = (this.cond).toAssembly();
        String fc = "TypeOf\nCase 3\nJump 15\nNoop\nNoop\nNbToBo\nJump 11\nNoop\nError\nNoop\nNoop\nDrop\nCsteBo false\nJump 4\nError\nNoop\nNoop\nError\n";
        if(this.cond instanceof Num || this.cond instanceof FloatT){
            c += "NbToBo\n";
        }else if(this.cond instanceof Undefined){
            c += "Drop\nCsteBo false\n";
        }else{
            c += "TypeOf\nCase 3\nJump 15\nNoop\nNoop\nNbToBo\nJump 11\nNoop\nError\nNoop\nNoop\nDrop\nCsteBo false\nJump 4\nError\nNoop\nNoop\nError\n";
        }


        return s + c + fc +"Not\nConJmp -" + (Tools.countNewLines(s) + Tools.countNewLines(c)+2+Tools.countNewLines(fc)) + "\n";
    }
}
