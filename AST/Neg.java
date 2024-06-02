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
    String arg = this.arg.toAssembly();
      if(this.arg instanceof Bool){
          arg += "BoToNb\n";
      }else if(this.arg instanceof Undefined){
          arg += "Drop\nCsteNb NaN\n";
      }else{
          arg += "TypeOf\nCase 3\nBoToNb\nNoop\nNoop\nJump 12\nNoop\nNoop\nError\nNoop\nNoop\nDrop\nCsteNb NaN\nJump 4\nError\nNoop\nNoop\nError\n";
      }
    return  (arg)+"NegaNb\n";
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
