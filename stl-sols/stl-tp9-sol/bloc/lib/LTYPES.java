package bloc.lib;

import java.util.ArrayList;

public class LTYPES extends ArrayList<DTYPE> {

	private static final long serialVersionUID = 1L;

	public int getTaille() {
		int t = 0;
		for (DTYPE c : this) {
			t += c.taille;
		}
		return t;
	}

	public void inserer(DTYPE c) {
		add(c);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (DTYPE c : this) {
			sb.append(c + ", ");
		}
		return sb.toString();
	}

	public boolean compareTo(LTYPES autre) {
		int lc = size();
		int lca = autre.size();
		if (lc != lca)
			return false;
		for (int i = 0; i < lc; i++) {
			DTYPE c = get(i);
			DTYPE ca = autre.get(i);

			if (!c.compareTo(ca))
				return false;
		}
		return true;
	}
}
