package AST;

public class Moins extends ExpressionA_Binaire {

public Moins(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

public String symbole() {return "moins";};
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "SubiNb\n";
    }

@Override
    public Object evaluate() {
        Object leftValue = gauche.evaluate();
        Object rightValue = droite.evaluate();

        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            return (Integer) leftValue - (Integer) rightValue;
        } else if (leftValue instanceof Float && rightValue instanceof Float) {
            return (Float) leftValue - (Float) rightValue;
        } else if (leftValue instanceof Integer && rightValue instanceof Float) {
            return (Integer) leftValue - (Float) rightValue;
        } else if (leftValue instanceof Float && rightValue instanceof Integer) {
            return (Float) leftValue - (Integer) rightValue;
        } else {
            throw new RuntimeException("Unsupported types for Moins operation: " 
                + leftValue.getClass().getName() + " and " + rightValue.getClass().getName());
        }
    }
}
