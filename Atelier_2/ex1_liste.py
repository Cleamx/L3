
def somme_un(L: list) -> int: 
    resultat = 0
    for i in range(len(L)):
        resultat += L[i]
    return resultat

def somme_deux(L: list) -> int:
    resultatDeux = 0
    for i in L:
        resultatDeux += i
    return resultatDeux

def somme_trois(L: list) ->int:
    resultat_trois = 0
    i = 0
    tailleL = len(L)
    while i != tailleL:
        resultat_trois += L[i]
        i += 1
    return resultat_trois

def moyenne(L: list) ->int:
    if L != []:
        taille_liste = len(L)
        resultat_moyenne = somme_deux(L)/taille_liste
    else:
        resultat_moyenne = 0
    return resultat_moyenne

def nb_sup(L: list, e:int) -> int:
    tailleListe = len(L)
    nombreSup = 0
    for i in range (tailleListe):
        if e < L[i]:
            nombreSup += 1
    return nombreSup

def nb_sup_deux(L: list, e:int) -> int:
    nombreSup = 0
    for i in L:
        if e < i:
            nombreSup += 1
            print(i)
    return nombreSup

def test_exercice_un():

    print("TEST SOMME")
    liste_test = []
    print("Test liste vide : ", somme_un(liste_test), somme_deux(liste_test), somme_trois(liste_test))
    print("Test moyenne : ", moyenne(liste_test))
    print("Test nombre sup : ", nb_sup(liste_test, 45), nb_sup_deux(liste_test, 45))
    
    liste_test_deux = [1,10,100, 1000,10000]
    print("Test somme 11111 : ", somme_un(liste_test_deux), somme_deux(liste_test_deux), somme_trois(liste_test_deux))
    print("Test moyenne : ", moyenne(liste_test_deux))
    print("Test nombre sup : ", nb_sup(liste_test_deux, 45), nb_sup_deux(liste_test_deux, 45))

    

test_exercice_un()