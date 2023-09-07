prixAffranchissement = 0
tariftest = [""] 



def prix_gramme(poids,tarifLettre):
    """ 
        envoie le prix en fonction du poids et du type de lettre

        :param poids: poids de la lettre
        :param tarifLettre: tarif en fonction du type de lettre
        :type poids: int
        :type tarifLettre: list
        :return: tarif en fonction du poids et du type de lettre
        :rtype: float ou str si erreur
    """
    TARIF_VINGT_GRAMME = tarifLettre[0]
    TARIF_CENT_GRAMME = tarifLettre[1]
    TARIF_DEUX_CENT_CINQUANTE_GRAMME = tarifLettre[2]
    TARIF_CINQUE_CENTS_GRAMME = tarifLettre[3]
    TARIF_UN_KILOS = tarifLettre[4]
    TARIF_TROIS_KILOS = tarifLettre[5]

    POIDS_VINGT_GRAMME = 20
    POIDS_CENT_GRAMME = 100
    POIDS_DEUX_CENT_CINQUANTE_GRAMME = 250
    POIDS_CINQUE_CENTS_GRAMME = 500
    POIDS_UN_KILO = 1000
    POIDS_TROIS_KILOS = 3000

    """Renvoie le tarif en fonction du poids"""

    if poids <= POIDS_VINGT_GRAMME:
        tarif = TARIF_VINGT_GRAMME
    elif (POIDS_VINGT_GRAMME < poids <= POIDS_CENT_GRAMME):
        tarif = TARIF_CENT_GRAMME
    elif (POIDS_CENT_GRAMME < poids <= POIDS_DEUX_CENT_CINQUANTE_GRAMME):
        tarif = TARIF_DEUX_CENT_CINQUANTE_GRAMME
    elif (POIDS_DEUX_CENT_CINQUANTE_GRAMME < poids < POIDS_CINQUE_CENTS_GRAMME):
        tarif = TARIF_CINQUE_CENTS_GRAMME
    elif (POIDS_CINQUE_CENTS_GRAMME < poids <= POIDS_UN_KILO):
        tarif = TARIF_UN_KILOS
    elif (POIDS_UN_KILO < poids <= POIDS_TROIS_KILOS):
        tarif = TARIF_TROIS_KILOS
    else:
        print("Le poid inscrit est trop élevé")
        tarif = "Erreur le prix n'est pas disponible"

    return tarif

def calculPrixType(typeDeLettre):

    """
        envoie la liste des tarifs en fonction du type de lettre

        :param typeDeLettre: type de lettre V/ P/ E
        :type typeDeLettre: str
        :return: liste des tarifs du type de la lettre V/ P/ E
        :rtype: list
    """

    if typeDeLettre == "V":
        TARIF_LETTRE_VERTE = [1.16,2.32,4.00,6.00,7.50,10.50]
        tariftest = TARIF_LETTRE_VERTE 

    elif typeDeLettre == "P":
        TARIF_LETTRE_PRIORITAIRE = [1.43,2.86,5.26,7.89,7.89,11.44]
        tariftest = TARIF_LETTRE_PRIORITAIRE

    elif typeDeLettre == "E":
        TARIFECOPLI = [1.14,2.28,3.92,"poids trop élevé","poids trop élevé","poids trop élevé"]
        tariftest = TARIFECOPLI
    
    return tariftest

def main():
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

    
    test = calculPrixType(typeLettre)
    prixFinal =  prix_gramme(poidsLettre,test)

    print("Le prix de l'affranchissement est de ", prixFinal, "euro")    

main()
