package AST;

import java.util.ArrayList;
import java.util.List;

public class FunctionCall extends ExpressionA{
    private String functionName;
    private FunctionArguments lesArgs;

    public FunctionCall(String functionName, FunctionArguments lesArgs){
        this.functionName = functionName;
        this.lesArgs = lesArgs;
    }
    public String toAssembly(){
        String Assembly = "GetVar "+functionName+"\n"+"StCall"+"\n";
        return Assembly+this.lesArgs.getArgumentsAssembly()+"Call\n";
    }
    public Object evaluate(){
        return null;
    };

}