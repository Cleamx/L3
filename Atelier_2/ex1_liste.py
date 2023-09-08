
def somme_un(L: list) -> int: 
    """Somme avec for i in range

    Args:
        L (list): liste de nombre

    Returns:
        int: somme de la liste
    """
    resultat = 0
    for i in range(len(L)):
        resultat += L[i]
    return resultat

def somme_deux(L: list) -> int:
    """Somme avec for i in L

    Args:
        L (list): liste de nombre

    Returns:
        int: somme de la liste
    """
    resultatDeux = 0
    for i in L:
        resultatDeux += i
    return resultatDeux

def somme_trois(L: list) ->int:
    """Somme avec while

    Args:
        L (list): liste de nombre

    Returns:
        int: somme de la liste
    """
    resultat_trois = 0
    i = 0
    tailleL = len(L)
    while i != tailleL:
        resultat_trois += L[i]
        i += 1
    return resultat_trois

def moyenne(L: list) ->float:
    """Donne la moyenne des entiers de la liste

    Args:
        L (list): liste de nombre

    Returns:
        float: moyenne calculé
    """
    if L != []:
        taille_liste = len(L)
        resultat_moyenne = somme_deux(L)/taille_liste
    else:
        resultat_moyenne = 0
    return resultat_moyenne

def nb_sup(L: list, e:int) -> int:
    """test quel nombre est plus grand que e dans la liste L

    Args:
        L (list): liste de nombre
        e (int): entier

    Returns:
        int: nombre plus grand que e 
    """

    tailleListe = len(L)
    nombreSup = 0
    for i in range (tailleListe):
        if e < L[i]:
            nombreSup += 1
    return nombreSup

def nb_sup_deux(L: list, e:int) -> int:
    """test quel nombre est plus grand que e dans la liste L

    Args:
        L (list): liste de nombre
        e (int): entier

    Returns:
        int: nombre plus grand que e 
    """
    nombreSup = 0
    for i in L:
        if e < i:
            nombreSup += 1
    
    return nombreSup

def moyenne_sup(L:list, e:int) ->float:
    """Moyenne de tout les nombres supérieurs à e dans la liste

    Args:
        L (list): liste de nombre
        e (int): entier

    Returns:
        float: moyenne des nombres supérieurs
    """
    listeNbSup = []
    res = 0
    for i in L:
        if e < i:
            listeNbSup.append(i)
        res = moyenne(listeNbSup)
    return res

def val_max(L : list) -> float:
    valeurMax = 0
    for i in range(len(L)):
        if valeurMax < L[i]:
            valeurMax = L[i]
    return valeurMax

def ind_max(L:list) -> int:
    ind_max = 0
    for i in range(len(L)):
        if ind_max < i:
            ind_max = i
    return ind_max


def test_exercice_un():

    print("TEST SOMME")
    liste_test = []
    print("Test liste vide : ", somme_un(liste_test), somme_deux(liste_test), somme_trois(liste_test))
    print("Test moyenne : ", moyenne(liste_test))
    print("Test nombre sup : ", nb_sup(liste_test, 45), nb_sup_deux(liste_test, 45))
    print("Test moyenne nombre Sup : ", moyenne_sup(liste_test, 34))
    print("Test valeur max : ", val_max(liste_test))
    print("Test index max : ", ind_max(liste_test))
    
    liste_test_deux = [1,10,100, 1000,10000]
    print("Test somme 11111 : ", somme_un(liste_test_deux), somme_deux(liste_test_deux), somme_trois(liste_test_deux))
    print("Test moyenne : ", moyenne(liste_test_deux))
    print("Test nombre sup : ", nb_sup(liste_test_deux, 45), nb_sup_deux(liste_test_deux, 45))
    print("Test moyenne nombre Sup : ", moyenne_sup(liste_test_deux, 34))
    print("Test valeur max : ", val_max(liste_test_deux))
    print("Test index max : ", ind_max(liste_test_deux))

    

test_exercice_un()