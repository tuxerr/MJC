package bloc.lib;
import java.util.ArrayList;

public class ListeVar extends ArrayList<String> {
     public ListeVar(){
       super();
     }

    public void inserer(String v){
         add(v);
     }
     
    public boolean contient(String v){
      return contains(v);
     }

}
