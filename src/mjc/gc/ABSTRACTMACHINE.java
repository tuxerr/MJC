package mjc.gc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import mjc.compiler.MJCException;

public abstract class ABSTRACTMACHINE {

    public void writeCode(String fname, String code) throws MJCException {
        try {
            String asmName = fname + ".mjava";
            System.err.println("Ecriture du code dans " + asmName);
            PrintWriter pw = new PrintWriter(new FileOutputStream(asmName));
            pw.print(code);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new MJCException(e.getMessage());
        }
    }
    // variable
    abstract public String genCst(String v);
    abstract public String genDeclAtt(String ident, VAR iv);
    abstract public String genAffect(String ident, VAR info, String code);
    abstract public String genCallVar(String s, VAR i);

    //Operateurs
    abstract public String genOpAdd();
    abstract public String genOpSub();
    abstract public String genOpMul();
    abstract public String genOpDiv();
    abstract public String genOpMod();
    abstract public String genOpEq();
    abstract public String genOpNeq();
    abstract public String genOpLss();
    abstract public String genOpLeq();
    abstract public String genOpGtr();
    abstract public String genOpGeq();
    abstract public String genOpNeg();
    abstract public String genOpOr();
    abstract public String genOpAnd();
    abstract public String genIf(String si, String inst1, String inst2);
    // programme
    abstract public String genFin();
    abstract public String genComment(String c);
   
    // methodes
    abstract public String genReturn(String expr);
    abstract public String genDeclMet(String n, METHODE i);
    abstract public String genCall(String fctapp, String code);  
  
    // memoire
    abstract public String genAdr(int dep, int reg);// a quoi ca sert ?
    abstract public String genAdrField(int dep);    // idem

    abstract public String genMem(int i);
    abstract public String ReadMem(int taille);
    abstract public String genWriteMem(int taille);

    abstract public String genFree(int taille);
    abstract public String genMalloc(int taille);

  }


