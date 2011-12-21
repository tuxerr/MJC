package mjc.gc;

public class ATTRIBUT {
    private String nom;
    private int dep;
    private DTYPE type;

    public String getNom() {
        return nom;
    }

    public DTYPE getType() {
        return type;
    }

    public int getDep() {
        return dep;
    }

    public ATTRIBUT(String nom, DTYPE type, int dep) {
        super();
        this.nom = nom;
        this.type = type;
        this.dep = dep;
    }

    public boolean equals(ATTRIBUT m) {
        return nom.equals(m.getNom()) & 
            type.equals(m.getType());
    }

    public String toString() {
        return nom + ": " + type + " dep = " + dep;
    }

}
