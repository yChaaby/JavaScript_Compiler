package AST;

public class Bool extends ExpressionA {
    public boolean num;

    public Bool(boolean num) {
        this.num = num;
    }

    public String toString() {
        return Boolean.toString(num);
    }
    public String toAssembly() {
        return "CsteBo " + num+"\n";
    }

     @Override
    public Object evaluate() {
        return num;
    }
}
