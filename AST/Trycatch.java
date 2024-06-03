package AST;

public class Trycatch extends Commande{

    private Programme t;
    private String id;
    private Programme c;

    public Trycatch(Programme t, String id, Programme c) {
        this.t = t;
        this.id = id;
        this.c = c;
    }
    public String toAssembly(){
        return "Catch "+Tools.countNewLines(t.toAssembly())+"\n"+t.toAssembly()+"Drop\nJump "+Tools.countNewLines(c.toAssembly())+"\nSetVar "+id+"\n"+c.toAssembly();
    }
}