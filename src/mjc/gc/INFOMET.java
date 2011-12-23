package mjc.gc;

public class INFOMET extends INFO {
    private ARGS args;

    public INFOMET(DTYPE returnType,ARGS args) {
        super(returnType);
        this.args=args;
    }

    public ARGS getArgs() {
        return args;
    }

    public String toString() {
        return "Méthode : (" + super.getType() + ") " + "( " + args + " )";
    }

}