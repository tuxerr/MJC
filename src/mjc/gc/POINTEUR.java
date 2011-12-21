package mjc.gc;

public class POINTEUR extends DTYPE {
    private DTYPE type;

    public POINTEUR(DTYPE t) {
        super("pointeur", 1);
        type = t;
    }

    public DTYPE getType() {
        return type;
    }
    public boolean compareTo(DTYPE autre) {
        if (autre instanceof POINTEUR)
            return type.equals(((POINTEUR) autre).getType());
        return false;
    }


    public String toString(){
        return super.toString() + " sur type = " + type;
    }

}
