package AST;

public class Div extends ExpressionA_Binaire {

    public Div(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "div";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "DivNb\n";
    }

    @Override
    public Object evaluate() {
        Object leftValue = gauche.evaluate();
        Object rightValue = droite.evaluate();

        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue / (Integer) rightValue;
        } else if (leftValue instanceof Float && rightValue instanceof Float) {
            return (Float) leftValue / (Float) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Float) {
            return (Integer) leftValue / (Float) rightValue;
        } else if (leftValue instanceof Float && rightValue instanceof Integer) {
            return (Float) leftValue / (Integer) rightValue;
        } else {
            throw new RuntimeException("Unsupported types for Div operation: " 
                + leftValue.getClass().getName() + " and " + rightValue.getClass().getName());
        }
    }
}
