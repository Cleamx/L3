from anneeBissextile import est_bessextile
from datetime import date

def date_est_valide(jour:int, mois: int, annee:int)->bool:
    
    valide = True

    joursMois = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if est_bessextile(annee):
        joursMois[1] = 28
    
    if mois < 1 or mois > 12:
        valide = False
    
    if jour < 1 or jour > joursMois[mois - 1]:
        valide = False
    
    return valide

def saisi_date_naissance():
    testValeur = True
    while testValeur:
        try:
            Jour = int(input("Saisir le jour de votre naissance : "))
            Mois = int(input("Saisir le mois de votre naissance : "))
            Annee = int(input("Saisir l'année de votre naissance : "))

            if date_est_valide(Jour, Mois, Annee) == True:
                dateNaissance = date(Annee, Mois, Jour)
                return dateNaissance
            else:
                testValeur = False
       
        except ValueError:
            print("Valeur invalide, saisir la date de votre naissance : ")

def age(date_naissance:date)->int:
    dateActuelle = date.today()
    date_naissance = dateActuelle - date_naissance
    age = date_naissance.days / 365.2425
    return int(age)

def est_majeur(date_naissance:int)->bool:
    if date_naissance >= 18:
        majeur = True
    else:
        majeur = False
    return majeur

def test():
    naissance = saisi_date_naissance()
    age_test = age(naissance) 
    if est_majeur(age_test) == True:
        print("Bonjour, vous avez", age_test," ans, Accès autorisé ")
    else:
        print("Désolé, vous avez", age_test, " ans, Accès interdit")

test()