package AST;

public class Modulo extends ExpressionA_Binaire {

    public Modulo(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

    public String symbole() {return "Modulo";};
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
        return gauche + droite + "ModuNb\n";
    }

    @Override
    public Object evaluate() {
        Object leftValue = gauche.evaluate();
        Object rightValue = droite.evaluate();

        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue % (Integer) rightValue;
        } else if (leftValue instanceof Float && rightValue instanceof Float) {
            return (Float) leftValue % (Float) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Float) {
            return (Integer) leftValue % (Float) rightValue;
        } else if (leftValue instanceof Float && rightValue instanceof Integer) {
            return (Float) leftValue % (Integer) rightValue;
        } else {
            throw new RuntimeException("Unsupported types for Modulo operation: " 
                + leftValue.getClass().getName() + " and " + rightValue.getClass().getName());
        }
    }
}
