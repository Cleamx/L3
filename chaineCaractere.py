def message_imc(imc : int):
    resultat_imc = ""
    IMC_FAMINE = 16.5
    IMC_MAIGREUR = 18.5
    IMC_NORMALE = 25
    IMC_SURPOIDS = 30
    IMC_OB_MODEREE = 35
    IMC_OB_SEVERE = 40
    
    if imc <= IMC_FAMINE:
        resultat_imc = "dénutrition ou famine"
    elif IMC_FAMINE < imc <= IMC_MAIGREUR:
        resultat_imc = "maigreur"
    elif IMC_MAIGREUR < imc < IMC_NORMALE:
        resultat_imc = "corpulence normale"
    elif IMC_NORMALE < imc <= IMC_SURPOIDS:
        resultat_imc = "surpoids"
    elif IMC_SURPOIDS < imc <= IMC_OB_MODEREE:
        resultat_imc = "obésité modérée"
    elif IMC_OB_MODEREE < imc <= IMC_OB_SEVERE:
        resultat_imc = "obésité sévère" 
    elif imc > IMC_OB_SEVERE:
        resultat_imc = "obésité morbide"

    print("L'interprétation de votre imc est : ", resultat_imc)

def main():
    testValeur = True
    while testValeur == True:
        entrerImc = input("Saisir votre imc : ")
        try:
            entrerImc = int(entrerImc)
            int(entrerImc) == int()
            testValeur = False
        except ValueError:
            print("Désolé la valeur saisie n'est pas correct.")
        
    message_imc(entrerImc)

main()