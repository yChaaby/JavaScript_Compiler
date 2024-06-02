package AST;

public class Plus extends ExpressionA_Binaire {

public Plus(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
public String symbole(){
    return "plus";
};
public String toAssembly() {
    String gauche = this.gauche.toAssembly();
    String droite = this.droite.toAssembly();
    if(this.gauche instanceof Bool){
        gauche += "BoToNb\n";
    }else if(this.gauche instanceof Undefined){
        gauche += "Drop\nCsteNb NaN\n";
    }else {
        gauche += "TypeOf\nCase 3\nBoToNb\nNoop\nNoop\nJump 12\nNoop\nNoop\nError\nNoop\nNoop\nDrop\nCsteNb NaN\nJump 4\nError\nNoop\nNoop\nError\n";
    }
    if(this.droite instanceof Bool){
        droite += "BoToNb\n";
    }else if(this.gauche instanceof Undefined){
        droite += "Drop\nCsteNb NaN\n";
    }else {
        droite += "TypeOf\nCase 3\nBoToNb\nNoop\nNoop\nJump 12\nNoop\nNoop\nError\nNoop\nNoop\nDrop\nCsteNb NaN\nJump 4\nError\nNoop\nNoop\nError\n";
    }


    return gauche + droite + "AddiNb\n";
}


@Override
    public Object evaluate() {
        return (Integer) gauche.evaluate() + (Integer) droite.evaluate();
    }
}
