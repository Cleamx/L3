import random
from ex2 import dictionnaire

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
    taille_mot = len(mot)

    for i in range(taille_mot):
        liste_res.append(" _")
        if i in lpos:
            liste_res[i] = mot[i]

    taille_lst_res = len(liste_res)
    for i in range(taille_lst_res):
        str_res += liste_res[i] + " "
    return str_res

def build_dict(lst: list) -> dict :
    """fonction qui fait un dictionnaire à partir d'une liste

    Args:
        lst (list): liste à transformé

    Returns:
        dict: dictionnaire
    """

    dictio = {}
    for mot in lst:
        taille_mot = len(mot)
        if taille_mot not in dictio:
            dictio[taille_mot] = []
        dictio[taille_mot].append(mot.lower())
    return dictio

def select_word(sorted_words:dict, word_len:int)->str:
    """selectionne un mot aléatoire à partir de word_len (niveau de difficulté, taille du mot à deviner)

    Args:
        sorted_words (dict): dictionnaire
        word_len (int): difficulté (taille du mot à deviner)

    Returns:
        str: mot à deviner
    """

    if word_len in sorted_words:
        res = random.choices(sorted_words[word_len])
    else:
        res = " "
    return res[0]


def runGame():
    #Affichage
    C5 = "|----] "
    C4 = "|  O "
    C3 = "|  T "
    C2 = "| / \ "
    C1 = "|______"
    
    lst_indices = []
    lst = dictionnaire("./Atelier_3/capitales.txt") #création de la liste à partire d'un fichier
    dictio = build_dict(lst) #recupère le transforme la liste en dictionnaire
    difficulte = int(input("""Sélectionnez le niveau de difficulté:\n
    - niveau 1 (taille du mot < 7) 
    - niveau 2 (6 < taille du mot < 9)
    - niveau 3 (taille du mot > 8)
    - Voitre choix : """)) #choix de la difficulté

    #selon la difficulté choisit une keys du dictionnaire
    cles = 0
    min_dico = 4
    if cles == 0:
        if difficulte == 1:
            cles = random.randint(min_dico, 6 )
        elif difficulte == 2:
            cles = random.randint(7,8)
        elif difficulte == 3:
            cles = random.randint(9, max(dictio.keys()))
        else:
            print("Choix non valide, niveau aléaoirement choisit")
            cles = random.randint(min_dico, max(dictio.keys()))
        

    mot = select_word(dictio,cles) #mot aléatoire selon difficulté
    print(mot)
    if mot != "erreur" or mot != " ":
        indices = places_lettre('', mot) 
        print(outputStr(mot, indices)) #affichage premier tour tous les tirets
    else:
        print(mot)


    i = 5
    while i != 0:
        
        lettre = str(input("Entrez une lettre : ")).lower()
        indices = places_lettre(lettre, mot)

        if indices:
            for j in indices:
                lst_indices.append(j)
        else:
            i -= 1 

        res = outputStr(mot, lst_indices)
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

# # test_places_lettre()
runGame()