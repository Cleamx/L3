package Atelier1.exercice2;

public class entier {
    private int valeur;
    private final int borneMin;
    private final int borneMax;

    public entier(int borneMin, int borneMax){
        this.borneMax = borneMax;
        this.borneMin = borneMin;
        this.valeur = 0;
    }

    public entier(int borneMin, int borneMax, int valeur){
        this(borneMin, borneMax);
        this.valeur = valeur;
    }

    public void setValeur(int valeur){
        if (valeur >= borneMin && valeur <= borneMax){
            this.valeur = valeur;
        }
    }
    public String toString() {
        return Integer.toString(valeur);
    }

   
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        entier other = (entier) obj;
        return valeur == other.valeur && borneMin == other.borneMin && borneMax == other.borneMax;
    }
    

    
}
