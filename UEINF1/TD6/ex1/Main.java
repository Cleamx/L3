package TD6.ex1;

public class Main {
    public static void main(String[] args) {
        Personne p = new Personne("Doe", "John", 42);
        Serialiser s = new Serialiser();
        s.enregistrerPersonne(p, "ex1/personne.txt");
        
        Deserialiser d = new Deserialiser();
        Personne p2 = d.lirePersonne("personne.txt");
        System.out.println(p2);
    }
}
