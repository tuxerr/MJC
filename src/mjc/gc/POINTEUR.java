package mjc.gc;

public class POINTEUR extends DTYPE {
    private CLASSE type;

    public POINTEUR(CLASSE t) {
        super("pointeur", 2);
        type = t;
    }

    public CLASSE getPointedType() {
        return type;
    }

    public boolean equals(DTYPE autre) {
        if (autre instanceof POINTEUR) {
            if(type==null) {
                return ((POINTEUR)autre).getPointedType()==null;
            } else {
                return type.equals(((POINTEUR) autre).getPointedType());
            }
        } else {
            return false;
        }
    }

    public boolean canAccept(DTYPE autre) {
        if (autre instanceof POINTEUR) {
            CLASSE apt_type = ((POINTEUR)autre).getPointedType();
            if(type==null) {
                return true;
            } else {
                if(apt_type==null) {
                    return true;
                } else if(type.equals(apt_type)) {
                    return true;
                } else {
                    return apt_type.isASuperClass(type);
                }
            }
        } else {
            return autre.equals(new DTYPE("void", 0));
        }
    }

    public String toString(){
        return super.toString() + " sur type = " + type;
    }

}
