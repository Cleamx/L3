package Reseau.ex_manette;

import java.util.Arrays;

public class ManetteTest {
    public static void main(String[] args) {

        float joystickX1 = 0.75f;
        float joystickY1 = 0.5f;
        float joystickX2 = 0.2f;
        float joystickY2 = 0.9f;
        boolean[] boutons = { true, false, true, false, false, true, false, true, true };

        Manette frame = new Manette(joystickX1, joystickY1, joystickX2, joystickY2, boutons);

        // Sérialisation de la frame
        byte[] serializedData = Serialiser.SerialiserManette(frame);

        // Désérialisation de la frame
        Manette deserializedFrame = Serialiser.deserialise(serializedData);

        // Vérification des données désérialisées
        if (deserializedFrame != null) {
            System.out.println("Joystick X1: " + deserializedFrame.getJoystickX1());
            System.out.println("Joystick Y1: " + deserializedFrame.getJoystickY1());
            System.out.println("Joystick X2: " + deserializedFrame.getJoystickX2());
            System.out.println("Joystick Y2: " + deserializedFrame.getJoystickY2());
            System.out.println("Boutons: " + Arrays.toString(deserializedFrame.getBoutons()));
        } else {
            System.out.println("Échec de la désérialisation.");
        }
    }

}