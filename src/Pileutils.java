import java.util.*;

public class Pileutils {

    public static <T> Pile<T> inverser(Pile<T> source) {
        
        Pile<T> copie = new Pile<>();
        Pile<T> resultat = new Pile<>();

        
        List<T> temp = new ArrayList<>();
        Pile<T> tmp = new Pile<>();

        
        while (!source.estVide()) {
            temp.add(source.depiler());
        }
       
        for (int i = temp.size() - 1; i >= 0; i--) {
            source.empiler(temp.get(i));
        }
        
        for (T val : temp) {
            resultat.empiler(val);
        }
        return resultat;
    }
}
