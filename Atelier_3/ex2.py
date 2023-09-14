def mots_Nlettres(lst_mot: list, n:int)->list:
    """fonction qui retourne la liste des mots qui on n lettres

    Args:
        lst_mot (list): liste de mot
        n (int): entier

    Returns:
        list: liste de mots
    """

    lst_mot_deux = []
    for i in lst_mot:
        if len(i) == n:
            lst_mot_deux.append(i)

    return lst_mot_deux

def commence_par(mot: str, prefixe: str)-> bool:
    """fonction qui renvoie True si le mot commence par prefixe sinon False

    Args:
        mot (str): mot
        prefixe (str): prefixe rechercher dans mot

    Returns:
        bool: True si le mot commence par prefixe sinon False
    """
    res = False
    if mot.startswith(prefixe):
        res = True
    return res

def commencent_par(lst_mot: list, prefixe:str)->list:
    liste_prefixe = []

    for i in range(len(lst_mot)):
        if commence_par(lst_mot[i], prefixe):
            liste_prefixe.append(lst_mot[i])
    return liste_prefixe

def finit_par(mot: str, suffixe: str)->bool:
    """fonction qui renvoie True si le mot finit par suffixe sinon False

    Args:
        mot (str): mot
        suffixe (str): suffixe rechercher dans mot

    Returns:
        bool: envoie True si le mot finit par suffixe sinon False
    """
    res = False
    if mot.endswith(suffixe):
        res = True
    return res

def finissent_par(lst_mot:list, suffixe:str)->list:
    """fonction qui retourne la liste des mots finissant par suffixe

    Args:
        lst_mot (list): liste de mots
        suffixe (str): suffixe rechercher pour chaque mot

    Returns:
        list: liste des mots qui finissent par le suffixe rechercher
    """
    liste_suffixe = []

    for i in range(len(lst_mot)):
        if finit_par(lst_mot[i], suffixe) == True:
            liste_suffixe.append(lst_mot[i])
    return liste_suffixe

def liste_mots (lst_mot:list, prefixe:str, suffixe:str, n:int) ->list:
    """fonction qui renvoie une liste de mot de n lettre avec prefixe en début ou suffixe en fin

    Args:
        lst_mot (list): liste de mots
        prefixe (str): prefixe rechercher 
        suffixe (str): suffixe rechercher
        n (int): nombre entier

    Returns:
        list: liste de mot de n lettre avec prefixe ou suffixe chercher 
    """
    liste_Nlettre = mots_Nlettres(lst_mot, n)

    return  finissent_par(commencent_par(liste_Nlettre,prefixe),suffixe)

def dictionnaire(fichier)->list:
    """fonction qui retourne les mots d'un fichier dans une liste

    Args:
        fichier (fichier): fichier donne

    Returns:
        list: liste de mot
    """
    liste_dictionnaire = []
    f = open(fichier,"r")
    c = f.readline() #lecture d'une ligne dans une chaine # de caractères
    while c!="" :
        c = f.readline() 
        c = c.rstrip('\n')
        liste_dictionnaire.append(c)
    return liste_dictionnaire

lst_test = dictionnaire("/Users/clementinemirande/Desktop/L3 SPI/L3/littre.txt")


print("Test mot de n lettre :\n",mots_Nlettres(lst_test,3))
print("Test mot commence par :\n", commence_par("jouer", "jou"))
print("Test mots commencent par :\n",commencent_par(lst_test, "jouer"))
print("Test mot finit par :\n",finit_par("bonjour", "our"))
print("Test mots finnissent par :\n",finissent_par(lst_test, "tter"))
print("Test mots de n lettre commencent et finissent par :\n",liste_mots(lst_test, "j", "r", 5 ))
