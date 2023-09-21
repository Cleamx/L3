def somme_recursive(liste:list)->list:
    """fonction qui calcul la somme d'une liste grâce à la récursivité

    Args:
        liste (list): liste

    Returns:
        list: somme
    """
    
    if len(liste) == 1:
        return liste[0]
    else:
        return liste[0] + somme_recursive(liste[1:])
    

print(somme_recursive([1,2,3,4]))

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