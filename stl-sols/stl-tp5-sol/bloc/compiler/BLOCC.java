package bloc.compiler;

import java.io.Serializable;

import mg.egg.eggc.compiler.libjava.ISourceUnit;
import mg.egg.eggc.compiler.libjava.problem.IProblem;
import mg.egg.eggc.compiler.libjava.problem.ProblemReporter;
import mg.egg.eggc.compiler.libjava.problem.ProblemRequestor;
import bloc.egg.BLOC;

public class BLOCC implements Serializable {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		System.err.println("version " + "0.0.1");
		try {
			ISourceUnit cu = new BLOCSourceFile(args[0]);
			ProblemReporter prp = new ProblemReporter(cu);
			ProblemRequestor prq = new ProblemRequestor();
			((BLOCSourceFile) cu).analyze(args);
			System.err.println("Compiling " + cu.getFileName());
			BLOC compilo = new BLOC(prp);
			prq.beginReporting();
			compilo.set_source((BLOCSourceFile) cu);
			compilo.compile(cu);
			for (IProblem problem : prp.getAllProblems())
				prq.acceptProblem(problem);
			prq.endReporting();
			System.err.println(Messages.getString("BLOC.ok")); //$NON-NLS-1$
			System.exit(0);
		} catch (BLOCException e) {
			System.err.println(e.getMessage());
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
