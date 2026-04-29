import java.util.*;
 
public class Stats<T extends Number> {
 
    private List<T> valeurs;
 
    public Stats(List<T> valeurs) {
        this.valeurs = valeurs;
    }
 
    public double moyenne() {
        return somme(valeurs) / valeurs.size();
    }
 
    public T min() {
        T min = valeurs.get(0);
        for (T v : valeurs)
            if (v.doubleValue() < min.doubleValue()) min = v;
        return min;
    }
 
    public T max() {
        T max = valeurs.get(0);
        for (T v : valeurs)
            if (v.doubleValue() > max.doubleValue()) max = v;
        return max;
    }
 
    public double ecartType() {
        double moy = moyenne();
        double sommeCarres = 0;
        for (T v : valeurs) {
            double diff = v.doubleValue() - moy;
            sommeCarres += diff * diff;
        }
        return Math.sqrt(sommeCarres / valeurs.size());
    }
 
    // Question 3.2 — méthode statique bornée
    public static <T extends Number> double somme(List<T> liste) {
        double total = 0;
        for (T v : liste) total += v.doubleValue();
        return total;
    }
}
 
class MainStats {
    public static void main(String[] args) {
 
        List<Integer> notes = Arrays.asList(10, 12, 15, 8, 18);
        Stats<Integer> s = new Stats<>(notes);
 
        System.out.println("Moyenne   : " + s.moyenne());
        System.out.println("Min       : " + s.min());
        System.out.println("Max       : " + s.max());
        System.out.println("Écart-type: " + s.ecartType());
        System.out.println("Somme     : " + Stats.somme(notes));
 
        
    }
}
