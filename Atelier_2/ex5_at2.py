def vitrines(nbEmplacements:int, lObjet:list)->list:
    vitrineUn = []
    vitrineDeux = []

    for i in range(len(lObjet)):
        if len(vitrineUn) <= len(vitrineDeux) and len(vitrineUn) < nbEmplacements and lObjet[i] not in vitrineUn :
            vitrineUn.append(lObjet[i])
        elif len(vitrineDeux) < nbEmplacements and lObjet[i] not in vitrineDeux:
            vitrineDeux.append(lObjet[i])

    print(vitrineUn, vitrineDeux)

lObjets = [1, 2, 2, 2, 3, 4, 5, 5, 4, 6]
print(vitrines(5, lObjets))