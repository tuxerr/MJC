package mjc.gc;

public class INFOMET extends INFO {
    private ARGLIST args;

    public INFOMET(DTYPE returnType,ARGLIST args) {
        super(returnType);
        this.args=args;
    }

    public ARGLIST getArgs() {
        return args;
    }

    public String toString() {
        return "Méthode : (" + super.getType() + ") " + "( " + args + " )";
    }

}