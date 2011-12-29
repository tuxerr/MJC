package mjc.gc;

import java.util.ArrayList;

public class ACCEPTEDTYPES extends ArrayList<DTYPE> {
    public boolean contains(DTYPE type) { 
        for(DTYPE d : this) {
            if (d.equals(type)) {
                return true;
            } 
        }
        return false;
    };
}