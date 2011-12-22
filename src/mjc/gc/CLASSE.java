package mjc.gc;

public class CLASSE extends DTYPE {
    private LMETHODES methodes;
    private LATTRIBUTS attributs;
    private String nom;

    private StringBuffer buf;

    public CLASSE(String nom) {
        super("class",0);
        this.nom=nom;
        methodes = new LMETHODES();
        attributs = new LATTRIBUTS();
    }

    public boolean implementsCorrectly(INTERFACE inter) {
        boolean implementCorrect=true;
        buf = new StringBuffer();

        for ( METHODE m : methodes ) {
            if(!inter.getMethodes().methodeExists(m)) {
                buf.append("the " + m + "method is not implemented in the interface " + inter);
                implementCorrect=false;
            }
        }
        
        return implementCorrect;
    }

    public String implementGetError() {
        return buf.toString();
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
        super.setTaille(super.getTaille()+attr.getType().getTaille());
    }

    public LATTRIBUTS getAttributs() {
        return attributs;
    }
}