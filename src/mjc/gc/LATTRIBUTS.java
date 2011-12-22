package mjc.gc;

import java.util.ArrayList;

public class LATTRIBUTS extends ArrayList<ATTRIBUT> {

    public int getTaille() {
        int t = 0;
        for (ATTRIBUT a : this) {
            t += a.getType().taille;
        }
        return t;
    }

    public ATTRIBUT returnAttribut(String nom) {
        for (ATTRIBUT a : this) {
            if(a.getNom().equals(nom)) {
                return a;
            }
        }
        return null;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (ATTRIBUT c : this) {
            sb.append(c + ", ");
        }
        return sb.toString();
    }

}
