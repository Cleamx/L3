def present(L: list, e: int) -> bool:

    if e in L:
        nbPresent = True
    else:
        nbPresent = False
    return nbPresent

def test_present(present):

    if present([], 2):
        print("ECHEC : test liste vide")
    else:
        print("SUCCES : test liste vide")
        
test_present(present)
