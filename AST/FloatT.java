//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package AST;

public class FloatT extends ExpressionA {
    public float arg;

    public FloatT(float var1) {
        this.arg = var1;
    }

    public String toString() {
        return Float.toString(this.arg);
    }

    public String toAssembly() {
        return "CsteNb " + this.arg + "\n";
    }

    @Override
    public Object evaluate() {
        return this.arg;
    }
}
