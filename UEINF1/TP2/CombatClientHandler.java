/**
 * La classe `CombatClientHandler` est une classe Java qui gère la communication entre un client et un
 * serveur dans un jeu de combat, permettant au client de démarrer un combat lorsque le serveur envoie
 * un message spécifique.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CombatClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private Dresseur dresseur;
    private CombatClientHandler autreHandler; // Ajoutez ce champ

    public CombatClientHandler(Socket clientSocket, ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream, Dresseur dresseur) throws IOException {
        this.clientSocket = clientSocket;
        this.objectOutputStream = objectOutputStream;
        this.objectInputStream = objectInputStream;
        this.dresseur = dresseur;
    }
    
    @Override
    public void run() {
        try {
            // Écouter les messages du serveur
            while (true) {
                Object message = objectInputStream.readObject();
                if (message instanceof String) {
                    String strMessage = (String) message;
                    System.out.println(strMessage);
    
                    if (strMessage.equals("START_COMBAT")) {
                        // Appeler startCombat quand le serveur envoie "START_COMBAT"
                        CombatDresseur combatDresseur = new CombatDresseur(dresseur, autreHandler.getDresseur());
                        combatDresseur.startCombat();
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la lecture des messages du serveur.");
            e.printStackTrace();
        }
    }

    public Dresseur getDresseur() {
        return this.dresseur;
    }
    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }
    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }
    public void setAutreHandler(CombatClientHandler autreHandler) {
        this.autreHandler = autreHandler;
    }
}