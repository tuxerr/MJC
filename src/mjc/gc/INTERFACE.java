package mjc.gc;

public class INTERFACE extends DTYPE {
    private LMETHODES methodes;
    private String nom;

    public INTERFACE(String nom) {
        super("interface",0);
        this.nom=nom;
    }

    public String toString() {
        return super.toString() + nom;
    }

    public void addMethode(METHODE meth) {
        methodes.add(meth);
    }    

    public LMETHODES getMethodes() {
        return methodes;
    }
}