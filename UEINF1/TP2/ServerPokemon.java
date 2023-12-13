import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerPokemon {
    private ServerSocket serverSocket;
    private List<CombatClientHandler> handlers = new ArrayList<>();
    private int port;

    public ServerPokemon(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                // Attendre que deux dresseurs se connectent
                while (handlers.size() < 2) { // Change this line
                    Socket clientSocket = serverSocket.accept();

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

                    // Lire l'objet Dresseur du flux d'entrée
                    Dresseur dresseur = (Dresseur) objectInputStream.readObject();

                    // Créer un nouveau CombatClientHandler pour gérer la communication avec ce
                    // dresseur
                    CombatClientHandler handler = new CombatClientHandler(clientSocket, objectOutputStream,
                            objectInputStream, dresseur);
                    handlers.add(handler);
                    System.out.println("Added handler: " + handler);
                    System.out.println("Current handlers: " + handlers);
                    System.out.println("Current handlers size: " + handlers.size());

                }
                if (handlers.size() == 2) {
                    CombatClientHandler handler1 = handlers.get(0);
                    CombatClientHandler handler2 = handlers.get(1);

                    handler1.setOtherHandler(handler2);
                    handler2.setOtherHandler(handler1);

                    System.out.println("Handler1 Dresseur: " + handler1.getDresseur());
                    System.out.println("Handler2 Dresseur: " + handler2.getDresseur());

                    new Thread(handler1).start();
                    new Thread(handler2).start();

                    System.out.println("Sending Dresseur to Handler1...");
                    handler1.getObjectOutputStream().writeObject(handler2.getDresseur());
                    handler1.getObjectOutputStream().flush();
                    System.out.println("Dresseur sent to Handler1.");

                    System.out.println("Sending Dresseur to Handler2...");
                    handler2.getObjectOutputStream().writeObject(handler1.getDresseur());
                    handler2.getObjectOutputStream().flush();
                    System.out.println("Dresseur sent to Handler2.");
                
                    // Envoyer le message "START_COMBAT" à chaque dresseur pour commencer le combat
                    handler1.getObjectOutputStream().writeObject("START_COMBAT");
                    handler1.getObjectOutputStream().flush();
                    handler2.getObjectOutputStream().writeObject("START_COMBAT");
                    handler2.getObjectOutputStream().flush();
                    
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}