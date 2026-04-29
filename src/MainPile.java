class MainPile {
    public static void main(String[] args) {
 
        // 1. Créer et empiler
        Pile<Integer> pile = new Pile<>();
        pile.empiler(1);
        pile.empiler(2);
        pile.empiler(3);
        pile.empiler(4);
        pile.empiler(5);
 
        // 2. Afficher
        System.out.println("Pile : " + pile); // [5 | 4 | 3 | 2 | 1]
 
        // 3. Dépiler le sommet
        int val = pile.depiler();
        System.out.println("Dépiléé : " + val);   // 5
        System.out.println("Pile : " + pile);      // [4 | 3 | 2 | 1]
 
        // 4. Pile inversée
        Pile<Integer> inversee = PileUtils.inverser(pile);
        System.out.println("Inversée : " + inversee); // [1 | 2 | 3 | 4]
        System.out.println("Originale : " + pile);    // [4 | 3 | 2 | 1] (inchangée)
    }
}