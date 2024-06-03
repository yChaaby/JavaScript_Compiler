package AST;

import java.util.List;
import java.util.ArrayList;


public class Programme extends AST {
    public List<Commande> commandes;
    public List<String> vars;

    public Programme(List<Commande> commandes) {
        this.commandes = commandes;
        this.vars = new ArrayList<>();
        //System.out.println("prg cree");
    }
    public Programme(Programme a){
        this.commandes = a.commandes;
    }

    public String toAssembly() {
        String assembly = "";
        for (Commande commande : commandes) {
            if(commande instanceof Let){
                assembly = commande.toAssembly()+assembly;
            }else{
                assembly = assembly+commande.toAssembly();
            }

            if(commande instanceof ExpressionA){
                assembly+="Drop"+"\n";
                //assembly+=commande.getClass().getName();
            }
        }
        return assembly;
    }
}
