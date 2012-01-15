package mjc.gc;

public class VTABLEENTRY {
    private String name;
    private METHODE met;

    public VTABLEENTRY(String name,METHODE met) {
        this.met=met;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public METHODE getMethod() {
        return met;
    }
}