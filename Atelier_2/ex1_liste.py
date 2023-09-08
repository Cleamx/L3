
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

def test():
    liste_test = [2, 13, 15, 10]
    somme_un(liste_test)
    somme_deux(liste_test)

test()