package bloc.compiler;

import mg.egg.eggc.compiler.libjava.SourceUnit;

public class BLOCSourceFile extends SourceUnit {
	private boolean verbose;
	private String fileName;

	public BLOCSourceFile(String arg0) {
		super(arg0);
	}

	private void usage(String a) throws BLOCException {
		throw new BLOCException("Arg = " + a + " "
				+ Messages.getString("BLOC.usage"));
	}

	private void help() {
		System.err.println(Messages.getString("BLOC.message")); //$NON-NLS-1$
		System.err.println(Messages.getString("BLOC.verbose")); //$NON-NLS-1$
		System.err.println(Messages.getString("BLOC.help")); //$NON-NLS-1$
		System.exit(0);
	}

	public void analyze(String[] args) throws BLOCException {
		int argc = args.length;
		if (argc <= 0)
			usage("");
		setFile(args[0]);
		for (int i = 1; i < argc; i++) {
			String a = args[i];
			// System.err.println("Args[" + i + "] = " + a);
			if ("-h".equals(a)) { //$NON-NLS-1$
				help();
			} else if ("-v".equals(a)) { //$NON-NLS-1$
				setVerbose();
			} else {
				usage(a);
			}
		}
	}

	private void setFile(String a) throws BLOCException {
		int pt = a.lastIndexOf('.');
		if (pt != -1) {
			String ext = a.substring(pt + 1);
			if (!"bloc".equals(ext))
				usage(a);
			else
				fileName = a.substring(0, pt);
		} else
			usage(a);
	}

	private void setVerbose() {
		verbose = true;
	}

	public boolean isVerbose() {
		return verbose;
	}

	public String getFileName() {
		return fileName;
	}

}
