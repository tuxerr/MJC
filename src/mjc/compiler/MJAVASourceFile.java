package mjc.compiler;

import mg.egg.eggc.compiler.libjava.SourceUnit;
import mjc.gc.AbstractMachine;
import mjc.gc.TAM;

public class MJAVASourceFile extends SourceUnit {
	private AbstractMachine machine;
	private boolean verbose;
	private String fileName;

	public MJAVASourceFile(String arg0) {
		super(arg0);
	}

	private void usage(String a) throws MJCException {
		throw new MJCException("Arg = " + a + " "
				+ Messages.getString("MJC.usage"));
		// System.err.println(Messages.getString("MJC.usage")); //$NON-NLS-1$
		// System.exit(1);
	}

	private void help() {
		System.err.println(Messages.getString("MJC.message")); //$NON-NLS-1$
		System.err.println(Messages.getString("MJC.verbose")); //$NON-NLS-1$
		System.err.println(Messages.getString("MJC.machine")); //$NON-NLS-1$
		System.err.println(Messages.getString("MJC.help")); //$NON-NLS-1$
		System.exit(0);
	}

	public void analyze(String[] args) throws MJCException {
		// for (String a : args)
		// System.err.println("a = " + a);
		int argc = args.length;
		if (argc <= 0)
			usage("");
		setFile(args[0]);
		setMachine("tam");
		for (int i = 1; i < argc; i++) {
			String a = args[i];
			// System.err.println("Args[" + i + "] = " + a);
			if ("-m".equals(a)) { //$NON-NLS-1$
				if (i + 1 < argc) {
					i++;
					setMachine(args[i]);
				} else
					setMachine("tam");
			} else if ("-h".equals(a)) { //$NON-NLS-1$
				help();
			} else if ("-v".equals(a)) { //$NON-NLS-1$
				setVerbose();
			} else {
				usage(a);
			}
		}
	}

	private void setFile(String a) throws MJCException {
		int pt = a.lastIndexOf('.');
		if (pt != -1) {
			String ext = a.substring(pt + 1);
			if (!"mj".equals(ext))
				usage(a);
			else
				fileName = a.substring(0, pt);
		} else
			usage(a);
	}

	private void setVerbose() {
		verbose = true;
	}

	private void setMachine(String mach) {
		if ("tam".equals(mach)) {
			machine = new TAM();
		}
	}

	public AbstractMachine getMachine() {
		return machine;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public String getFileName() {
		return fileName;
	}

}
