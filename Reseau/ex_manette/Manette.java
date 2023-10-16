package Reseau.ex_manette;

/**
 * La classe `Manette` représente un contrôleur de jeu avec deux joysticks et un ensemble de boutons.
 */
public class Manette {
    private float joystickX1;
    private float joystickY1;
    private float joystickX2;
    private float joystickY2;
    private boolean[] boutons;

    // La `public Manette(float joystickX1, float joystickY1, float joystickX2, float joystickY2,
    // boolean[] boutons)` est une méthode constructeur pour la classe `Manette`. Il est utilisé pour
    // créer une nouvelle instance de l'objet `Manette` et initialiser ses variables membres
    // (`joystickX1`, `joystickY1`, `joystickX2`, `joystickY2` et `boutons`) avec les valeurs passées
    // en arguments au constructeur .
    public Manette(float joystickX1, float joystickY1, float joystickX2, float joystickY2, boolean[] boutons) {
        this.joystickX1 = joystickX1;
        this.joystickY1 = joystickY1;
        this.joystickX2 = joystickX2;
        this.joystickY2 = joystickY2;
        this.boutons = boutons;
    }

    /**
     * La fonction renvoie la valeur de la position de l'axe X du joystick.
     * 
     * @return La méthode renvoie la valeur de la variable "joystickX1", qui est un float.
     */
    public float getJoystickX1() {
        return joystickX1;
    }

   /**
    * La fonction renvoie la valeur de la position de l'axe Y du joystick.
    * 
    * @return La méthode renvoie la valeur de la variable "joystickY1", qui est un float.
    */
    public float getJoystickY1() {
        return joystickY1;
    }

    /**
     * La fonction renvoie la valeur de la variable joystickX2, qui représente la position sur l'axe X
     * d'un joystick.
     * 
     * @return La méthode renvoie la valeur de la variable "joystickX2", qui est de type float.
     */
    public float getJoystickX2() {
        return joystickX2;
    }

    /**
     * La fonction renvoie la valeur de la variable joystickY2.
     * 
     * @return La méthode renvoie la valeur de la variable "joystickY2", qui est de type float.
     */
    public float getJoystickY2() {
        return joystickY2;
    }

   /**
    * La fonction renvoie un tableau de booléens appelés « boutons ».
    * 
    * @return Un tableau de booléens est renvoyé.
    */
    public boolean[] getBoutons() {
        return boutons;
    }
}