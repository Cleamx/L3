package TD2;

import java.util.ArrayList;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * La classe Entity2D est une classe Java qui représente une entité bidimensionnelle avec des
 * propriétés telles que l'identifiant, le nom, les coordonnées et une liste d'éléments.
 */
public class Entity2D implements Externalizable { 
    private static final long serialVersionUID = 1L; 
    public static final int MAX_ITEMS = 10;
    public static int nb_generated = 0;
    private int id;
    private String name;
    private float x;
    private float y; ArrayList<Integer> items ;

    // Le constructeur `public Entity2D(String name, float x, float y)` initialise une nouvelle
    // instance de la classe `Entity2D` avec les valeurs `name`, `x` et `y` fournies.
    public Entity2D(String name, float x, float y){
        this.name = name;
        this.x=x;
        this.y=y;
        this.id = nb_generated; 
        nb_generated++;
        items = new ArrayList<Integer >() ;
    }

    // Le `public Entity2D() {}` est un constructeur par défaut pour la classe `Entity2D`. C'est un
    // constructeur vide qui ne prend aucun paramètre. Ce constructeur est utilisé pour créer une
    // instance de la classe `Entity2D` sans initialiser aucun de ses champs.
    public Entity2D() {
    }

    
    /**
     * La fonction renvoie la valeur de la variable id.
     * 
     * @return La méthode renvoie la valeur de la variable "id".
     */
    public int getId() {
        return id;
    }

    /**
     * La fonction définit la valeur de la variable "id".
     * 
     * @param id Le paramètre "id" est un entier qui représente l'identifiant unique d'un objet.
     */
    public void setId(int id) {
        this.id = id;
    }

   
   /**
    * La fonction getName() renvoie le nom d'un objet.
    * 
    * @return La méthode renvoie la valeur de la variable "name".
    */
    public String getName() {
        return name;
    }

    /**
     * La fonction définit le nom d'un objet.
     * 
     * @param name Le paramètre « nom » est un paramètre de type String.
     */
    public void setName(String name) {
        this.name = name;
    }

    
   /**
    * La fonction getX() renvoie la valeur de la variable x.
    * 
    * @return La méthode renvoie la valeur de la variable "x" sous forme de flottant.
    */
    public float getX() {
        return x;
    }

    /**
     * La fonction définit la valeur de la variable "x" sur la valeur flottante donnée.
     * 
     * @param x Le paramètre "x" est une variable de type float.
     */
    public void setX(float x) {
        this.x = x;
    }

    
    /**
     * La fonction renvoie la valeur de la variable "y" sous forme de flottant.
     * 
     * @return La méthode renvoie la valeur de la variable "y" sous forme de flottant.
     */
    public float getY() {
        return y;
    }

    /**
     * La fonction définit la valeur de la variable "y" sur la valeur flottante donnée.
     * 
     * @param y Le paramètre « y » est une valeur flottante qui représente la coordonnée y d'un point
     * ou d'une position.
     */
    public void setY(float y) {
        this.y = y;
    }


    /**
     * La fonction renvoie une ArrayList d'entiers.
     * 
     * @return Une ArrayList d’entiers est renvoyée.
     */
    public ArrayList<Integer> getItems() {
        return items;
    }

   /**
    * La fonction toString() renvoie une représentation sous forme de chaîne d'un objet Entity2D, y
    * compris son identifiant, son nom, ses coordonnées x et y et ses éléments.
    * 
    * @return La méthode toString() renvoie une représentation sous forme de chaîne d'un objet
    * Entity2D. La chaîne renvoyée inclut les valeurs des propriétés id, name, x, y et items de
    * l'objet.
    */
    @Override
    public String toString() {
        return "Entity2D [id=" + id + ", name=" + name + ", x=" + x + ", y=" + y + ", items=" + items + "]";
    }

    /**
     * La fonction writeObject écrit l'objet dans un ObjectOutputStream.
     * 
     * @param out Le paramètre « out » est une instance de la classe ObjectOutputStream, utilisée pour
     * écrire des objets dans un flux de sortie. Dans cet extrait de code, la méthode « writeObject »
     * est remplacée pour personnaliser le processus de sérialisation de l'objet en cours d'écriture.
     * La ligne "out.defaultWriteObject()" appelle le
     */
    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
    }

   /**
    * La fonction lit un objet à partir d'un ObjectInputStream et exécute le processus de
    * désérialisation par défaut.
    * 
    * @param in Le paramètre "in" est une instance de la classe ObjectInputStream, utilisée pour lire
    * des objets à partir d'un flux d'entrée.
    */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
    }

    
    /**
     * La fonction "putItem" ajoute un élément à une liste si la taille de la liste est inférieure ou
     * égale à une limite maximale.
     * 
     * @param itm Le paramètre "itm" est un entier représentant l'élément qui doit être ajouté à la
     * liste.
     */
    public void putItem(int itm){
        int taille_liste = items.size();

        if (taille_liste <= MAX_ITEMS) {
            items.add(itm);
        }
    }

   /**
    * La fonction writeExternal écrit les valeurs de l'identifiant, du nom, de x, de y et des éléments
    * dans un flux ObjectOutput.
    * 
    * @param out Le paramètre « out » est une instance de la classe ObjectOutput, utilisée pour écrire
    * des objets dans un flux de sortie. Dans ce cas, il est utilisé pour écrire les valeurs des
    * variables id, name, x, y et items dans le flux de sortie.
    */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException{
        out.writeInt(id);
        out.writeObject(name);
        out.writeFloat(x);
        out.writeFloat(y);
        out.writeObject(items);
    }

   /**
    * La fonction readExternal lit les données d'un flux ObjectInput et attribue les valeurs aux
    * variables correspondantes.
    * 
    * @param in Le paramètre "in" est un objet ObjectInput, utilisé pour lire des données à partir
    * d'une source externe. Dans ce cas, il est utilisé pour lire les données d’un flux d’entrée
    * externe.
    */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        id = in.readInt();
        name = (String) in.readObject();
        x = in.readFloat();
        y = in.readFloat();
        items = (ArrayList <Integer>) in.readObject();
    }

    
   /**
    * La fonction écrit l'identifiant, le nom, les coordonnées x et y et une liste d'éléments dans un
    * DataOutputStream dans un format spécifique.
    * 
    * @param data Le paramètre "data" est de type DataOutputStream. Il est utilisé pour écrire des
    * données dans un flux de sortie.
    */
    public void toBytes(DataOutputStream data) throws IOException {
        data.writeShort(id);
        data.writeUTF(name);
        data.writeFloat(x);
        data.writeFloat(y);
        data.writeShort(items.size()); 
        for (int item : items) {
            data.writeInt(item);
        }
    }

    /**
     * La fonction lit les données d'un DataInputStream et crée un objet Entity2D avec les valeurs
     * lues.
     * 
     * @param data Le paramètre "data" est un objet DataInputStream utilisé pour lire les données d'un
     * flux. On suppose que le flux contient les données nécessaires pour remplir les champs de l'objet
     * Entity2D.
     * @return La méthode renvoie une instance de la classe Entity2D.
     */
    public static Entity2D fromBytes(DataInputStream data) throws IOException {
        Entity2D entity = new Entity2D();
        entity.id = data.readShort();
        entity.name = data.readUTF();
        entity.x = data.readFloat();
        entity.y = data.readFloat();
        int itemCount = data.readShort(); 
        entity.items = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            entity.items.add(data.readInt());
        }
        return entity;
    }
}   
