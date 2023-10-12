from Atelier_1.anneeBissextile import est_bessextile

def  listeMultiples(binf : int, bsup : int, nb:int )->list:
    """liste des multiple de nb entre binf et bsup

    Args:
        binf (int): nombre min
        bsup (int): nombre max
        nb (int): nombre à multiplier

    Returns:
        list: liste des multipes de nb de binf à bsup
    """
    lst=list(range(binf,bsup+1))
    return [x for x in lst if x % nb==0]

def ajouter(lst:list ,nb:int)->list:
    """fonction qui retourne pour chaque element de la liste, element + nb

    Args:
        lst (list): liste d'entier
        nb (int): nombre à ajouter

    Returns:
        list: liste des nombres de la liste d'entier + nb
    """
    
    return [nb+x for x in lst]

def ajouterSiSup(lst:list, val:int, nb:int)->list:
    """fonction qui ajoute nb à un element de la liste si l'element est supérieur ou égale à val

    Args:
        lst (list): liste d'entier
        val (int): valeur à comparer
        nb (int): nombre à ajouter

    Returns:
        list: liste d'entier si >= val ajoute nb
    """
    return [nb+x for x in lst if x >= val]

def  bissextiles(adeb:int, afin:int)->list:
    return [x for x in range(adeb,afin+1) if est_bessextile(x) ]

def test():
    
    res_lst_multiple = listeMultiples(1,10,2)
    print(res_lst_multiple)

    res_lst_ajout = ajouter([1,2,3,4,5],10)
    print(res_lst_ajout)

    res_lst_si_sup = ajouterSiSup([11,2,13,4,15],10,10)
    print(res_lst_si_sup)

    res_Bissextile = bissextiles(2000,2024)
    print(res_Bissextile)


test()