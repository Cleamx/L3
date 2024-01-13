package TD2.ex2;

// Le code définit une interface appelée `FabriqueVehicule` qui déclare deux méthodes :
// `FabriqueAutomobile` et `FabriqueScooter`. Cette interface permet de définir un contrat pour les
// classes qui souhaitent l'implémenter. Les classes qui implémentent cette interface devront fournir
// une implémentation pour ces deux méthodes.
public interface FabriqueVehicule {
    
   /**
    * La fonction "FabriqueAutomobile" prend en paramètre un objet de type "Automobile".
    * 
    * @param automobile Le paramètre « automobile » est de type Automobile, qui représente une instance
    * de la classe Automobile.
    */
    public void FabriqueAutomobile(Automobile automobile);
   /**
    * Cette fonction crée un objet scooter en utilisant une méthode d'usine.
    * 
    * @param scooter Le paramètre "scooter" est de type Scooter, ce qui signifie qu'il attend qu'un
    * objet de la classe Scooter soit passé en argument.
    */
    public void FabriqueScooter(Scooter scooter);

}
