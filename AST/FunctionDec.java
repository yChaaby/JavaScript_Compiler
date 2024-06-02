package AST;

import java.util.ArrayList;
import java.util.List;

public class FunctionDec extends Commande{
    private String functionName;
    private ArgsDeclaration lesArgs;
    private Commande code;
    public FunctionDec(String name, ArgsDeclaration args, Commande code){
        this.functionName = name;
        this.lesArgs = args;
        this.code = code;
    }
    public String toAssembly(){
        return "DecVar "+this.functionName+"\nNewClo "+(Tools.countNewLines(this.lesArgs.argAssembly())+1)+"\n"+this.lesArgs.argAssembly()+"Jump "+Tools.countNewLines(this.code.toAssembly())+"\n"+this.code.toAssembly()+"SetVar "+this.functionName+"\n";
    }

}