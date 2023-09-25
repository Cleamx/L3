import numpy as np

arr = np.random.randint(10, size=(4, 4))
I = np.identity(4)

def matrice_trace(matrice : object)->int:
    """fonction qui calcul la trace d'une matrice 

    Args:
        matrice (object): matrice

    Returns:
        int: resultat de la trace
    """
    
    res = 0

    for i in range(len(matrice)):
        res += matrice[i][i]
    return res

def est_symetrique(matrice:object)->bool:
    """fonction qui vérifie si la matrice est symétrique ou non et renvoie un booléen

    Args:
        matrice (object): matrice

    Returns:
        bool: True si matrice symétrique sinon False
    """
    
    taille_matrice = len(matrice)
    res = True

    if taille_matrice != len(matrice[0]):
        res =  False

    for L in range(taille_matrice):
        for col in range(L + 1, taille_matrice):
            if matrice[L][col] != matrice[col][L]:
                res = False
    return res

def produit_diagonal(matrice : object)->int:
    """calcul le produit de la diagonal principale d'une matrice

    Args:
        matrice (object): matrice

    Returns:
        int: resultat de la multiplication de la diagonal
    """
    res = 1

    for i in range(len(matrice)):
        res *= matrice[i][i]
    return res

def test():
    res_trace = matrice_trace(arr)
    print("\nLa trace de la matrice: \n",arr," est ", res_trace )

    matrice_test = (arr + arr * res_trace)//2
    res1 = est_symetrique(matrice_test)
    
    if res1:
        print("\nLa matrice est symétrique")
    else:
        print("\nLa matrice n'est pas symétrique")
    

test()