def separation(L : list) -> list:
    """Mettre valeur inférieur à zéro au debut de la liste, égal à zero milieu de la liste et supérieur à zéro fin liste

    Args:
        L (list): liste

    Returns:
        list: liste [valeur < zéro, valeur = 0, valeur > zero]
    """
    LSEP = []
    lstNul = []
    lstPositif = []

    for nb in L:
        if nb == 0:
            lstNul.append(nb)
        elif nb < 0:
            LSEP.append(nb)
        else:
            lstPositif.append(nb)
    print(LSEP)
    LSEP.extend(lstNul)
    print(LSEP)
    LSEP.extend(lstPositif)
    print(LSEP)

    return LSEP

print(separation([4,-234,0,-1,0,234]))