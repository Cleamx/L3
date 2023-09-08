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
    return x

def racine_double(a:float, b:float, delta:float, num:int)->float:
    """Calcule la solution 1 ou 2

    Args:
        a (float): nombre réel
        b (float): nombre réel
        delta (float): discriminant de l'équation
        num (int): numéro de la racine

    Returns:
        float: retourne la solution x1 ou x2 
    """
    racineCarreDelta = math.sqrt(delta)
    if num == 1:
        x = (-b + float(racineCarreDelta)) / (2 * a)
    elif num == 2:
        x = (-b - racineCarreDelta) / (2 * a)
    return x

def str_equation(a:float, b:float, c:float )->str:
    """Renvoie une chaine de caractère en format "ax2 +bx+c=0"

    Args:
        a (float): nombre réel
        b (float): nombre réel
        c (float): nombre réel

    Returns:
        str: chaine de caractère en format "ax2 +bx+c=0"
    """
    stringEquation = f"{a}x^2"
    if b == 0:
        stringEquation = f"{a}x^2"
    if b >= 0:
        stringEquation += f" + {b}x"
    else:
        stringEquation += f" - {abs(b)}x"
    if c >= 0:
        stringEquation += f" + {c}"
    else:
        stringEquation += f" - {abs(c)}"
    stringEquation += f"=0"
    return(stringEquation)

def solution_equation(a:float, b:float, c:float)->str:
    """retourne la ou les solutions de l'équation

    Args:
        a (float): nombre réel
        b (float): nombre réel
        c (float): nombre réel

    Returns:
        str: solution de l'équation
    """
    deltaSolution = discriminant(a,b,c)
    solution = "La solution de l'équation "
    str_solution = str_equation(a,b,c)
    solution = solution + str_solution
    
    if deltaSolution == 0:
        solutionRacineUnique = str(racine_unique(a,b))
        solution = solution + " racine unique: " + solutionRacineUnique
    elif deltaSolution > 0:
        xUnSolution = str(racine_double(a,b,deltaSolution,1))
        xDeuxSolution = str(racine_double(a,b,deltaSolution,2))
        solution = solution + "\nDeux racine: \nx1 = " + xUnSolution + "\nx2 =  " + xDeuxSolution
    else:
        solution = solution + " n'a pas de racine réel"
    
    return solution 

def equation(a:float, b:float ,c:float) ->str:
    """Solution final

    Args:
        a (float): nombre réel
        b (float): nombre réel
        c (float): nombre réel

    Returns:
        str: la solution si solution réel
    """
    eq = ""
    if discriminant(a, b, c) < 0:
        eq = "La solution n'a pas de valeur réel"
    else:
        eq = solution_equation(a,b,c)
    return eq

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
        print(equation(entrerA,entrerB,entrerC))

main()