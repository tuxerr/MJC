package bloc.lib;

public class DTYPE {
	// inutilisable avec EGG
	// final private DTYPE entier = new DTYPE("entier",4);
	// public DTYPE getTypeEntier(){return entier;}
	// final private DTYPE booleen = new DTYPE("booleen",1);
	// public DTYPE getTypeBooleen(){return booleen;}
	protected int taille;

	public int getTaille() {
		return taille;
	}

	protected String nom;

	public String getNom() {
		return nom;
	}

	public DTYPE(String n, int t) {
		nom = n;
		taille = t;
	}

	public boolean compareTo(DTYPE autre) {
		return nom.equals(autre.nom);
	}

	public String toString() {
		return nom + "(" + taille + ")";
	}
}
