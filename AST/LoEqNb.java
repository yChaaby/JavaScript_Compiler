package AST;

public class LoEqNb extends ExpressionA_Binaire {

    public LoEqNb(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "LoEqNb";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "LoEqNb\n";
    }
    @Override
    public Object evaluate() {
        Object leftValue = gauche.evaluate();
        Object rightValue = droite.evaluate();

        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue <= (Integer) rightValue;
        } else if (leftValue instanceof Float && rightValue instanceof Float) {
            return (Float) leftValue <= (Float) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Float) {
            return (Integer) leftValue <= (Float) rightValue;
        } else if (leftValue instanceof Float && rightValue instanceof Integer) {
            return (Float) leftValue <= (Integer) rightValue;
        } else {
            throw new RuntimeException("Unsupported types for LoEqNb operation: " 
                + leftValue.getClass().getName() + " and " + rightValue.getClass().getName());
        }
    }
}
