package mjc.gc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TAM extends ABSTRACTMACHINE {
/*  private String nom; */

/*  public TAM(String fname) {
    if (fname.endsWith(".mjava")) {
      nom = fname.substring(0, fname.length() - 5);
    } else {
      nom = fname;
    }
    } */
   
  // compteur pour le generateur d'etiquettes
  private static int cpt = 0;

   
    public TAM() {

    }
  // genere une etiquette differente des autres
  public String genEtiq() {
    return "X" + cpt++;
  }


  // genere le code pour une declaration (avec initialisation)  DONE
  public String genDecl(String n, VAR i, String t) {
    int taille = i.getType().getTaille();
    return "   ; decl de var " + n + " en " + i.getDep() + "/" + i.getReg() + " taille = "
        + taille + "\n"
	+ "\tLOADL " + t +" \n";
	
  }

  // genere le code pour une declaration d'attributs  DONE
  public String genDeclAtt(String n, VAR i) {
    int taille = i.getType().getTaille();
    return "   ; decl d'att " + n + " en " + i.getDep() + "/" + i.getReg() + " taille = "
        + taille + "\n";
  }

  // genere le code pour une declaration de methode   DONE
  public String genDeclMet(String n, METHODE i) {
    int taille = i.getReturnType().getTaille();
    int String label = i.setLabel(genEtiq());
   return "   ; decl de met " + n +" taille " + taille + "\n"
	  + label; 
  }

  //genere l'affectation (hors déclaration) : y = 2  DONE

  public String genAffect(String n, VAR i, String t){
    int taille = i.getType().getTaille();
   return "  ; affectation de var" + n + "en " i.getDep() + "/" + i.getReg() + "taille ="
        + taille + "\n"
	+ t +"\n"
        + "\tSTORE " + "("+ taille  +") "+ i.getDep()+"["+i.getReg()+"]";

  // generation d'adresse 
  public String genAdr(int dep, int reg) {
    return " ; decl d'adresse de dep " + dep + "et de registre " + reg;   
  }

  // generation Call
  public  String genCall(String s,METHODE m) {
    return "   ; call de fonction " + s + "de label " + m.getLabel()"\n"
	+ "\tJUMP "+ m.getLabel();	
  }
  // RETURN (EGG NOT DONE) String : nom de fonction,  Liste d'arg, Variable retour
  public String genReturn(String name,ARGLIST ltype,VAR ret) {
    return "   ; return de fonction " + expr"\n"
	+"\tRETURN "+"("+ltype.getTaille()+") "+ ret ;
  }
  
  // generation call variable value DONE
  public String genCallVar(String s, VAR i){
    return"   ; call cariable "+s+" taille : "+i.getTaille()+"\n"
	+"\tLOADL " + "("+i.getType().getTaille()+") "+i.getDep()+"["+igetReg()+"]"; 
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
  public String genOpAdd() {
    return "\tSUBR IAdd\n";
  }

  public String genOpSub() {
    return "\tSUBR ISub\n";
  }

  public String genOpMul() {
    return "\tSUBR IMul\n";
  }

  public String genOpDiv() {
    return "\tSUBR IDiv\n";
  }

  public String genOpMod() {
    return "\tSUBR IMod\n";
  }

  public String genOpEq() {
    return "\tSUBR IEq\n";
  }

  public String genOpNeq() {
    return "\tSUBR INeq\n";
  }

  public String genOpLss() {
    return "\tSUBR ILss\n";
  }

  public String genOpLeq() {
    return "\tSUBR ILeq\n";
  }

  public String genOpGtr() {
    return "\tSUBR IGtr\n";
  }

  public String genOpGeq() {
    return "\tSUBR IGeq\n";
  }

  public String genOpNeg() {
    return "\tSUBR BNeg\n";
  }

  public String genOpOr() {
    return "\tSUBR BOr\n";
  }

  public String genOpAnd() {
    return "\tSUBR BAnd\n";
  }







}
