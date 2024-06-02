package AST;

public class Egal extends ExpressionA_Binaire {

    public Egal(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "Equals";
    }
    public String toAssembly() {
        String gauche = this.gauche.toAssembly();
        String droite = this.droite.toAssembly();
        if(this.gauche instanceof Bool){
            gauche += "BoToNb\n";
        }else if(this.gauche instanceof Undefined){
            gauche += "Drop\nCsteNb NaN\n";
        }else{
            gauche += "TypeOf\nCase 3\nBoToNb\nNoop\nNoop\nJump 12\nNoop\nNoop\nError\nNoop\nNoop\nDrop\nCsteNb NaN\nJump 4\nError\nNoop\nNoop\nError\n";
        }
        if(this.droite instanceof Bool){
            droite += "BoToNb\n";
        }else if(this.gauche instanceof Undefined){
            droite += "Drop\nCsteNb NaN\n";
        }else{
            droite += "TypeOf\nCase 3\nBoToNb\nNoop\nNoop\nJump 12\nNoop\nNoop\nError\nNoop\nNoop\nDrop\nCsteNb NaN\nJump 4\nError\nNoop\nNoop\nError\n";
        }
        return gauche + droite + "Equals\n";
    }

    @Override
    public Object evaluate() {
        Object leftValue = gauche.evaluate();
        Object rightValue = droite.evaluate();

        if (leftValue == null || rightValue == null) {
            return leftValue == rightValue;
        }

        if (!leftValue.getClass().equals(rightValue.getClass())) {
            throw new RuntimeException("Cannot compare values of different types: " 
                + leftValue.getClass().getName() + " and " + rightValue.getClass().getName());
        }

        return leftValue.equals(rightValue);
    }
}
