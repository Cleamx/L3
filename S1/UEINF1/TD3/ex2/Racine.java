package TD3.ex2;
public class Racine {

    public static double calculer(double nombre) throws ValeurNegativeException {
        if (nombre < 0) {
            throw new ValeurNegativeException("La valeur ne peut pas être négative.");
        }
        return Math.sqrt(nombre);
    }
}

