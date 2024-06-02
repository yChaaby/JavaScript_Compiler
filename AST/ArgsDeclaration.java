package AST;
import java.util.ArrayList;
import java.util.List;
public class ArgsDeclaration{
    private List<String> args;
    public ArgsDeclaration(List<String> args){
        this.args = args;
    }
    public String argAssembly(){
        String assemb = "";
        for(String arg: this.args){
            assemb += "DclArg "+arg+"\n";
        }
        return assemb;
    }
}