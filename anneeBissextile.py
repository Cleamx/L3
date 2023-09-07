import random

"""fonction test qui  permet de tester 10 années choisit aléatoirement entre 1000 et 3000"""
def testAnnee():
    i = 0

    while i != 10:
        anneeTest = random.randint(1000,3000)
        est_bessextile(anneeTest)
        print(anneeTest,anneeBool)
        i+=1

"""fonction qui renvoie False si l'année n'est pas bissextile et True si bissextile"""
def est_bessextile(annee:int):
    global anneeBool

    if annee % 4 == 0 and annee % 100 != 0 or annee % 400 == 0:
        anneeBool = True
    else:
        anneeBool = False

    return(anneeBool)

def main():
    
    #test si la valeur saisie est bien un entier 
    testValeur = True
    while testValeur == True:
        entrerAnnee = input("Entrer une année : ")
        try:
            entrerAnnee = int(entrerAnnee)
            entrerAnnee == int()
            testValeur = False
        except ValueError:
            print("Désolé la valeur saisie n'est pas correct.")
    
    est_bessextile(entrerAnnee)

    #Selon la valeur retournée dit si l'année est bissextile ou non
    if anneeBool == True:
        print(entrerAnnee," est une année bissextile")
    elif anneeBool == False:
         print(entrerAnnee, " n'est pas bissextile.")
        
testAnnee()
main()