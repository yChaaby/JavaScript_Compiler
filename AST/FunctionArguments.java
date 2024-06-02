package AST;
import java.util.ArrayList;
import java.util.List;
public class FunctionArguments{

    private List<ExpressionA> arguments;


    public FunctionArguments( List<ExpressionA> arguments) {
        this.arguments = arguments;
    }

    public String getArgumentsAssembly() {
        String Assembly="";
        for(ExpressionA expr: this.arguments){
            Assembly+= (expr.toAssembly()+"SetArg\n");
        }
        return Assembly;
    }
}




