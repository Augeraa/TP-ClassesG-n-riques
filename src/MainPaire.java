public class MainPaire {
    public static void main(String[] args) {
        
        Paire<String, Integer> p1 = new Paire<>("Alice", 42);
        System.out.println(p1); // (Alice, 42)
        
        Paire<Integer, String> p2 = Paire.inverser(p1);
        System.out.println(p2); // (42, Alice)
        
        Paire<Double, Boolean> p3 = new Paire<>(3.14, true);
        System.out.println(p3.getPremier().getClass().getSimpleName()
            + " — " + p3.getSecond().getClass().getSimpleName()); // Double — Boolean
    }
}
