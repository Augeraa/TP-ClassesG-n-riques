import java.util.*;
 
public class Pile<T> {
 
    private List<T> elements = new ArrayList<>();
 
    public void empiler(T element) {
        elements.add(element);
    }
 
    public T depiler() {
        if (estVide()) throw new NoSuchElementException("La pile est vide");
        return elements.remove(elements.size() - 1);
    }
 
    public T sommet() {
        if (estVide()) throw new NoSuchElementException("La pile est vide");
        return elements.get(elements.size() - 1);
    }
 
    public boolean estVide() { return elements.isEmpty(); }
    public int taille()      { return elements.size(); }
 
    @Override
    public String toString() {
        if (estVide()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = elements.size() - 1; i >= 0; i--) {
            sb.append(elements.get(i));
            if (i > 0) sb.append(" | ");
        }
        return sb.append("]").toString();
    }
}