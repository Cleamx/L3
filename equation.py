def discriminant(a, b, c):
    
    delta = (b * b) - (4 * a * c)
    print("Le discriminant est ", delta)

def main():

    testValeur = True
    while testValeur == True:
        entrerA = input("Entrer la valeur de a : ")
        entrerB = input("Entrer la valeur de b : ")
        entrerC = input("Entrer la valeur de c : ")
    
    try:
        entrerA = int(entrerA)
        int(entrerA) == int()

        entrerB = int(entrerB)
        int(entrerB) == int()

        entrerC = int(entrerC)
        int(entrerC) == int()
        
        testValeur = False

    except ValueError:
        print("Désolé la valeur saisie n'est pas correct.")
    

    discriminant(entrerA, entrerB, entrerC)

main()