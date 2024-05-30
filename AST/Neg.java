package AST;

public class Neg extends ExpressionA {

public ExpressionA arg;

public Neg(ExpressionA arg) {
  this.arg = arg;
}

public String toString() {
  return String.format("neg(%1$s)", arg.toString());
}
  public String toAssembly() {
    return  (arg.toAssembly())+"NegaNb\n";
  }
  @Override
    public Object evaluate() {
        Object value = arg.evaluate();

        if (value instanceof Integer) {
            return -(Integer) value;
        } else if (value instanceof Float) {
            return -(Float) value;
        } else {
            throw new RuntimeException("Unsupported type for Neg operation: " + value.getClass().getName());
        }
    }
}	
