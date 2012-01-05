package mjc.gc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CLASSE extends DTYPE {
    private CLASSE classeMere;
    private TDS tds;
    private boolean isclass;
    private ArrayList<CLASSE> acceptedSuperClasses;
    private StringBuffer buf;

    public CLASSE(boolean isclass,TDS globaltds,String name) {
        super(name,0);
        classeMere = null;
        this.tds = new TDS(globaltds);
        this.isclass=isclass;
    }

    public CLASSE(CLASSE cl,String name) {
        super(name,0);        
        this.tds = new TDS(cl.getTDS());
        classeMere = cl;
        this.isclass = true;
    }

    public boolean equals(DTYPE t) {
        return (t==this);
    }

    public boolean isAClass() {
        return isclass;
    }

    public void addSuperClass(CLASSE cl) {
        acceptedSuperClasses.add(cl);
    }

    public boolean isASuperClass(CLASSE cl) {
        if(cl==this) {
            return true;
        }

        for(CLASSE c : acceptedSuperClasses) {
            if (cl == c ) {
                return true;
            }
                        
        }

        if(classeMere==null) {
            return false;
        } else {
            return classeMere.isASuperClass(cl);
        }
    }

    public boolean implementsCorrectly(CLASSE inter) {
        buf = new StringBuffer();

        if(!isclass) {
            buf.append("Une interface ne peut implémenter une autre interface");
            return false;
        } else if(inter.isAClass()) {
            buf.append("Une classe ne peut en implémenter une autre");
            return false;
        }
        
        boolean implementCorrect=true;
        TDS intertds = inter.getTDS();
        Set<Map.Entry<String,LMETHODE>> esi = intertds.getMethodHM().entrySet();

        for (Map.Entry<String,LMETHODE> e : esi) {

            // si l'entrée courante dans la TDS interface est bien une méthode
            for(METHODE met : e.getValue()) {

                ARGLIST eargs = met.getArgs();
                DTYPE etype = met.getReturnType();

                METHODE ret = this.tds.chercherLocalementMethod(e.getKey(),eargs);
                
                // si, dans la classe, une entrée à le même nom et est une méthode aussi
                if(ret != null) {
          
                    // et si cette méthode à les mêmes arguments et le même type de retour
                    if(ret.getReturnType().equals(etype))  {
                        // la méthode de l'interface est implémentée dans la classe

                    } else {
                        buf.append("La méthode " + e.getKey() + "n'est pas implémentée dans la classe");
                        implementCorrect=false;
                    }

                } else {
                    buf.append("La méthode " + e.getKey() + "n'est pas implémentée dans la classe");
                    implementCorrect=false;
                }

            }
                
        }
        
        return implementCorrect;
    }

    public String implementGetError() {
        return buf.toString();
    }

    public TDS getTDS() {
        return tds;
    }

}
