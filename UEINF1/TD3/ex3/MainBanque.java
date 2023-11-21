package TD3.ex3;

public class MainBanque {
    public static void main(String[] args) {
        try{
            Banque nvBanque = new Banque(1000);
            
            nvBanque.Retrait(50);
            System.out.println(nvBanque.getSolde());
            nvBanque.Retrait(1000);
        }catch(RetraitException e){
            System.err.println("Erreur : " + e.getMessage());

        }
        
        
    }
}
