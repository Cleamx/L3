import random

def places_lettre(ch : str, mot : str) -> list:
    """Fonction qui cherche si ch est dans le mot et retourne son indice

    Args:
        ch (str): lettre
        mot (str): mot

    Returns:
        list: liste d'indice
    """
    indices = []
    for i in range(len(mot)):
        if mot[i] == ch:
            indices.append(i)
    
    return indices

def outputStr(mot:str, lpos:list)-> str:
    """fonction qui affiche la position des lettre dans le mot. Et qui remplace les lettre non
    devinées par des tirets.

    Args:
        mot (str): mot
        lpos (list): liste d'entier qui représentent les indices des caractères des mots

    Returns:
        str: affichage des caractères et des tirets
    """

    liste_res = []
    str_res = ""

    for i in range(len(mot)):
        liste_res.append(" _")
        if i in lpos:
            liste_res[i] = mot[i]

    for i in range(len(liste_res)):
        str_res += liste_res[i] + " "
    return str_res

def runGame():
    #Affichage
    C5 = "|----] "
    C4 = "|  O "
    C3 = "|  T "
    C2 = "| / \ "
    C1 = "|______"
    
    i = 5
    lst_indices = []
    lst =["paris","londres","madrid","berlin","new-york"]
    lst_len = len(lst)
    iRand = random.randint(1, lst_len)
    motRand = lst[iRand-1]
    indices = places_lettre('', motRand)
    print(outputStr(motRand, indices))

    while i != 0:
        lettre = str(input("Entrez une lettre : ")).lower()
        indices = places_lettre(lettre, motRand)

        if indices:
            for j in indices:
                lst_indices.append(j)
        else:
            i -= 1 

        res = outputStr(motRand, lst_indices)
        print(res)

        if i == 4:
            print("\n",C1)
        elif i == 3:
            print("\n",C2,"\n",C1)
        elif i == 2:
            print("\n",C3,"\n",C2,"\n",C1)
        elif i == 1:
            print("\n",C4,"\n",C3,"\n",C2,"\n",C1)
        elif i == 0:
            print("\nPerdu")
            print("\n",C5,"\n",C4,"\n",C3,"\n",C2,"\n",C1)
        
        if "_" not in res:
            return 1

       

        

def test_places_lettre():
    lettre = input("Entrez une lettre : ")
    mot = "bonjour"

    indices = places_lettre(lettre, mot)
    
    print(outputStr(mot,indices))

# test_places_lettre()
runGame()