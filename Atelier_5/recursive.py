lst_test = [1,2,3,4]


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
    

print(somme_recursive(lst_test))

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

print(factorielle_recursive(5))

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

print(longueur(lst_test))

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

print(findMin(lst_test))

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
        lst1 = ListPairs(lst[1:])
        if lst[0] % 2 == 0:
            return [lst[0]] + lst1
        else:
            return lst1

print(ListPairs(lst_test))

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
    
print(concat_lst([[0,1],[2,3],[4],[5,6]]))