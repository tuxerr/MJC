package bloc.lib;

public class TUPLE extends DTYPE {

	private LTYPES types;

	public TUPLE(LTYPES types) {
		super("tuple", types.getTaille());
		this.types = types;
	}

	public LTYPES getTypes() {
		return types;
	}

	public boolean compareTo(DTYPE autre) {
		if (autre instanceof TUPLE)
			return types.compareTo(((TUPLE) autre).types);
		if (autre instanceof STRUCT)
			return types.compareTo(((STRUCT) autre).getTypes());
		return false;
	}

	public String toString() {
		return super.toString() + " types = " + types;
	}

}
