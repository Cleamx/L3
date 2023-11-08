package TD2.ex2;

public class FabriqueVehiculeElec implements FabriqueVehicule {

    @Override
    public void FabriqueAutomobile(Automobile automobile) {
        automobile = new AutomobileElec(180, 4, "Tesla", "rouge");
    }

    @Override
    public void FabriqueScooter(Scooter scooter) {
        scooter = new ScooterElec(70, "Vespa", "Vert");
    }
    
}
