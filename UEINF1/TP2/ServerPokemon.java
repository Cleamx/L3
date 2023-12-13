import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerPokemon {
    private ServerSocket serverSocket;
    private List<CombatClientHandler> dresseurs = new ArrayList<>();
    private int port;
    private List<Dresseur> clientsConnectes = new ArrayList<>();

    public void ajouterClient(Dresseur client) {
        clientsConnectes.add(client);
    }

    public Dresseur obtenirAdversaire(Dresseur client) {
        for (Dresseur adversaire : clientsConnectes) {
            if (!adversaire.equals(client)) {
                return adversaire;
            }
        }
        return null; // Retourne null si aucun adversaire n'est trouvé (ce qui ne devrait pas arriver si la liste contient au moins deux clients)
    }
    public ServerPokemon(int port) {
        this.port = port;
    }

    public void startServer() throws ClassNotFoundException {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                while (dresseurs.size() < 2) {
                    System.out.println("Avant l'acceptation d'une connexion");
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Après l'acceptation d'une connexion");

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                    ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

                    // Lire l'objet Dresseur du flux d'entrée
                    Dresseur dresseur = null;
                    try {
                        dresseur = (Dresseur) objectInputStream.readObject();
                    } catch (ClassNotFoundException e) {
                        System.err.println("Erreur lors de la lecture de l'objet Dresseur");
                        e.printStackTrace();
                    }

                    if (dresseurs.size() == 0) {
                        CombatClientHandler handler = new CombatClientHandler(clientSocket, objectOutputStream,
                                objectInputStream, dresseur);
                        dresseurs.add(handler);
                        new Thread(handler).start();
                    } else {
                        CombatClientHandler handler1 = dresseurs.get(0);
                        CombatClientHandler handler2 = new CombatClientHandler(clientSocket, objectOutputStream,
                                objectInputStream, dresseur);
                        handler1.setAutreHandler(handler2);
                        dresseurs.add(handler2);
                        new Thread(handler2).start();
                    }

                    System.out.println(
                            "Un dresseur s'est connecté. Nombre total de dresseurs connectés : " + dresseurs.size());
                }

                System.out.println("Deux dresseurs sont connectés. Le combat va commencer.");

                CombatClientHandler handler1 = dresseurs.get(0);
                CombatClientHandler handler2 = dresseurs.get(1);

                // Envoyer le message "START_COMBAT" à chaque client
                handler1.getObjectOutputStream().writeObject("START_COMBAT");
                handler1.getObjectOutputStream().flush();
                handler2.getObjectOutputStream().writeObject("START_COMBAT");
                handler2.getObjectOutputStream().flush();

                dresseurs.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
