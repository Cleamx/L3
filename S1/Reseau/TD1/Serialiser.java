package TD1;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * La classe "Serealiser" fournit des méthodes pour sérialiser et désérialiser un objet de type
 * "Manette" dans un tableau d'octets.
 */
public class Serialiser {
    
    /**
     * La fonction "SerealiserManette" sérialise un objet Manette dans un tableau d'octets.
     * 
     * @param frame Le paramètre "frame" est un objet de type "Manette".
     * @return La méthode renvoie un tableau d'octets.
     */
    public static byte[] SerialiserManette(Manette frame) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

            dataOutputStream.writeFloat(frame.getJoystickX1());
            dataOutputStream.writeFloat(frame.getJoystickY1());
            dataOutputStream.writeFloat(frame.getJoystickX2());
            dataOutputStream.writeFloat(frame.getJoystickY2());

            for (boolean bouton : frame.getBoutons()) {
                dataOutputStream.writeBoolean(bouton);
            }

            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * La fonction désérialise un tableau d'octets en un objet Manette, qui représente un contrôleur de
     * jeu, en lisant les valeurs du tableau d'octets à l'aide d'un DataInputStream.
     * 
     * @param data Le paramètre "data" est un tableau d'octets qui contient les données sérialisées
     * d'un objet Manette.
     * @return La méthode renvoie une instance de la classe `Manette`.
     */
    public static Manette deserialise(byte[] data) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);

            float joystickX1 = dataInputStream.readFloat();
            float joystickY1 = dataInputStream.readFloat();
            float joystickX2 = dataInputStream.readFloat();
            float joystickY2 = dataInputStream.readFloat();

            boolean[] boutons = new boolean[9];
            for (int i = 0; i < 9; i++) {
                boutons[i] = dataInputStream.readBoolean();
            }

            dataInputStream.close();

            return new Manette(joystickX1, joystickY1, joystickX2, joystickY2, boutons);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
