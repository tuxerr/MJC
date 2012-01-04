package mjc.gc;

public class METHODE {
    private ARGLIST args;
    private DTYPE returnType;

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

