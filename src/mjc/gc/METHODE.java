package mjc.gc;

public class METHODE {
    private ARGLIST args;
    private DTYPE returnType;
    private String label;

    public METHODE(DTYPE returnType,ARGLIST args) {
        this.returnType=returnType;
        this.args=args;
    }

    public DTYPE getReturnType() {
        return returnType;
    }

    public ARGLIST getArgs() {
        return args;
    }
  
    public String getLabel() {
	return label;
    }

    public void setLabel(String lab) {
        label=lab;
    }

    public boolean equals(METHODE m) {
        return returnType.equals(m.getReturnType()) & 
            args.equals(m.getArgs());
    }

    public boolean isEquivalent(METHODE m) {
        return args.equals(m.getArgs());
    }

    public String toString() {
        return "Méthode : (" + returnType + ") " + "( " + args + " )";
    }

}

