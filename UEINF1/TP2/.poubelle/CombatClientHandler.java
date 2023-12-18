// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.net.Socket;

// public class CombatClientHandler implements Runnable {
//     private Socket clientSocket;
//     private ObjectInputStream objectInputStream;
//     private ObjectOutputStream objectOutputStream;
//     private Dresseur dresseur;
//     private CombatClientHandler otherHandler;
//     private Dresseur otherDresseur;
//     private CombatDresseur combat;

//     // Constructeur
//     public CombatClientHandler(Socket clientSocket, ObjectOutputStream objectOutputStream,
//             ObjectInputStream objectInputStream, Dresseur dresseur) throws IOException {
//         this.clientSocket = clientSocket;
//         this.objectOutputStream = objectOutputStream;
//         this.objectInputStream = objectInputStream;
//         this.dresseur = dresseur;
//     }

//     // Getters
//     public Dresseur getDresseur() {
//         return this.dresseur;
//     }

//     public Dresseur getOtherDresseur() {
//         return otherHandler.dresseur;
//     }

//     public ObjectOutputStream getObjectOutputStream() {
//         return objectOutputStream;
//     }

//     // Setters
//     public void setOtherHandler(CombatClientHandler otherHandler) {
//         this.otherHandler = otherHandler;
//         this.otherDresseur = otherHandler.getDresseur();
//     }

//     // Méthodes de gestion des messages
//     public void sendMessageToServer(String message) {
//         try {
//             objectOutputStream.writeObject(message);
//             objectOutputStream.flush();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     public void handleServerMessage(String message) {
//         if (message.equals("CHOISIR_POKEMON")) {
//             int indexPokemonDresseur = dresseur.choisirPokemon();
//             sendMessageToServer("POKEMON_CHOISI:" + indexPokemonDresseur);
//         } else if (message.startsWith("POKEMON_CHOISI:")) {
//             int indexPokemonOtherDresseur = Integer.parseInt(message.substring("POKEMON_CHOISI:".length()));
//             combat.executeCombatTurn(otherDresseur, indexPokemonOtherDresseur);
//             sendMessageToServer("CHOISIR_POKEMON");
//         }
//     }

//     // Méthodes de gestion du combat
//     public void startCombatDresseur() {
//         combat = new CombatDresseur(dresseur, otherDresseur);
//         System.out.println("Combat entre " + dresseur.getNom() + " et " + otherDresseur.getNom());
//         sendMessageToServer("CHOISIR_POKEMON");
//     }

//     // Méthode run pour le Runnable
//     @Override
//     public void run() {
//         try {
//             while (true) {
//                 Object received = objectInputStream.readObject();
//                 if (received instanceof Dresseur) {
//                     this.otherDresseur = (Dresseur) received;
//                     System.out.println("Received Dresseur: " + this.otherDresseur);
//                 } else if (received instanceof String) {
//                     String message = (String) received;
//                     if (message.equals("START_COMBAT")) {
//                         System.out.println("DRESSEUR ACTUEL: " + this.dresseur.getNom());
//                         System.out.println("DRESSEUR ADVERSE: " + this.getOtherDresseur().getNom());
//                         startCombatDresseur();
//                     } else {
//                         handleServerMessage(message);
//                     }
//                 } else {
//                     System.out.println("Received unknown object of type: " + received.getClass().getName());
//                 }
//             }
//         } catch (IOException | ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//     }

//     // Méthode toString
//     @Override
//     public String toString() {
//         return "CombatClientHandler with dresseur: " + (dresseur == null ? "null" : dresseur.getNom());
//     }
// }