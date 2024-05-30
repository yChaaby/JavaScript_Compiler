package AST;
import java.util.List;
import java.util.ArrayList;
public class Programme extends AST {
    public List<Commande> commandes;

    public Programme(List<Commande> commandes) {
        this.commandes = commandes;
        //System.out.println("prg cree");
    }
    public Programme(Programme a){
        this.commandes = a.commandes;
    }

    public String toAssembly() {
        String assembly = "";
        for (Commande commande : commandes) {
            assembly = assembly+commande.toAssembly();
            if(commande instanceof ExpressionA){
                assembly+="Drop"+"\n";
            }

        }
        return assembly;
    }
}
