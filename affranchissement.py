testSaisie = True
while testSaisie == True:
    typeLettre = input("Saisir le type de lettre (verte (V), prioritaire (P) ou éco-plie (E)) : ").capitalize()
    if typeLettre != "V" and typeLettre != "P" and typeLettre != "E":
        print("Désolé le type de lettre saisie n'est pas correct.")
    else:
        testSaisie = False

testValeur = True
while testValeur == True:
    poidsLettre = input("Saisir le poids de la lettre en gramme : ")
    try:
        poidsLettre = int(poidsLettre)
        int(poidsLettre) == int()
        testValeur = False
    except ValueError:
        print("Désolé la valeur saisie n'est pas correct.")

def prix_gramme(poid):
    prixAffranchissement = 0
    
    if poid <= 20:
        prixAffranchissement = TARIF_VINGT_GRAMME
    elif (20 < poid <= 100):
        prixAffranchissement = TARIF_CENT_GRAMME
    elif (100 < poid <= 250):
        prixAffranchissement = TARIF_DEUX_CENT_CINQUANTE_GRAMME
    elif (250 < poid < 500):
        prixAffranchissement = TARIF_CINQUE_CENTS_GRAMME
    elif (500 < poid <= 1000):
        prixAffranchissement = TARIF_UN_KILOS
    elif (1000 < poid <= 3000):
        prixAffranchissement = TARIF_TROIS_KILOS
    else:
        print("Le poid inscrit est trop élevé")
        prixAffranchissement = "Erreur le prix n'est pas disponible"

    print("Le prix de l'affranchissement est de ",prixAffranchissement," €")

if typeLettre == "V":
        
    TARIF_VINGT_GRAMME = 1.16
    TARIF_CENT_GRAMME = 2.32
    TARIF_DEUX_CENT_CINQUANTE_GRAMME = 4.00
    TARIF_CINQUE_CENTS_GRAMME = 6.00
    TARIF_UN_KILOS = 7.50
    TARIF_TROIS_KILOS = 10.50

    prix_gramme(poidsLettre)

elif typeLettre == "P":
    TARIF_VINGT_GRAMME = 1.43
    TARIF_CENT_GRAMME = 2.86
    TARIF_DEUX_CENT_CINQUANTE_GRAMME = 5.26
    TARIF_CINQUE_CENTS_GRAMME = 7.89
    TARIF_UN_KILOS = 7.89
    TARIF_TROIS_KILOS = 11.44

    prix_gramme(poidsLettre)

elif typeLettre == "E":
    TARIF_VINGT_GRAMME = 1.14
    TARIF_CENT_GRAMME = 2.28
    TARIF_DEUX_CENT_CINQUANTE_GRAMME = 3.92
    TARIF_CINQUE_CENTS_GRAMME = "erreur"
    TARIF_UN_KILOS = "erreur"
    TARIF_TROIS_KILOS = "erreur"

    prix_gramme(poidsLettre)
