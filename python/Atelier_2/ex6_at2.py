def est_present(L: list, e: int) -> bool:
    """fonction qui teste si l'élément e est dans la liste et retourne True si oui, sinon False

    Args:
        L (list): liste d'entier
        e (int): entier recherché

    Returns:
        bool: True si élément e trouver dans la liste, sinon False
    """

    if e in L:
        nbPresent = True
    else:
        nbPresent = False
    return nbPresent

def present1 (L:list, e:int)->bool:
    for i in range (0, len(L), 1) : 
        if (L[i] == e) :
            return True
        else:
            return False
    return False

#return qu'une fois que la boucle est finit, à cause des return dans la boucle de present1
#la boucle ne pouvait pas chercher dans toute la liste
def present1_corrige (L:list, e:int)->bool:
    rep = False 
    for i in range(0, len(L), 1): 
        if L[i] == e :
            rep = True
    return rep

def present2 (L:list, e:int)->bool:
    b=True
    for i in range (0, len(L), 1) :
        if (L[i] == e) : 
            b=True
        else :
            b=False
    return (b)

def present2_corrige(L:list, e:int)->bool:
    b = False
    for i in range (0, len(L), 1) :
        if (L[i] == e) : 
            b=True
    return (b)

def present3 (L,e):
    b=True
    for i in range (0, len(L), 1) :
        return (L[i] == e)

def present3_corrige (L, e) :
    b=False
    for i in range (0, len(L), 1) :
        if L[i] == e:
            b = True
    return b
    
def present4 (L, e) :
    b=False
    i=0
    while (i<len(L) and b) :
        if (L[i] == e) : 
            b=True
    return (b)

def present4_corrige (L, e) :
    b=False
    i=0
    while (i<len(L) and not b) :
        if (L[i] == e) : 
            b=True
        i+=1
    return (b)

def test_present(present):

    if present([], 2):
        print("ECHEC : test liste vide")
    else:
        print("SUCCES : test liste vide")

    liste_test = [1,2,3,4,5,6,7,8,9,10]

    if present(liste_test,1):
        print("SUCCES : test debut")
    else:
        print("ECHEC : test debut")

    if present(liste_test,10):
        print("SUCCES : test fin")
    else:
        print("ECHEC : test fin")

    if present(liste_test,5):
        print("SUCCES : test milieu")
    else:
        print("ECHEC : test milieu")
    
    if not present(liste_test,-1):
        print("SUCCES : test abscent")
    else:
        print("ECHEC : test absent")
    
"""print("TEST PRESENT")      
test_present(est_present)
print("\nTEST PRESENT1")
test_present(present1)
print("\nTEST PRESENT2")
test_present(present2)
print("\nTEST PRESENT3")
test_present(present3)
print("TEST PRESENT4")
test_present(present4)
print("\nTEST PRESENT 1 CORRIGE")
test_present(present1_corrige)
print("\nTEST PRESENT 2 CORRIGE")
test_present(present2_corrige
print("\nTEST PRESENT 3 CORRIGE")
test_present(present3_corrige))"""

print("\nTEST PRESENT 3 CORRIGE")
test_present(present4_corrige)

