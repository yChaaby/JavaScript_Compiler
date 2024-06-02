package AST;

public class Undefined extends ExpressionA {


    public Undefined() {

    }


    public String toAssembly() {
        return "CsteUn \n";
    }

    @Override
    public Object evaluate() {
        return null;
    }
}
