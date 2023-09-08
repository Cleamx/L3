
def somme_un(L):
    resultat = 0
    for i in range(len(L)):
        resultat += L[i]
    print(resultat)
    return resultat

def somme_deux(L):
    resultatDeux = 0
    for i in L:
        resultatDeux += i
    print(resultatDeux)

def somme_trois(L):
    resultat_trois = 0
    i = 0

    while i != len(L):
        resultat_trois += L[i]
        i += 1
    print(resultat_trois)

def moyenne(L):
    if L != []:
        i = 0
        resultat_moyenne = 0
        while i != len(L):
            resultat_moyenne = (resultat_moyenne + L[i]) / len(L)
            i += 1
    else:
        resultat_moyenne = 0
    print(resultat_moyenne)


def test_exercice_un():

    print("TEST SOMME")
    print("Test liste vide : ",)
    liste_test = []
    somme_un(liste_test)
    somme_deux(liste_test)
    somme_trois(liste_test)
    moyenne(liste_test)

    print("TEST LISTE 11111")
    liste_test_deux = [1,10,100, 1000,10000]
    somme_un(liste_test_deux)
    somme_deux(liste_test_deux)
    somme_trois(liste_test_deux)
    moyenne(liste_test_deux)

test_exercice_un()