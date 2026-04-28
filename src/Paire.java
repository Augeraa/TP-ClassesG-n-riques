public class Paire<A, B> {
 
    private A premier;
    private B second;
 
    public Paire(A premier, B second) {
        this.premier = premier;
        this.second = second;
    }
 
    public A getPremier() { return premier; }
    public B getSecond()  { return second; }
 
    @Override
    public String toString() {
        return "(" + premier + ", " + second + ")";
    }
 
    
    public static <A, B> Paire<B, A> inverser(Paire<A, B> p) {
        return new Paire<>(p.getSecond(), p.getPremier());
    }
