package mjc.gc;

import java.util.ArrayList;

public class LMETHODES extends ArrayList<METHODE> {
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (METHODE c : this) {
            sb.append(c + ", ");
        }
        return sb.toString();
    }

    public boolean containsMethode(METHODE met) {
        for(METHODE m : this) {
            if(m.equals(met)) {
                return true;
            }
        }
        return false;
    }

    public boolean canAddMethod(METHODE met) {
        boolean canadd=true;
        for(METHODE m : this) {
            if(m.getNom().equals(met.getNom())) {
                if(m.getArgs().size() == met.getArgs().size()) {
                    // si les 2 méthodes ont le même nom et le même nombre d'arguments, on ne peut pas ajouter la méthode
                    canadd=false;
                }
            } 
        }
        return canadd;
    }
}
