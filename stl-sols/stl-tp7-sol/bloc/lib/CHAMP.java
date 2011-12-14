package bloc.lib;

public class CHAMP {
	private String nom;
	private int dep;
	private DTYPE type;

	public String getNom() {
		return nom;
	}

	public DTYPE getType() {
		return type;
	}

	public int getDep() {
		return dep;
	}

	public CHAMP(String nom, DTYPE type, int dep) {
		super();
		this.nom = nom;
		this.type = type;
		this.dep = dep;
	}

	public String toString() {
		return nom + ": " + type + " dep = " + dep;
	}

}
