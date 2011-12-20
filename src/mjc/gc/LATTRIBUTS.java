package bloc.lib;

import java.util.ArrayList;

public class LATTRIBUTS extends ArrayList<ATTRIBUT> {

	private static final long serialVersionUID = 1L;

	public ATTRIBUT chercher(String nom) {
		for (ATTRIBUT c : this) {
			if (c.getNom().equals(nom))
				return c;
		}
		return null;
	}

	public int getTaille() {
		int t = 0;
		for (ATTRIBUT a : this) {
			t += a.getType().taille;
		}
		return t;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (ATTRIBUT c : this) {
			sb.append(c + ", ");
		}
		return sb.toString();
	}

	public boolean compareTo(LATTRIBUTS autre) {
		int lc = size();
		int lca = autre.size();
		if (lc != lca)
			return false;
		for (int i = 0; i < lc; i++) {
			ATTRIBUT c = get(i);
			ATTRIBUT ca = autre.get(i);
			if (!c.getNom().equals(ca.getNom())
					|| !c.getType().compareTo(ca.getType()))
				return false;
		}
		return true;
	}
}
