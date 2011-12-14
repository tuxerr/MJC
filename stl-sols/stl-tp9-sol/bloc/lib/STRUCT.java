package bloc.lib;

public class STRUCT extends DTYPE {

	private LCHAMPS champs;

	public STRUCT(LCHAMPS champs) {
		super("struct", champs.getTaille());
		this.champs = champs;
	}



	public LCHAMPS getChamps() {
		return champs;
	}
	public boolean compareTo(DTYPE autre) {
		if (autre instanceof STRUCT)
			return champs.compareTo(((STRUCT) autre).champs);
		if (autre instanceof TUPLE)
			return getTypes().compareTo(((TUPLE) autre).getTypes());
		return false;
	}


	public String toString(){
		return super.toString() + " champs = " + champs;
	}



	public LTYPES getTypes() {
		LTYPES lt = new LTYPES();
		for (CHAMP c : champs){
			lt.add(c.getType());
		}
		return lt;
	}
}
