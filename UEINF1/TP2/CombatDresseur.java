public class CombatDresseur {
    protected static Dresseur dresseur1;
    protected static Dresseur dresseur2;

    public static void AddDresseur(Dresseur dresseur) {
        dresseur1 = dresseur;
        if (dresseur1 != null) {
            dresseur2 = dresseur;
        }
    }
    //combat de dresseurs lorsque deux dresseurs sont connecter au serveur


}
