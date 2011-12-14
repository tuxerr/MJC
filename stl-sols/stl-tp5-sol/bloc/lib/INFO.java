//--------------------------------------------------
// INFO la classe representant une variable
//--------------------------------------------------
package bloc.lib;

public class INFO {
	// le type
	private DTYPE type;

	public DTYPE getType() {
		return type;
	}

	// le deplacement
	private int dep;

	public int getDep() {
		return dep;
	}

	// constructeur
	public INFO(DTYPE t, int d) {
		type = t;
		dep = d;
	}

	//
	// affichage
	public String toString() {
		return "; VAR : " + "type=" + type + ", dep=" + dep;
	}
}
