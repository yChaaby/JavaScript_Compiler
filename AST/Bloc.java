package AST;
public class Bloc extends Commande {
    public Programme prg;
    public Bloc(Programme prg) {
        this.prg = prg;
    }
    public String toAssembly(){
        return this.prg.toAssembly();
    }
    public String toString() {
        return String.format("Programme(%1$s)", prg.toString());
    }
}