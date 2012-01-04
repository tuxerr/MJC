package mjc.gc;

public class VAR {
    // le deplacement
    private int dep;

    // le registre de base de la variable
    private String reg;

    private DTYPE type;

    public int getDep() {
        return dep;
    }

    public String getReg() {
        return reg;
    }

    public DTYPE getType() {
        return type;
    }

    public VAR(DTYPE t, int d, String r) {
        type = t;
        dep = d;
        reg = r;
    }

    // affichage
    public String toString() {
        return "; VAR : " + "type=" + type + " dep = " + dep + " reg = " + reg;
    }

}
