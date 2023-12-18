// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.net.ServerSocket;
// import java.net.Socket;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;

// public class ServerPokemon {
//     private ServerSocket serverSocket;
//     private List<CombatClientHandler> handlers;
//     private int port;
//     private boolean isRunning;
//     private ExecutorService executorService; // Ajout d'un ExecutorService

//     // Constructeur
//     public ServerPokemon(int port) {
//         this.port = port;
//         this.isRunning = true;
//         this.handlers = new ArrayList<>();
//         this.executorService = Executors.newFixedThreadPool(100); // Initialisation de l'ExecutorService
//     }

//     // Méthodes de gestion du serveur
//     public void startServer() {
//         try {
//             serverSocket = new ServerSocket(port);
//             while (isRunning) {
//                 handleNewConnections();
//                 if (handlers.size() == 2) {
//                     startCombat();
//                 }
//             }
//         } catch (IOException | ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//     }

//     // Méthodes de gestion des connexions
//     private void handleNewConnections() throws IOException, ClassNotFoundException {
//         while (handlers.size() < 2) {
//             Socket clientSocket = serverSocket.accept();

//             ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
//             ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

//             Dresseur dresseur = (Dresseur) objectInputStream.readObject();

//             CombatClientHandler handler = new CombatClientHandler(clientSocket, objectOutputStream,
//                     objectInputStream, dresseur);
//             handlers.add(handler);
//         }
//     }

//     // Méthodes de gestion du combat
//     private void startCombat() throws IOException {
//         CombatClientHandler handler1 = handlers.get(0);
//         CombatClientHandler handler2 = handlers.get(1);

//         handler1.setOtherHandler(handler2);
//         handler2.setOtherHandler(handler1);

//         executorService.submit(handler1); // Utilisation de l'ExecutorService pour démarrer les threads
//         executorService.submit(handler2);

//         handler1.getObjectOutputStream().writeObject(handler2.getDresseur());
//         handler1.getObjectOutputStream().flush();

//         handler2.getObjectOutputStream().writeObject(handler1.getDresseur());
//         handler2.getObjectOutputStream().flush();

//         handler1.getObjectOutputStream().writeObject("START_COMBAT");
//         handler1.getObjectOutputStream().flush();
//         handler2.getObjectOutputStream().writeObject("START_COMBAT");
//         handler2.getObjectOutputStream().flush();
//     }
// }