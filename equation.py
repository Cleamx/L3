import math

def discriminant(a, b, c):
    """
        calcul de delta en fonction de a, b et c 

        :param a: valeur de a saisie dans main
        :param b: valeur de b saisie dans main
        :param c: valeur de c saisie dans main
        :type a: float
        :type b: float
        :type c: float
        :return: delta 
        :rtype: float
    """
    delta = (b * b) - (4 * a * c)
    print("Le delta est ", delta)
    return float(delta)

def racine_unique(a,b):
    """
        calcul de la racine unique x
        :param a: valeur de a saisie dans main
        :param b: valeur de b saisie dans main
        :type a: float
        :type b: float
        :return: racine unique x
        :rtype: float
    """
    x = (-b) / (2*a)
    print("La racine unique x = ", x)
    return float(x)

def racine_double(a, b, delta, num):

    if delta > 0:
        racineCareeDelta = math.sqrt(delta)
        if num == 1:
            xUn = (-b + float(racineCareeDelta)) / (2 * a)
        elif num == 2:
            xDeux = (-b - racineCareeDelta) / (2 * a)
    else:
        print("erreur")

def main():

    testValeur = True
    while testValeur == True:
        entrerA = input("Entrer la valeur de a : ")
        entrerB = input("Entrer la valeur de b : ")
        entrerC = input("Entrer la valeur de c : ")
    
        try:
            entrerA = float(entrerA) 
            entrerB = float(entrerB)
            entrerC = float(entrerC)
            entrerA == float()  and entrerB == float() and entrerC == float() 
            testValeur = False

        except ValueError:
            print("Désolé la valeur saisie n'est pas correct.")

    if entrerA == 0:
        print("Erreur A ne peut pas avoir une valeur de 0")
        main()
    else:    
        deltaa = discriminant(entrerA, entrerB, entrerC)
        racine_unique(entrerA, entrerB)
        racine_double(entrerA, entrerB, deltaa, 1)

main()