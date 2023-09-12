import collections

def test_valeurs(L:list):
    c = collections.Counter(L)
    listC = list(c.values())

    if all(j <= 2 for j in listC):
        repetition = True
    else:
        repetition = False
        
    return repetition

def vitrines(nbEmplacements:int, lObjet:list)->list:
    
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