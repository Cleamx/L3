import numpy as np

def matriceAdjacence(S: list, A: list)->object:
    """fonction qui retourne la matrice d’adjacence associée

    Args:
        S (list): liste des sommets
        A (list): liste dess arces

    Returns:
        object: matrice d’adjacence associée
    """
    taille_S = (len(S),len(S))
    matrice = np.zeros(taille_S)
    
    for i in range(len(A)):
        a,b = A[i]
        matrice[a][b] = 1
    return matrice

def matriceAdjacencePond(S: list, A: list)->object:
    """fonction qui retourne la matrice d’adjacence 

    Args:
        S (list): liste de sommets
        A (list): d’arcs pondérés

    Returns:
        object: matrice adjacence associée
    """
    a = b = c = 0
    taille_S = (len(S),len(S))
    matrice = np.zeros(taille_S)
    
    for i in range(len(A)):
        a,b,c = A[i]
        matrice[a][b] = c
    return matrice

def lireMatriceFichier(nomfichier)->object:
    """fonction qui lit dans un fichier une matrice et qui crée une matrice avec numpy à partir du fichier

    Args:
        nomfichier (file): nom du fichier

    Returns:
        object: matrice
    """
    try:
        with open(nomfichier, 'r') as fichier:
            lignes = fichier.readlines()
        
        lignes_matrice = [ligne.strip().split() for ligne in lignes]
        matrice_np = np.array([list(map(float, ligne)) for ligne in lignes_matrice])
        
        if matrice_np.shape[0] == matrice_np.shape[1]:
            return matrice_np
        else:
            raise ValueError("La matrice n'est pas carrée.")
    
    except FileNotFoundError:
        raise FileNotFoundError("Le fichier n'existe pas.")

def tousLesSommets(mat: object)->list:
    """fonction qui retourne la liste des sommets d'une matrice

    Args:
        mat (object): matrice

    Returns:
        list: liste des sommets
    """
    resSommet = []
    i = 0
    while i < len(mat):
        resSommet.append(i)
        i+=1
    return resSommet

def listeArcs(mat:object)->list:
    """fonction qui retourne la liste de tuples des arcs de la matrice

    Args:
        mat (object): matrice

    Returns:
        list: liste de tuples des arcs
    """

    resArcs = []
    tailleMat = len(mat)
    
    for lignes in range(tailleMat):
        for colonne in range(tailleMat):
            if mat[lignes][colonne] == (1.0):
                resArcs.append((lignes,colonne))
    return resArcs


def test():
    lst_sommet = [0, 1, 2, 3, 4]
    lst_arc = [(0, 1), (0, 2), (1, 2), (1, 4), (2, 3), (3, 4), (4, 2)]

    # Test de matriceAdjacence
    res = matriceAdjacence(lst_sommet, lst_arc)
    print("Matrice d'adjacence :")
    print(res)
    print("---------------------------")

    lst_arc_pond = [(0, 1, 3), (0, 2, 5), (1, 2, 4), (1, 4, 1), (2, 3, 9), (3, 4, 8), (4, 2, 7)]

    # Test de matriceAdjacencePond (décommentez la ligne suivante)
    resPond = matriceAdjacencePond(lst_sommet, lst_arc_pond)
    print("\nMatrice d'adjacence pondérée :\n")
    print(resPond)
    print("---------------------------")

    nomFichier = "./Atelier_5/graphe/graph0.txt"

    # Test de lireMatriceFichier (décommentez la ligne suivante)
    resFichier = lireMatriceFichier(nomFichier)
    print("\nLa matrice inscrite dans le fichier est :\n")
    print(resFichier)
    print("---------------------------")

    # Test de tousLesSommets
    resSommet = tousLesSommets(res)
    print("\nLes sommets de la matrice sont : ", resSommet)
    print("---------------------------")

    # Test de listeArcs
    resArcs = listeArcs(res)
    print("\nLes arcs de la matrice sont : ", resArcs)
    print("---------------------------")

test()