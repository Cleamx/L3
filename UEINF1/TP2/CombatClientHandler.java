import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CombatClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Dresseur dresseur;
    private CombatClientHandler otherHandler;
    private Dresseur otherDresseur;
    private CombatDresseur combat;

    public CombatClientHandler(Socket clientSocket, ObjectOutputStream objectOutputStream,
            ObjectInputStream objectInputStream, Dresseur dresseur) throws IOException {
        this.clientSocket = clientSocket;
        this.objectOutputStream = objectOutputStream;
        this.objectInputStream = objectInputStream;
        this.dresseur = dresseur;
    }

    public void setOtherHandler(CombatClientHandler otherHandler) {
        this.otherHandler = otherHandler;
        this.otherDresseur = otherHandler.getDresseur(); // Assurez-vous que cette ligne est présente
    }

    public Dresseur getOtherDresseur() {
        return otherHandler.dresseur;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object received = objectInputStream.readObject();
                if (received instanceof Dresseur) {
                    this.otherDresseur = (Dresseur) received;
                    System.out.println("Received Dresseur: " + this.otherDresseur);
                } else if (received instanceof String) {
                    String message = (String) received;
                    if (message.equals("START_COMBAT")) {
                        System.out.println("DRESSEUR ACTUEL: " + this.dresseur.getNom());
                        System.out.println("DRESSEUR ADVERSE: " + this.getOtherDresseur().getNom());
                        startCombatDresseur();
                    } else {
                        handleServerMessage(message);
                    }
                } else {
                    // Gérez le cas où l'objet reçu n'est ni une String ni un Dresseur
                    System.out.println("Received unknown object of type: " + received.getClass().getName());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void startCombatDresseur() {
        combat = new CombatDresseur(dresseur, otherDresseur);
        System.out.println("Combat entre " + dresseur.getNom() + " et " + otherDresseur.getNom());

        sendMessageToServer("CHOISIR_POKEMON");
    }

    public void handleServerMessage(String message) {
        if (message.equals("CHOISIR_POKEMON")) {
            int indexPokemonDresseur = dresseur.choisirPokemon();
            // Envoyer un message au serveur pour lui dire quel Pokémon a été choisi
            sendMessageToServer("POKEMON_CHOISI:" + indexPokemonDresseur);
        } else if (message.startsWith("POKEMON_CHOISI:")) {
            int indexPokemonOtherDresseur = Integer.parseInt(message.substring("POKEMON_CHOISI:".length()));

            combat.executeCombatTurn(otherDresseur, indexPokemonOtherDresseur);
            // Envoyer un message au serveur pour lui dire de demander à l'autre dresseur de
            // choisir un Pokémon
            sendMessageToServer("CHOISIR_POKEMON");
        }
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void sendMessageToServer(String message) {
        try {
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CombatClientHandler with dresseur: " + (dresseur == null ? "null" : dresseur.getNom());
    }

    public Dresseur getDresseur() {
        return this.dresseur;
    }
}