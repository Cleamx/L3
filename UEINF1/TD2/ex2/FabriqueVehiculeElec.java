package TD2.ex2;

/**
 * La classe FabriqueVehiculeElec est une implémentation concrète de l'interface FabriqueVehicule qui
 * crée des instances d'Automobile Électrique et de Scooter Électrique avec des paramètres spécifiques.
 */
public class FabriqueVehiculeElec implements FabriqueVehicule {

    /**
     * La fonction "FabriqueAutomobile" crée une nouvelle instance de la classe "AutomobileElec" avec
     * des paramètres spécifiques et lui affecte le paramètre d'entrée "automobile".
     * 
     * @param automobile Le paramètre "automobile" est un objet de type "Automobile".
     */
    @Override
    public void FabriqueAutomobile(Automobile automobile) {
        automobile = new AutomobileElec(180, 4, "Tesla", "rouge");
    }

    /**
     * La fonction FabriqueScooter crée une nouvelle instance de la classe ScooterElec avec des
     * paramètres spécifiques.
     * 
     * @param scooter Le paramètre « scooter » est un objet de type Scooter.
     */
    @Override
    public void FabriqueScooter(Scooter scooter) {
        scooter = new ScooterElec(70, "Vespa", "Vert");
    }
    
}
