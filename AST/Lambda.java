package AST;

import java.util.ArrayList;
import java.util.List;

public class Lambda extends ExpressionA{
    private ArgsDeclaration lesArgs;
    public ExpressionA code;
    public Lambda(ArgsDeclaration args, ExpressionA code){
        this.lesArgs = args;
        this.code = code;
    }
    public String toAssembly(){
        return "\nNewClo "+(Tools.countNewLines(this.lesArgs.argAssembly())+1)+"\n"+this.lesArgs.argAssembly()+"Jump "+Tools.countNewLines(this.code.toAssembly())+"\n"+this.code.toAssembly();
    }
    public Object evaluate() {
        return null;
    }

}