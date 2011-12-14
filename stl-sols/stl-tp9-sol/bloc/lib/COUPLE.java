package bloc.lib;

public class COUPLE extends DTYPE {
	private DTYPE gauche;

	public DTYPE getGauche() {
		return gauche;
	}

	private DTYPE droite;

	public DTYPE getDroite() {
		return droite;
	}

	public COUPLE(DTYPE g, DTYPE d) {
		super("couple", g.getTaille() + d.getTaille());
		gauche = g;
		droite = d;
	}

	public boolean compareTo(DTYPE autre) {
		if (autre instanceof COUPLE)
			return gauche.compareTo(((COUPLE) autre).gauche)
					&& droite.compareTo(((COUPLE) autre).droite);
		return false;
	}

	public String toString() {
		return nom + "(" + taille + ")" + "<" + gauche + ", " + droite + ">";
	}
}
