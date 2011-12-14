package bloc.lib;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TAM {
	private String nom;

	public TAM(String fname) {
		if (fname.endsWith(".bloc")) {
			nom = fname.substring(0, fname.length() - 5);
		} else {
			nom = fname;
		}
	}

	// genere le code pour une declaration (avec initialisation)
	// A COMPLETER
	public String genDecl(String n, INFOVAR i, String t) {
		int taille = i.getType().getTaille();
		return "\t; decl de " + n + " en " + i.getDep() + "/SB" + " taille = "
				+ taille + " : a faire\n";
	}

	// compteur pour le generateur d'etiquettes
	private static int cpt = 0;

	// genere une etiquette differente des autres
	public String genEtiq() {
		return "X" + cpt++;
	}

	public void genAsm(String code) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(nom + ".tam"));
			pw.println(";;; code TAM engendre pour " + nom + "\n");
			pw.print(code + "\tHALT\n");
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// A COMPLETER
	public String genCouple(String g, String d) {
		return g + d;
	}

	// A COMPLETER
	public String genCst(String v) {
		return "\t; chargement constante : a faire\n";
	}

	// A COMPLETER
	public String genAff(int emp, int taille, String code) {
		return "\t; affectation: a faire\n";
	}

	// A COMPLETER
	public String genFree(int i) {
		return "\t; liberation des locales : a faire\n";
	}

	// A COMPLETER
	public String genMem(int dep, int taille) {
		// TODO Auto-generated method stub
		return "\tChargement zone : a faire\n";
	}

	// A COMPLETER
	public String genTq(String code, String code2) {
		return "\t; while : a faire\n";
	}

	// A COMPLETER
	public String genIf(String code, String code2, String code3) {
		return "\t; if : a faire\n";
	}

	// A COMPLETER
	public String genPrint(String att_code) {
		return "\t; printf : a faire\n";
	}

}
