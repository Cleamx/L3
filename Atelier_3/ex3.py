def places_lettre(ch : str, mot : str) -> list:
    indices = []
    for i in range(len(mot)):
        if mot[i] == ch:
            indices.append(i)
    
    return indices

def outputStr(mot:str, lpos:list)-> str:

    liste_res = []
    str_res = ""

    for i in range(len(mot)):
        liste_res.append(" _")
        if i in lpos:
            liste_res[i] = mot[i]

    for i in range(len(liste_res)):
        str_res += liste_res[i] + " "
    return str_res
        

def test_places_lettre():
    lettre = input("Entrez une lettre : ")
    mot = "bonjour"

    indices = places_lettre(lettre, mot)
    
    print(outputStr(mot,indices))

test_places_lettre()