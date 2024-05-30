package AST;

public class EmptyCommand extends Commande{
    public EmptyCommand(){}

    @Override
    public String toAssembly(){
        return "";
    }
}