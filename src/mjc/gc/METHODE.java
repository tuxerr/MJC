package mjc.gc;

public class METHODE {
    private String nom;
    private ARGS args;
    private DTYPE returnType;

    public METHODE(DTYPE returnType,String nom,ARGS args) {
        this.returnType=returnType;
        this.nom=nom;
        this.args=args;
    }

    public String toString() {
        return "Méthode : (" + returnType + ") " + nom + "( " + args + " )";
    }

}