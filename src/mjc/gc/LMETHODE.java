package mjc.gc;

import java.util.ArrayList;
/**
 * @composed 1 - ArrayList METHODE
 */

public class LMETHODE extends ArrayList<METHODE> {

    public LMETHODE() {
    }

    public boolean addMethod(METHODE met) {
        boolean canadd=true;
        for(METHODE m : this) {
            if(m.isEquivalent(met)) {
                canadd=false;
            }
        }
        if(canadd) {
            this.add(met);
            return true;
        } else {
            return false;
        }
    }

    public METHODE getMethod(ARGLIST args) {
        for(METHODE m : this) {
            if(m.getArgs().equals(args)) {
                return m;
            }
        }
        return null;
    }

    public String toString() {
        return "Méthode : (" + super.toString();
    }

}
