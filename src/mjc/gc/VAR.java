package mjc.gc;

public class VAR {
    // le deplacement
    private int dep;

    // le registre de base de la variable
    private String reg;

    private DTYPE type;

    private boolean attr;

    private CLASSE varclass;

    public int getDep() {
        if(varclass==null) {
            return dep;
        } else {
            return dep+varclass.getParentVarTaille();
        }
    }

    public String getReg() {
        return reg;
    }

    public DTYPE getType() {
        return type;
    }

    public int getTaille() {
        return type.getTaille();
    }

    public void setClass(CLASSE c) {
        varclass=c;
    }

    public VAR(DTYPE t, int d, String r,boolean isAttr) {
        type = t;
        dep = d;
        reg = r;
        attr = isAttr;
        varclass = null;
    }

    public boolean isAttr() {
        return attr;
    }

    // affichage
    public String toString() {
        return "; VAR : " + "type=" + type + " dep = " + dep + " reg = " + reg;
    }

}
