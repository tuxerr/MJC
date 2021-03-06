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
    private ArrayList<CLASSE> acceptedChildClasses;
    private StringBuffer buf;

    public CLASSE(boolean isclass,TDS globaltds,String name) {
        super(name,0);
        classeMere = null;
        this.tds = new TDS(globaltds);
        this.isclass=isclass;
	acceptedSuperClasses=new ArrayList<CLASSE>();
    }

    public CLASSE(CLASSE cl,String name) {
        super(name,0);        
        this.tds = new TDS(cl.getTDS());
        classeMere = cl;
        this.isclass = true;
	acceptedSuperClasses=new ArrayList<CLASSE>();
    }

    public void inherits(CLASSE cl) {
        classeMere=cl;
        tds.setParente(cl.getTDS());
    }

    public boolean equals(DTYPE t) {
        return (t==this);
    }

    public int getParentSize() {
        if(classeMere==null) {
            return 0;
        } else {
            return classeMere.getVarTaille();
        }
    }

    public int getVarTaille() {
        if(classeMere!=null) {
            return classeMere.getVarTaille()+tds.getVariableTaille();
        } else {
            return tds.getVariableTaille();
        }
    }

    public int getParentVarTaille() {
        if(classeMere!=null) {
            return classeMere.getTDS().getVariableTaille()+classeMere.getParentVarTaille();
        } else {
            return 0;
        }
    }

    public int getTaille() {
        int taille=tds.getAllAccessibleMethods().size()+getVarTaille();
        return taille;
    }

    public int getTailleMeth() {
	return tds.getAllAccessibleMethods().size();
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
        ArrayList<VTABLEENTRY> interfun = intertds.getAllAccessibleMethods();

        for (VTABLEENTRY e : interfun) {
            // si l'entrée courante dans la TDS interface est bien une méthode
            ARGLIST eargs = e.getMethod().getArgs();
            DTYPE etype = e.getMethod().getReturnType();

            METHODE ret = this.tds.chercherGlobalementMethod(e.getName(),eargs);
                
            // si, dans la classe, une entrée à le même nom et est une méthode aussi
            if(ret != null) {
          
                // et si cette méthode à les mêmes arguments et le même type de retour
                if(ret.getReturnType().equals(etype))  {
                    // la méthode de l'interface est implémentée dans la classe

                } else {
                    buf.append("La méthode " + e.getName() + " n'est pas implémentée dans la classe");
                    implementCorrect=false;
                }

            } else {
                buf.append("La méthode " + e.getName() + " n'est pas implémentée dans la classe");
                implementCorrect=false;
            }
                
        }
        
        return implementCorrect;
    }

    public ArrayList<String> createVtable(CLASSE realclass) {
        ArrayList<String> retList = new ArrayList<String>();
        ArrayList<VTABLEENTRY> metList = tds.getAllAccessibleMethods();

        for(VTABLEENTRY entry : metList) {
            METHODE realMet = realclass.getTDS().chercherGlobalementMethod(entry.getName(),entry.getMethod().getArgs());
            retList.add(realMet.getLabel());
        }

        return retList;
    }

    public ArrayList<Integer> createIVtable(CLASSE realclass) {
        ArrayList<Integer> retList = new ArrayList<Integer>();
        ArrayList<VTABLEENTRY> metList = tds.getAllAccessibleMethods();

        for(VTABLEENTRY entry : metList) {
            Integer realMetNumber = realclass.getMethodNumber(entry.getName(),entry.getMethod().getArgs());
            retList.add(realMetNumber);
        }

        return retList;
    }

    public int getMethodNumber(String name, ARGLIST args) {
        int number=0;
        ArrayList<VTABLEENTRY> metList = tds.getAllAccessibleMethods();

        for(VTABLEENTRY e : metList) {
            if(name.equals(e.getName()) && e.getMethod().getArgs().equals(args)) {
                return number;
            } else {
                number++;
            }
        }

        return -1;
    }

    public String implementGetError() {
        return buf.toString();
    }

    public TDS getTDS() {
        return tds;
    }

    public void setTDS(TDS tds) {
        this.tds = tds;
    }

}
