package AST;

public class Et extends ExpressionA_Binaire {

    public Et(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "Et";
    }
    public String toAssembly() {
        return gauche.toAssembly() +"ConJmp "+Tools.countNewLines(droite.toAssembly())+"\n"+ droite.toAssembly() + "Jump 2\n"+"CstBo False\n";
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
