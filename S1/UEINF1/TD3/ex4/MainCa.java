package TD3.ex4;

public class MainCa {
    public static void main(String[] args) {
       // Avec un triplet d'entiers
       DucksGenerique<Integer> tripletInt = new DucksGenerique<>(1, 2, 3);
       System.out.println("Triplet d'entiers:");
       tripletInt.affiche();
       System.out.println();

       // Avec un triplet de chaînes de caractères
       DucksGenerique<String> tripletString = new DucksGenerique<>("Donald", "Daisy", "Scrooge");
       System.out.println("Triplet de chaînes de caractères:");
       tripletString.affiche();
       System.out.println();

       // Avec un triplet composé d'un entier, d'une chaîne de caractères et d'un double
       DucksGenerique<?> tripletMixed = new DucksGenerique<>(42, "Duckburg", 3.14);
       System.out.println("Triplet mixte:");
       tripletMixed.affiche();
   }
}
