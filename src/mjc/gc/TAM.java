package mjc.gc;

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
  public String genDecl(String n, INFOVAR i, String t) {
    int taille = i.getType().getTaille();
    return "   ; decl de " + n + " en " + i.getDep() + "/SB" + " taille = "
        + taille + "\n" + t;
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

  public genOpPlus(){
    return "\tSUBR IAdd";
  }

  public genOpMoins(){
    return "\tSUBR ISub";
  }

  public genOpMul(){
    return "\tSUBR IMul";
  }

  public genOpDiv(){
    return "\tSUBR IDiv";
  }

  public genOpMod(){
    return "\tSUBR IMod";
  }

  public genOpEq(){
    return "\tSUBR IEq";
  }

  public genOpNeq(){
    return "\tSUBR INeq";
  }

  public genOpLss(){
    return "\tSUBR ILss";
  }

  public genOpLeq(){
    return "\tSUBR ILeq";
  }

  public genOpGtr(){
    return "\tSUBR IGtr";
  }

  public genOpGeq(){
    return "\tSUBR IGeq";
  }

  public genOpNeg(){
    return "\tSUBR BNeg";
  }

  public genOpOr(){
    return "\tSUBR BOr";
  }

  public genOpAnd(){
    return "\tSUBR BAnd";
  }

}
