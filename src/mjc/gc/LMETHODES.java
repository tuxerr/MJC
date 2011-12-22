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

    // fonction utilisé pour voir l'égalité stricte entre 2 méthodes (utilisé dans implémentation d'une interface)
    public boolean containsMethode(METHODE met) {
        for(METHODE m : this) {
            if(m.equals(met)) {
                return true;
            }
        }
        return false;
    }

    // fonction utilisée pour récupérer le numéro d'une fonction par rapport à la première (utilisée dans la liaison tardive pour avoir l'indice du tableau)
    public int getMethodeNumber(METHODE met) {
        int i=0;
        for(METHODE m : this) {
            if(m.getNom().equals(met.getNom()) & m.getArgs().size() == met.getArgs().size()) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // fonction utilisée pour savoir si une fonction peut être ajoutée à une classe (utilisée dans la définition d'une classe)
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
