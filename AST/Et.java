package AST;

public class Et extends ExpressionA_Binaire {

    public Et(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "Et";
    }

    public String toAssembly() {
        String gauche = this.gauche.toAssembly();
        String droite = this.droite.toAssembly();
        if(this.gauche instanceof Num || this.gauche instanceof FloatT){
            gauche += "NbToBo\n";
        }else if(this.gauche instanceof Undefined){
            gauche += "Drop\nCsteBo false\n";
        }else{
            gauche += "TypeOf\nCase 3\nJump 15\nNoop\nNoop\nNbToBo\nJump 11\nNoop\nError\nNoop\nNoop\nDrop\nCsteBo false\nJump 4\nError\nNoop\nNoop\nError\n";
        }

        if(this.droite instanceof Num || this.droite instanceof FloatT){
            droite += "NbToBo\n";
        }else if(this.gauche instanceof Undefined){
            droite += "Drop\nCsteBo false\n";
        }else{
            droite += "TypeOf\nCase 3\nJump 15\nNoop\nNoop\nNbToBo\nJump 11\nNoop\nError\nNoop\nNoop\nDrop\nCsteBo false\nJump 4\nError\nNoop\nNoop\nError\n";
        }

        return gauche +"ConJmp "+(Tools.countNewLines(droite)+1)+"\n"+ droite + "Jump 1\n"+"CstBo false\n";
    }

    @Override
    public Object evaluate() {
        Object leftValue = gauche.evaluate();
        Object rightValue = droite.evaluate();

        if (leftValue instanceof Boolean && rightValue instanceof Boolean) {
            return (Boolean) leftValue && (Boolean) rightValue;
        } else {
            throw new RuntimeException("Unsupported types for Et operation: " 
                + leftValue.getClass().getName() + " and " + rightValue.getClass().getName());
        }
    }
}
