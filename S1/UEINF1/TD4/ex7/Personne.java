package TD4.ex7;

public class Personne implements Comparable<Personne> {

    private String nom;
    private String prenom;
    private int age;

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Personne autrePersonne) {
        // Compare d'abord par âge
        int diffAge = this.age - autrePersonne.age;
        if (diffAge != 0) {
            return diffAge;
        }

        // Si les âges sont égaux, compare par ordre alphabétique du nom et prénom
        int diffNom = this.nom.compareToIgnoreCase(autrePersonne.nom);
        if (diffNom != 0) {
            return diffNom;
        }

        return this.prenom.compareToIgnoreCase(autrePersonne.prenom);
    }
}
