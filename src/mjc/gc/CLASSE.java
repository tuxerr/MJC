package mjc.gc;

public class CLASSE extends DTYPE {
    private LMETHODES methodes;
    private LATTRIBUTS attributs;
    private String nom;

    // une CLASSE peut aussi représenter une interface, dans ce cas le boolean est à false
    private boolean isAClass;

    public CLASSE(String nom,boolean isClass) {
        if(isClass) {
            super("class",0);
        } else {
            super("interface",0);
        }
        this.nom=nom;
        this.isClass=isClass;
    }

    public boolean isClass() {
        return isAClass;
    }

    public boolean implementsCorrectly(CLASSE cl2) {
        
    }

    public String getTaille() {
        return attributs.getTaille();
    }

    public String toString() {
        return super.toString() + " de nom : " + nom + "d'attributs " + attributs + " et de méthodes " + methodes;
    }

    public void addMethode(METHODE meth) {
        methodes.add(meth);
    }    

    public LMETHODES getMethodes() {
        return methodes;
    }
    
    public void addAttribut(ATTRIBUT attr) {
        attributs.add(attr);
    }

    public LATTRIBUTS getAttributs() {
        return attributs;
    }
}