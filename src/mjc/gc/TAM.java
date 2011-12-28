package mjc.gc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TAM {
  private String nom;

  public TAM(String fname) {
    if (fname.endsWith(".mjava")) {
      nom = fname.substring(0, fname.length() - 5);
    } else {
      nom = fname;
    }
  }

  // genere le code pour une declaration (avec initialisation)
  public String genDecl(String n, INFOVAR i, String t) {
    int taille = i.getType().getTaille();
    return "   ; decl de var " + n + " en " + i.getDep() + "/" + i.getReg() + " taille = "
        + taille + "\n" + t;
  }

  // genere le code pour une declaration d'attributs
  public String genDeclAtt(String n, INFOVAR i) {
    int taille = i.getType().getTaille();
    return "   ; decl d'att " + n + " en " + i.getDep() + "/" + i.getReg() + " taille = "
        + taille + "\n";
  }

  // genere le code pour une declaration de methode
  public String genDeclAtt(String n, INFOVAR i) {
    int taille = i.getType().getTaille();
    return "   ; decl de met " + n + "\n";
  }

  // compteur pour le generateur d'etiquettes
  private static int cpt = 0;

  // genere une etiquette differente des autres
  public String genEtiq() {
    return "X" + cpt++;
  }

  // genere le code pour l'arret de la machine
  public String genFin() {
    return "\tHALT\n";
  }

  public String genCst(String v) {
    return "\tLOADL " + v + "\n";
  }

  public String genFree(int i) {
    return "\tPOP(0)" + i + "\n";
  }

  public String genMem(int dep, int taille) {
    return "\tLOAD(" + taille + ") " + dep + "[SB]\n";
  }

  public String genReadMem(int taille) {
    return "\tLOADI(" + taille + ")\n";
  }

  public String genWriteMem(int taille) {
    return "\tSTOREI(" + taille + ")\n";
  }

  public String genIf(String code, String code2, String code3) {
    String sinon = genEtiq();
    String fin = genEtiq();
    return "\t; if\n" + code + "\n" + "\tJUMPIF(0) " + sinon + "\n" + code2
        + "\n" + "\tJUMP " + fin + "\n" + sinon + "\n" + code3 + "\n"
        + fin + "\n" + "\t; fin if\n";
  }

  public String genMalloc(int taille) {
    return "\tLOADL " + taille + "\n" + "\tSUBR Malloc\n";
  }

  public String genAdr(int dep) {
    return "\tLOADA " + dep + "[SB]\n";
  }

  public String genAdrField(int dep) {
    return "\tLOADL " + dep + "\n\tSUBR Iadd\n";
  }

  public String genComment(String c){
    return "; " + c + "\n";
  }

  //génération des opérations basiques sur les expressions
  public genOpPlus() {
    return "\tSUBR IAdd\n";
  }

  public genOpMoins() {
    return "\tSUBR ISub\n";
  }

  public genOpMul() {
    return "\tSUBR IMul\n";
  }

  public genOpDiv() {
    return "\tSUBR IDiv\n";
  }

  public genOpMod() {
    return "\tSUBR IMod\n";
  }

  public genOpEq() {
    return "\tSUBR IEq\n";
  }

  public genOpNeq() {
    return "\tSUBR INeq\n";
  }

  public genOpLss() {
    return "\tSUBR ILss\n";
  }

  public genOpLeq() {
    return "\tSUBR ILeq\n";
  }

  public genOpGtr() {
    return "\tSUBR IGtr\n";
  }

  public genOpGeq() {
    return "\tSUBR IGeq\n";
  }

  public genOpNeg() {
    return "\tSUBR BNeg\n";
  }

  public genOpOr() {
    return "\tSUBR BOr\n";
  }

  public genOpAnd() {
    return "\tSUBR BAnd\n";
  }

}
