def vitrines(nbEmplacements:int, lObjet:list)->list:
    vitrineUn = []
    vitrineDeux = []
    i = 0

    for i in range(len(lObjet)):
        if len(vitrineUn) < nbEmplacements and lObjet[i] not in vitrineUn :
            vitrineUn.append(lObjet[i])
        elif len(vitrineDeux) < nbEmplacements and lObjet[i] not in vitrineDeux:
            vitrineDeux.append(lObjet[i])
    
    print(vitrineUn, vitrineDeux)

lObjets = [1, 2, 2, 3, 4, 5, 5]
print(vitrines(4, lObjets))