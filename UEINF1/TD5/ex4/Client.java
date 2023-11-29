package TD5.ex4;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 2000);
        socket.close();
    }
}
