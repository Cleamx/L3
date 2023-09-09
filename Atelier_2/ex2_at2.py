def position(lst: list, elt: int) -> int:
    """donne l'indice du nombre chercher dans la liste

    Args:
        lst (list): liste d'entier
        elt (int): entier

    Returns:
        int: l'indice du nombre chercher dans la liste ou -1 si le nombre n'est pas dans la liste
    """
    indice_elt = 0
    for indice_elt in range(len(lst)):
        if lst[indice_elt] == elt:
            return  indice_elt
    return -1
        

def position_deux(lst: list, elt: int) -> int:
    """donne l'indice du nombre chercher dans la liste

    Args:
        lst (list): liste d'entier
        elt (int): entier

    Returns:
        int: l'indice du nombre chercher dans la liste ou -1 si le nombre n'est pas dans la liste
    """
    i = 0
    while i < len(lst):
        if lst[i] == elt:
            return i
        i += 1
    return -1

def nb_occurrences(lst : list, e: int) -> int :
    """Donne le nombre de fois que le nombre e est dans la liste

    Args:
        lst (list): liste d'entier
        e (int): entier

    Returns:
        int: nombre d'occurences du nombre e dans la liste
    """
    occurences = 0
    i = 0
    while i < len(lst):
        if lst[i] == e:
            occurences += 1
        i += 1
    return occurences

def est_triee(lst : list) ->bool:
    """retourne si la liste est triée ou non

    Args:
        lst (list): liste

    Returns:
        bool: true si liste triée, false si pas triée
    """
    i = 0
    trie = True
    for i in range(len(lst) - 1):
        if lst[i] < lst[i+1]:
            trie = True
        else:
            trie = False
    return trie
            

def est_triee_deux(lst: list) ->bool:
    """retourne si la liste est triée ou non

    Args:
        lst (list): liste

    Returns:
        bool: true si liste triée, false si pas triée
    """
    i = 0
    trie = False

    while i < len(lst) - 1:
        if lst[i] > lst[i+1]:
            trie = False
        else:
            trie = True
        i+=1
    return trie

def a_repetitions(lst:list) -> bool:
    """retourne True si il y a une répétition, sinon False

    Args:
        lst (list): liste d'entier

    Returns:
        bool: True si il y a une répétition, sinon False
    """
    T = []
    i = 0
    rep = False
    while i < len(lst):
        if lst[i] not in T:
            T.append(lst[i])
        else:
            rep = True
        i += 1
    return rep

print(a_repetitions([4,5,1]))