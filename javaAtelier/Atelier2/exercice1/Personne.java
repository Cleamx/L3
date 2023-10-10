package Atelier2.exercice1;

import java.util.*;

public class Personne {
	private static final Adresse ADRESSE_INCONNUE = null;
	private String nom;
	private String prenom;
	private final GregorianCalendar dateNaissance;
	private Adresse adresse = ADRESSE_INCONNUE;
	private static int nombrePersonne = 0;

	/**
	 * Constructeur de Personne
	 * 
	 * @param leNom    le nom de la personne
	 * @param lePrenom le pr�nom de la personne
	 * @param laDate   la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 */
	public Personne(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse) {
		nom = leNom.toUpperCase();
		prenom = lePrenom;
		dateNaissance = laDate;
		adresse = lAdresse;
		nombrePersonne++;
	}

	/**
	 * Constructeur de Personne
	 * 
	 * @param leNom       le nom de la personne
	 * @param lePrenom    le pr�nom de la personne
	 * @param j           le jour de naissance
	 * @param m           le mois de naissance
	 * @param a           l'ann�e de naissance
	 * @param numero      le n� de la rue
	 * @param rue         la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville       la ville ou la personne habite
	 */
	public Personne(String leNom, String lePrenom, int j, int m, int a, int numero, String rue, String code_postal,
			String ville) {
		this(leNom, lePrenom, new GregorianCalendar(a, m, j), new Adresse(numero, rue, code_postal, ville));
	}

	/**
	 * Accesseur
	 * 
	 * @return retourne le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Accesseur
	 * 
	 * @return retourne le pr�nom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Accesseur
	 * 
	 * @return retourne la date de naissance
	 */
	public GregorianCalendar getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Accesseur
	 * 
	 * @return retourne l'adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Modificateur
	 * 
	 * @param retourne l'adresse
	 */
	public void setAdresse(Adresse a) {
		adresse = a;
	}

	public String toString() {
		String result = "\nNom : " + nom + "\n"
				+ "Prénom : " + prenom + "\n" +
				"Né(e) le : " + dateNaissance.get(Calendar.DAY_OF_MONTH) +
				"-" + dateNaissance.get(Calendar.MONTH) +
				"-" + dateNaissance.get(Calendar.YEAR) + "\n" +
				"Adresse : " +
				adresse.toString();
		return result;
	}

	/**
	 * La fonction renvoie la valeur de la variable "nombrePersonne".
	 * 
	 * @return La méthode renvoie la valeur de la variable "nombrePersonne".
	 */
	public int getNombrePersonne() {
		return nombrePersonne;
	}

	/**
	 * La fonction compare les dates de naissance de deux objets Personne et renvoie
	 * vrai si la première
	 * personne est plus âgée que la deuxième personne, et faux dans le cas
	 * contraire.
	 * 
	 * @param pPersonne Le paramètre pPersonne est de type Personne, qui est une
	 *                  classe représentant une
	 *                  personne.
	 * @return La méthode renvoie une valeur booléenne.
	 */
	public boolean plusAgee(Personne pPersonne) {
		boolean resfinal = false;
		int res = this.dateNaissance.compareTo(pPersonne.dateNaissance);

		if (res == 0) {
			resfinal = true;
		} else if (res == 1) {
			resfinal = false;
		}

		else if (res == -1) {
			resfinal = true;
			;
		}
		System.out.println(affichagePlusAgee(pPersonne, resfinal));
		return resfinal;
	}

	public String affichagePlusAgee(Personne personne, boolean resPlusAgee) {
		String affichageRes = this.prenom + " est moins agée que " + personne.prenom;
		if (resPlusAgee == true) {
			affichageRes = this.prenom + " est plus agée que " + personne.prenom;
		}
		return affichageRes;
	}

	/**
	 * La fonction vérifie si deux objets Personne sont égaux en comparant leurs
	 * attributs nom, prenom et
	 * dateNaissance.
	 * 
	 * @param obj Le paramètre "obj" est un objet de type Object, qui est la
	 *            superclasse de toutes les
	 *            classes en Java. Il est utilisé pour comparer l'objet actuel avec
	 *            un autre objet pour vérifier
	 *            s'ils sont égaux.
	 * @return La méthode renvoie une valeur booléenne.
	 */
	public boolean equals(Object obj) {
		boolean result = false;
		if ((obj != null) && (obj instanceof Personne)) {
			Personne other = (Personne) obj;
			result = (this.nom.equals(other.nom)) && (this.prenom.equals(other.prenom))
					&& (this.dateNaissance.equals(other.dateNaissance));
		}
		return result;
	}

}
