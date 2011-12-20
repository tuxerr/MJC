package bloc.lib;

import java.util.ArrayList;

public class LMETHODES extends ArrayList<METHODE> {
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (METHODE c : this) {
            sb.append(c + ", ");
        }
        return sb.toString();
    }

    public boolean methodeExists(METHODE met) {
        for(METHODE m : this) {
            if(m.equals(met)) {
                return true;
            }
        }
        return false;
    }
}
