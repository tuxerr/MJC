package mjc.compiler;

import java.io.Serializable;

import mg.egg.eggc.compiler.libjava.ISourceUnit;
import mg.egg.eggc.compiler.libjava.problem.IProblem;
import mg.egg.eggc.compiler.libjava.problem.ProblemReporter;
import mg.egg.eggc.compiler.libjava.problem.ProblemRequestor;
import mjc.egg.MJAVA;
import mjc.egg.MJAVA2;
import mjc.egg.MJAVA3;

public class MJC implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        System.err.println("version " + "0.0.1");
        try {
            ISourceUnit cu = new MJAVASourceFile(args[0]);
            ProblemReporter prp = new ProblemReporter(cu);
            ProblemRequestor prq = new ProblemRequestor();
            ((MJAVASourceFile) cu).analyze(args);
            System.err.println("Compiling " + cu.getFileName());
            MJAVA compilo = new MJAVA(prp);
            prq.beginReporting();
            compilo.set_source((MJAVASourceFile) cu);
            compilo.compile(cu);
            for (IProblem problem : prp.getAllProblems())
                prq.acceptProblem(problem);
            prq.endReporting();

            ISourceUnit cu2 = new MJAVASourceFile(args[0]);
            ((MJAVASourceFile)cu2).setTDS(((MJAVASourceFile)cu).getTDS());
            ProblemReporter prp2 = new ProblemReporter(cu2);
            ProblemRequestor prq2 = new ProblemRequestor();
            ((MJAVASourceFile) cu2).analyze(args);
            System.err.println("Compiling " + cu2.getFileName());
            MJAVA2 compilo2 = new MJAVA2(prp2);
            prq2.beginReporting();
            compilo2.set_source((MJAVASourceFile) cu2);
            compilo2.compile(cu2);
            for (IProblem problem2 : prp2.getAllProblems())
                prq2.acceptProblem(problem2);
            prq2.endReporting();

            ISourceUnit cu3 = new MJAVASourceFile(args[0]);
            ((MJAVASourceFile)cu3).setTDS(((MJAVASourceFile)cu).getTDS());
            ProblemReporter prp3 = new ProblemReporter(cu3);
            ProblemRequestor prq3 = new ProblemRequestor();
            ((MJAVASourceFile) cu3).analyze(args);
            System.err.println("Compiling " + cu3.getFileName());
            MJAVA3 compilo3 = new MJAVA3(prp3);
            prq3.beginReporting();
            compilo3.set_source((MJAVASourceFile) cu3);
            compilo3.compile(cu3);
            for (IProblem problem3 : prp3.getAllProblems())
                prq3.acceptProblem(problem3);
            prq3.endReporting();

            System.err.println(Messages.getString("MJC.ok")); //$NON-NLS-1$
            System.exit(0);
        } catch (MJCException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
