package AST;

public class Throw extends Commande {
    protected ExpressionA exp;
    public Throw(ExpressionA exp){
        this.exp = exp;
    }
    public String toAssembly(){
        return exp.toAssembly()+"Throw\n";
    }

}