package TD5.ex4;

import java.net.Socket;

public class AcceptClient implements Runnable {
    private Socket socket;

    public AcceptClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Gérer la communication avec le client ici
    }

    // Autres méthodes de la classe AcceptClient
}