import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class BroadcastMessage {
    private List<Socket> dresseurs_Sockets;
    private String message;
    private List<Dresseur> dresseurs_Connected;

    public BroadcastMessage(List<Socket> dresseurs, String message, List<Dresseur> dresseurs_Connected) {
        this.dresseurs_Sockets = dresseurs;
        this.message = message;
        this.dresseurs_Connected = dresseurs_Connected;
    }

    public void send() {
        for (Socket socket : dresseurs_Sockets) {
            try {
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                synchronized (dresseurs_Connected) {
                    if (!dresseurs_Connected.isEmpty()) {
                        writer.println(message);
                        writer.println(dresseurs_Connected.get(0));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}