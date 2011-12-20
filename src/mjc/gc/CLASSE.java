package mjc.gc;

public class CLASSE extends DTYPE {
    private LMETHODES methodes;
    private LATTRIBUTS attributs;
    private String nom;

    // une CLASSE peut aussi représenter une interface, dans ce cas le boolean est à false
    private boolean isAClass;
    private StringBuffer buf;

    public CLASSE(String nom,boolean isClass) {
        if(isClass) {
            super("class",0);
        } else {
            super("interface",0);
        }
        this.nom=nom;
        this.isAClass=isClass;
        
    }

    public boolean isClass() {
        return isAClass;
    }

    public boolean implementsCorrectly(CLASSE inter) {
        boolean implementCorrect=true;
        buf = new StringBuffer();

        if(inter.isClass()) {
            buf.append(inter);
            buf.append("is a class and not an interface");
            return false;
        }

        for ( METHODE m : methodes ) {
            if(!inter.methodeExists(m)) {
                buf.append("the " + m + "method is not implemented in the interface " + inter);
                implementCorrect=false;
            }
        }
        
        return implementCorrect;
    }

    public String implementGetError() {
        buf.toString();
    }

    public String getTaille() {
        return attributs.getTaille();
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
    
    public void addAttribut(ATTRIBUT attr) {
        attributs.add(attr);
    }

    public LATTRIBUTS getAttributs() {
        return attributs;
    }
}