import java.util.*;

// Hiérarchie fournie
abstract class Forme {
    abstract double surface();
}

class Cercle extends Forme {
    double rayon;
    Cercle(double r) { this.rayon = r; }
    public double surface() { return Math.PI * rayon * rayon; }
    public String toString() { return "Cercle(r=" + rayon + ")"; }
}

class Rectangle extends Forme {
    double largeur, hauteur;
    Rectangle(double l, double h) { largeur = l; hauteur = h; }
    public double surface() { return largeur * hauteur; }
    public String toString() { return "Rectangle(" + largeur + "x" + hauteur + ")"; }
}

public class Formes {

    // Question 4.1 — wildcard non borné : on lit juste, on n'a pas besoin du type exact
    public static void afficherSurfaces(List<?> formes) {
        for (Object f : formes) {
            // On sait que c'est une Forme grâce au contexte, mais ? = "type inconnu"
            // En pratique ici on cast, mais le vrai intérêt est montré en 4.2
            System.out.println(((Forme) f).surface());
        }
    }

    // Question 4.2 — ? extends Forme : on LIT des formes (Producer Extends)
    // List<Forme> seul ne suffit pas car List<Cercle> n'est pas un sous-type de List<Forme>
    public static double sommerSurfaces(List<? extends Forme> formes) {
        double total = 0;
        for (Forme f : formes) total += f.surface();
        return total;
    }

    // Question 4.3 — ? super Cercle : on ÉCRIT des Cercles (Consumer Super)
    public static void remplirCercles(List<? super Cercle> destination, int n) {
        for (int i = 0; i < n; i++) destination.add(new Cercle(1.0));
    }

    // Question 4.4 — PECS complet : source produit, destination consomme
    public static <T extends Forme> void copier(
            List<? extends T> source,
            List<? super T> destination) {
        for (T element : source) destination.add(element);

        // BONUS : si on écrit  source.add(...)  → ERREUR DE COMPILATION
        // Car ? extends T = "type inconnu sous-type de T", on ne peut pas y ajouter.
    }
}

class MainFormes {
    public static void main(String[] args) {

        List<Cercle>    cercles    = Arrays.asList(new Cercle(2), new Cercle(3));
        List<Rectangle> rectangles = Arrays.asList(new Rectangle(4, 5), new Rectangle(2, 3));

        // 4.1
        System.out.println("-- Surfaces cercles --");
        Formes.afficherSurfaces(cercles);
        System.out.println("-- Surfaces rectangles --");
        Formes.afficherSurfaces(rectangles);

        // 4.2
        System.out.println("Somme cercles    : " + Formes.sommerSurfaces(cercles));
        System.out.println("Somme rectangles : " + Formes.sommerSurfaces(rectangles));

        // 4.3
        List<Forme> destination = new ArrayList<>();
        Formes.remplirCercles(destination, 3);
        System.out.println("Après remplir : " + destination);

        // 4.4
        List<Forme> copie = new ArrayList<>();
        Formes.copier(cercles, copie);
        System.out.println("Copie : " + copie);
    }
}
