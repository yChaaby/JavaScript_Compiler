package AST;

public class Not extends ExpressionA {

    public ExpressionA arg;

    public Not(ExpressionA arg) {
        this.arg = arg;
    }

    public String toString() {
        return String.format("Not(%1$s)", arg.toString());
    }
    public String toAssembly() {
        String arg = this.arg.toAssembly();
        if(this.arg instanceof Num || this.arg instanceof FloatT){
            arg += "NbToBo\n";
        }else if(this.arg instanceof Undefined){
            arg += "Drop\nCsteBo false\n";
        }else{
            arg += "TypeOf\nCase 3\nJump 15\nNoop\nNoop\nNbToBo\nJump 11\nNoop\nError\nNoop\nNoop\nDrop\nCsteBo false\nJump 4\nError\nNoop\nNoop\nError\n";
        }
        return  (arg)+"Not\n";
    }

    @Override
    public Object evaluate() {
        Object value = arg.evaluate();
        if (value instanceof Boolean) {
            return !(Boolean) value;
        } else {
            throw new RuntimeException("Invalid type for Not operation: " + value.getClass().getName());
        }
    }
}
