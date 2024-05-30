package AST;

public class Num extends ExpressionA {
  public int num;
    
  public Num(int num) {
    this.num = num;
  }
  
  public String toString() {
    return Integer.toString(num);
  }
  public String toAssembly() {
    return "CsteNb " + num+"\n";
  }

  @Override
    public Object evaluate() {
        return num;
    }
}
