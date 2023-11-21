package TD3.ex3;

public class Banque {
    int solde;

    public Banque(int solde){
        this.solde = solde;
    }

    public int Retrait(int eurRetrait) throws RetraitException{
        if ((this.solde - eurRetrait) < 0){
            throw new RetraitException("Le solde disponible est trop faible, vous ne pouvez pas faire de retrait");
        }

         this.solde = this.solde - eurRetrait;
         return this.solde;
    }

    public int getSolde() {
        return this.solde;
    }
    
}
