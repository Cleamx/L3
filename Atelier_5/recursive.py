
def somme_recursive(liste:list)->int:
    """fonction qui calcul la somme d'une liste grâce à la récursivité

    Args:
        liste (list): liste

    Returns:
        int: somme
    """
    
    if liste == []:
        return 0
    else:
        return liste[0] + somme_recursive(liste[1:])


def factorielle_recursive(nombre:int) -> int:
    """fonction qui calcul la factorielle de nombre grâce à la récursivité

    Args:
        nombre (int): nombre

    Returns:
        int: factorielle
    """

    if nombre == 0:
        return 1
    else:
        return factorielle_recursive(nombre-1)*nombre

def longueur(lst:list)->int:
    """fonciton qui retourne la taille de la liste

    Args:
        lst (list): liste

    Returns:
        int: taille de la liste
    """
    if lst == []:
        return 0
    else:
        return 1 + longueur(lst[1:])

def findMin(lst:list)->int:
    """fonction qui retourne le minimum d'une liste en utilisant la recursivité

    Args:
        lst (list): liste

    Returns:
        int: minimum
    """
    minNumber = 0
    if len(lst) == 1:
        minNumber =  lst[0]
    elif len(lst) == 0:
        minNumber = None
    else:
        
        if lst[0] < minNumber:
            minNumber = lst[0]
        else:
            minNumber = findMin(lst[1:])
    return minNumber

def ListPairs(lst : list)->list:
    """fonction qui retourne les éléments paires dans une liste en utilisant la recursivité
    

    Args:
        lst (list): liste

    Returns:
        list: liste d'éléments paires
    """
    if len(lst) == 0:
        return []
    elif len(lst) == 1:
        if lst[0] % 2 == 0:
            return lst
        else:
            return []
    else:
        paires = ListPairs(lst[1:])
        if lst[0] % 2 == 0:
            return [lst[0]] + paires
        else:
            return paires

def concat_lst(lst : list)->list:
    """fonction qui permet de concaténer plusieurs listes

    Args:
        lst (list): liste de listes

    Returns:
        list: listes
    """
    if lst == []:
        return []
    else:
        return lst[0] + concat_lst(lst[1:])

def separe(lst)->tuple:
    """fonction qui sépare une liste en deux et qui renvoie un tuple de liste avec une liste paire et une impaire

    Args:
        lst (_type_): liste

    Returns:
        tuple: tuple de liste avec une liste paire et une impaire
    """
    if len(lst) == 0:
        return [], []
    
    pairs, impairs = separe(lst[1:])
    
    if lst[0] % 2 == 0:
        return [lst[0]] + pairs, impairs
    else:
        return pairs, [lst[0]] + impairs


def test():
    lst_test = [1, 2, 3, 4]

    # Test de somme_recursive
    print("Test de somme_recursive:")
    print("Somme de", lst_test, ":", somme_recursive(lst_test))
    print("---------------------------")

    # Test de factorielle_recursive
    n = 5
    print("Test de factorielle_recursive:")
    print(f"Factorielle de {n} :", factorielle_recursive(n))
    print("---------------------------")

    # Test de longueur
    print("Test de longueur:")
    print("Longueur de", lst_test, ":", longueur(lst_test))
    print("---------------------------")

    # Test de findMin
    print("Test de findMin:")
    print("Minimum de", lst_test, ":", findMin(lst_test))
    print("---------------------------")

    # Test de ListPairs
    print("Test de ListPairs:")
    print("Éléments pairs de", lst_test, ":", ListPairs(lst_test))
    print("---------------------------")

    # Test de concat_lst
    lst_of_lists = [[0, 1], [2, 3], [4], [5, 6]]
    print("Test de concat_lst:")
    print("Concaténation de listes :", concat_lst(lst_of_lists))
    print("---------------------------")

    # Test de separe
    print("Test de separe:")
    paire, impaire = separe(lst_test)
    print("Liste des éléments pairs :", paire)
    print("Liste des éléments impairs :", impaire)
    print("---------------------------")

# Appeler la fonction de test
test()