package TD5.ex4;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;

public class Serveur {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(2000);
            Socket socket = server.accept();
            System.out.println("Nouvel utilisateur connecté");

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            out.println("Message");
            out.flush();

            socket.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
