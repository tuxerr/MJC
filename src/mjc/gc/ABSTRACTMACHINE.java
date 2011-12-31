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

    abstract public String genCst(String v);

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
    abstract public String genComment(String c);

    abstract public String genIf(String si, String inst1, String inst2);
    abstract public String genFin();
    abstract public String genReturn(String expr);
    abstract public String genDecl(String ident, INFOVAR iv, String code);
    abstract public String genAdr(int dep, int reg);
    abstract public String genWriteMem(int taille);
    abstract public String genFree(int taille);
    //genDeclAtt : génère le code (commentaire) lors de la déclaration d'attributs, assez analogue à genDecl
    abstract public String genDeclAtt(String ident, INFOVAR iv);
    //genCall : muzukashi desu.
    abstract public String genCall(String fctapp, String code);
    //genDeclMet : analogue à gen Decl ?
    abstract public String genDeclMet(String n, INFOMET i);

}


