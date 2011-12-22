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

    public boolean containsAttribut(ATTRIBUT attrib) {
        for (ATTRIBUT a : this) {
            if(a.getNom().equals(attrib.getNom())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (ATTRIBUT c : this) {
            sb.append(c + ", ");
        }
        return sb.toString();
    }

}
