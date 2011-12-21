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

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (ATTRIBUT c : this) {
            sb.append(c + ", ");
        }
        return sb.toString();
    }

}
