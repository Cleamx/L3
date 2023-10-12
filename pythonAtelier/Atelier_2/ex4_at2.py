import matplotlib.pyplot as plt

def histo(F: list) -> list:
    """liste d'entiers H représentant l'histogramme de F

    Args:
        F (list): liste d'entier

    Returns:
        list: liste d'entiers H représentant l'histogramme de F
    """
    MAX_VALEUR = max(F)

    H = [0] * (MAX_VALEUR + 1)

    for i in F:
        H[i] += 1
    return H

def est_injective(F: list)->bool:
    """retourne True ou False si la liste F est une injection

    Args:
        F (list): liste d'entier

    Returns:
        bool: True si la liste F est une injection, sinon False
    """
    H = histo(F)
    injective = False

    if all(valeur <= 1 for valeur in H):
        injective = True
    return injective

def est_surjective(F:list) -> list:
    """retourne True ou False si la liste F est surjective

    Args:
        F (list): liste d'entier

    Returns:
        list: True ou Flase si la liste est surjective ou non
    """
    H = histo(F)
    surjective = False

    if all(valeur >= 1 for valeur in H):
        surjective = True
    return surjective

def est_bijective(F:list) -> bool:
    """retourne True ou False si la liste F est bijective

    Args:
        F (list): liste d'entier

    Returns:
        bool: retourne True ou False si la liste F est surjective
    """
    bijective = False

    if est_bijective(F) and est_injective(F) == True:
        bijective = True
    return bijective

def AffichageHisto(F:list)->str:
    """Affichage de l'histogramme sur terminal et matplotlib

    Args:
        F (list): liste d'entier

    Returns:
        str: affichage terminal
    """
    H = histo(F)
    MAXOCC = max(H)
    lignes = ""

    for i in range(MAXOCC, 0, -1):
        line =""
        for j in range(len(H)):
            valeur = H[j]
            if valeur >= i:
                line += "   #|"
            elif valeur <= i:
                line += "   -|"
        print(line)

    for num in range(len(H)):
        if num < 10:
            lignes += "  "
            lignes += str(num)
            lignes += "  "
        else:
            lignes += " "
            lignes += str(num)
            lignes += "  "

    print(lignes)
    plt.hist(F, range = (min(F), max(F)), bins = max(F), color = 'blue',
            edgecolor = 'black')
    plt.xlabel('nombres')
    plt.ylabel('occurence dans la liste')
    plt.show()

print(AffichageHisto([1,1,2,4,5,6,6,4,6,7,8,9,9,10,11,11,12,13,14,15]))