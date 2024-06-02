package AST;

public class NotEql extends ExpressionA_Binaire {

    public NotEql(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "NotEqual";
    }
    public String toAssembly() {
        String gauche = this.gauche.toAssembly();
        String droite = this.droite.toAssembly();
        if(this.gauche instanceof Bool){
            gauche += "BoToNb\n";
        }else if(this.gauche instanceof Undefined){
            gauche += "Drop\nCsteNb NaN\n";
        }else if(this.gauche instanceof Ident){
            gauche += "TypeOf\nCase 3\nBoToNb\nNoop\nNoop\nJump 12\nNoop\nNoop\nError\nNoop\nNoop\nDrop\nCsteNb NaN\nJump 4\nError\nNoop\nNoop\nError\n";
        }
        if(this.droite instanceof Bool){
            droite += "BoToNb\n";
        }else if(this.gauche instanceof Undefined){
            droite += "Drop\nCsteNb NaN\n";
        }else if(this.gauche instanceof Ident){
            droite += "TypeOf\nCase 3\nBoToNb\nNoop\nNoop\nJump 12\nNoop\nNoop\nError\nNoop\nNoop\nDrop\nCsteNb NaN\nJump 4\nError\nNoop\nNoop\nError\n";
        }

        return gauche + droite + "NotEql\n";
    }

    @Override
    public Object evaluate() {
        Object leftValue = gauche.evaluate();
        Object rightValue = droite.evaluate();
        
        if (leftValue == null || rightValue == null) {
            return leftValue != rightValue;
        }

        if (!leftValue.getClass().equals(rightValue.getClass())) {
            throw new RuntimeException("Cannot compare values of different types: " + leftValue.getClass().getName() + " and " + rightValue.getClass().getName());
        }

        if (leftValue instanceof Integer) {
            return !leftValue.equals(rightValue);
        } else if (leftValue instanceof Boolean) {
            return !leftValue.equals(rightValue);
        } else if (leftValue instanceof Float) {
            return !leftValue.equals(rightValue);
        } else {
            throw new RuntimeException("Unsupported types for NotEqual operation: " + leftValue.getClass().getName());
        }
    }
}
