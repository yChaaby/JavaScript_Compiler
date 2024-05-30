package AST;

public class Egal extends ExpressionA_Binaire {

    public Egal(ExpressionA gauche, ExpressionA droite) {
        super(gauche, droite);
    }

    public String symbole() {
        return "Equals";
    }
    public String toAssembly() {
        return gauche.toAssembly() + droite.toAssembly() + "Equals\n";
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
