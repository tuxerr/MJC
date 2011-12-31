package mjc.gc;

public class INFOCLASSE extends INFO {

	// le deplacement
    public INFOCLASSE(CLASSE t) {
        super(t);
    }

    public CLASSE getType() {
        DTYPE t = super.getType();
        if(t instanceof CLASSE) {
            return (CLASSE)t;
        } else {
            return null;
        }
    }

    public String toString() {
        return "; CLASSE : " + "type=" + type;
    }

}
