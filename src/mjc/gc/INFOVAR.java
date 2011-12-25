package mjc.gc;

public class INFOVAR extends INFO {
	// le deplacement
	private int dep;

	// le registre de base de la variable
	private String reg;

	public int getDep() {
		return dep;
	}

	public String getReg() {
		return reg;
	}

	public INFOVAR(DTYPE t, int d, String r) {
		super(t);
		dep = d;
		reg = r;
	}

	// affichage
	public String toString() {
		return "; VAR : " + "type=" + type + " dep = " + dep + " reg = " + reg;
	}

}
