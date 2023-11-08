package TD2.ex2;

public class FabriqueVehiculeEssence implements FabriqueVehicule {

    @Override
    public void FabriqueAutomobile(Automobile automobile) {
        automobile = new AutomobileEssence(180, 4, "aaa", "rouge");
    }

    @Override
    public void FabriqueScooter(Scooter scooter) {
        scooter = new ScooterEssence(70, "Vespa", "Vert");
    }
    
}
