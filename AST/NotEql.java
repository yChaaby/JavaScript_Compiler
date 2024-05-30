package AST;

public class NotEql extends ExpressionA_Binaire {

    public NotEql(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "NotEqual";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "NotEql\n";
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
