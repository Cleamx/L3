import numpy as np

def matriceAdjacence(S: list, A: list)->object:
    """fonction qui retourne la matrice d’adjacence associée

    Args:
        S (list): liste des sommets
        A (list): liste dess arces

    Returns:
        object: matrice d’adjacence associée
    """
    a = b = 0
    taille_S = (len(S),len(S))
    matrice = np.zeros(taille_S)
    
    for i in range(len(A)):
        a,b = A[i]
        matrice[a][b] = 1
    return matrice


lst_sommet = [0,1,2,3,4]
lst_arc = [(0,1),(0,2),(1,2), (1,4), (2,3), (3,4), (4,2)]
res = matriceAdjacence(lst_sommet, lst_arc)
print(res)

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

lst_arc_pond = [(0,1,3),(0,2,5),(1,2,4), (1,4,1), (2,3,9), (3,4,8), (4,2,7)]
resPond = matriceAdjacencePond(lst_sommet, lst_arc_pond)
print(resPond)