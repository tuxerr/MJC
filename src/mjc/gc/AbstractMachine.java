package mjc.gc;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import mjc.compiler.MJCException;

public abstract class AbstractMachine {
    protected abstract String getSuffixe();

    public void writeCode(String fname, String code) throws MJCException {
        try {
            String asmName = fname + "." + getSuffixe();
            System.err.println("Ecriture du code dans " + asmName);
            PrintWriter pw = new PrintWriter(new FileOutputStream(asmName));
            pw.print(code);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new MJCException(e.getMessage());
        }
    }

    abstract String genCst(String v);

    abstract String genOpPlus();
    abstract String genOpMoins();
    abstract String genOpAdd();
    abstract String genOpSub();
    abstract String genOpMul();
    abstract String genOpDiv();
    abstract String genOpMod();
    abstract String genOpEq();
    abstract String genOpNeq();
    abstract String genOpLss();
    abstract String genOpLeq();
    abstract String genOpGtr();
    abstract String genOpGeq();
    abstract String genOpNeg();
    abstract String genOpOr();
    abstract String genOpAnd();

    abstract String genIf(String si, String inst1, String inst2);
    abstract String genFin();
    abstract String genReturn(String expr);
    abstract String genDecl(String ident, INFOVAR iv, String code);
    abstract String genAdr(int dep, int reg);
    abstract String genWriteMem(int taille);
    abstract String genFree(int taille);
    //genDeclAtt : génère le code (commentaire) lors de la déclaration d'attributs, assez analogue à genDecl
    abstract String genDeclAtt(String ident, INFOVAR iv);

}


