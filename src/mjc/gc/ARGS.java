package mjc.gc;

import java.util.ArrayList;

public class ARGS extends ArrayList<DTYPE> {

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (DTYPE c : this) {
            sb.append(c + ", ");
        }
        return sb.toString();
    }
    
    public int getTaille() {
        int taille=0;
        for(DTYPE type : this) {
            taille+=type.getTaille();
        }
        return taille;
    }

    public boolean equals(ARGS a) {
        return this.equals(a);
    }

}