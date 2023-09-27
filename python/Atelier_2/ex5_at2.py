import collections

def test_valeurs(L:list)->bool:
    """compte le nombre d'occurences dans une liste True si le nombre est inférieur ou égale à deux

    Args:
        L (list): list d'entier

    Returns:
        bool: retourne True si la condition est validé sinon False
    """
    c = collections.Counter(L)
    listC = list(c.values())

    if all(j <= 2 for j in listC):
        repetition = True
    else:
        repetition = False
        
    return repetition

def vitrines(nbEmplacements:int, lObjet:list)->list:
    """affiche les nombres en vitrines 

    Args:
        nbEmplacements (int): nombre d'emplacements
        lObjet (list): liste d'entier

    Returns:
        list: affiche tous les objets en vitrines et les vitrines n'ont pas deux objets identiques
    """
    
    vitrineUn = []
    vitrineDeux = []

    if test_valeurs(lObjet) == True:
        if len(lObjet) < (nbEmplacements * 2):
            for i in range(len(lObjet)):
                if len(vitrineUn) <= len(vitrineDeux) and len(vitrineUn) < nbEmplacements and lObjet[i] not in vitrineUn :
                    vitrineUn.append(lObjet[i])
                elif lObjet[i] not in vitrineDeux:
                    vitrineDeux.append(lObjet[i])
            print(vitrineUn, vitrineDeux)

        else:
            print("Erreur, toutes les valeurs ne peuvent être afficher, le nombres d'emplacements est trop petit")
    else:
        print("Erreur, un nombre est répété plus de deux fois, les valeurs ne peuvent être toutes affichées")

    
def main():

    lObjets = [1, 2, 2, 3, 4, 5, 5, 4, 6]
    vitrines(5,lObjets)

main()