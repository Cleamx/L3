def prix_gramme(poid):
    prixAffranchissement = 0
    POIDS_VINGT_GRAMME = 20
    POIDS_CENT_GRAMME = 100
    POIDS_DEUX_CENT_CINQUANTE_GRAMME = 250
    POIDS_CINQUE_CENTS_GRAMME = 500
    POIDS_UN_KILO = 1000
    POIDS_TROIS_KILOS = 3000

    """Renvoie le tarif en fonction du poids"""

    if poid <= POIDS_VINGT_GRAMME:
        prixAffranchissement = TARIF_VINGT_GRAMME
    elif (POIDS_VINGT_GRAMME < poid <= POIDS_CENT_GRAMME):
        prixAffranchissement = TARIF_CENT_GRAMME
    elif (POIDS_CENT_GRAMME < poid <= POIDS_DEUX_CENT_CINQUANTE_GRAMME):
        prixAffranchissement = TARIF_DEUX_CENT_CINQUANTE_GRAMME
    elif (POIDS_DEUX_CENT_CINQUANTE_GRAMME < poid < POIDS_CINQUE_CENTS_GRAMME):
        prixAffranchissement = TARIF_CINQUE_CENTS_GRAMME
    elif (POIDS_CINQUE_CENTS_GRAMME < poid <= POIDS_UN_KILO):
        prixAffranchissement = TARIF_UN_KILOS
    elif (POIDS_UN_KILO < poid <= POIDS_TROIS_KILOS):
        prixAffranchissement = TARIF_TROIS_KILOS
    else:
        print("Le poid inscrit est trop élevé")
        prixAffranchissement = "Erreur le prix n'est pas disponible"

    print("Le prix de l'affranchissement est de ",prixAffranchissement," €")

def main():
    global TARIF_VINGT_GRAMME
    global TARIF_CENT_GRAMME
    global TARIF_DEUX_CENT_CINQUANTE_GRAMME
    global TARIF_CINQUE_CENTS_GRAMME
    global TARIF_UN_KILOS
    global TARIF_TROIS_KILOS
    testSaisie = True
    testValeur = True
 
    """Test si typeLettre est bien V P ou E sinon renvoie un message d'erreur et redemande la saisie"""
    while testSaisie == True:
        typeLettre = input("Saisir le type de lettre (verte (V), prioritaire (P) ou éco-plie (E)) : ").capitalize()
        if typeLettre != "V" and typeLettre != "P" and typeLettre != "E":
            print("Désolé le type de lettre saisie n'est pas correct.")
        else:
            testSaisie = False

    """Test si le poids entrer est bien un entier sinon renvoie un message d'erreur et redemande la saisie"""
    while testValeur == True:
        poidsLettre = input("Saisir le poids de la lettre en gramme : ")
        try:
            poidsLettre = int(poidsLettre)
            int(poidsLettre) == int()
            testValeur = False
        except ValueError:
            print("Désolé la valeur saisie n'est pas correct.")

    """en fonction du type de lettre les tarifs varient et la fonction prix_gramme renvoie le tarif en fonction du poids saisie"""
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

main()
