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

    public String getNom() {
        return nom;
    }

    public DTYPE getReturnType() {
        return DTYPE;
    }

    public ARGS getArgs() {
        return args;
    }

    public boolean equals(METHODE m) {
        return nom.equals(m.getNom()) & 
            returnType.equals(m.getReturnType()) & 
            args.equals(m.getArgs());
    }

    public String toString() {
        return "Méthode : (" + returnType + ") " + nom + "( " + args + " )";
    }

}