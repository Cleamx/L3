
public class MainServeur {
    public static void main(String[] args) {
            ServerPokemon server = new ServerPokemon(8000); 

            // Lancez le serveur dans un nouveau thread
            new Thread(() -> {

                    server.startServer();
                
            }).start();
        }
    }