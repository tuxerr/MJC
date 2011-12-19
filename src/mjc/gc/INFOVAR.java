package bloc.lib;

public class INFOVAR extends INFO {
	// le deplacement
	private int dep;

	public int getDep() {
		return dep;
	}

	public INFOVAR(DTYPE t, int d) {
		super(t);
		dep = d;
	}

	// affichage
	public String toString() {
		return "; VAR : " + "type=" + type + " dep = " + dep;
	}

}
