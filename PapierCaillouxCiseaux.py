import random

debutJeu = input("Voulez-vous jouer contre l'ordinateur (Max 5 parties) O/N ? " ).capitalize()
nomUn = input("Quel est votre nom ? ").title()
print("Bienvenu ",nomUn, " nous allons jouer ensemble \n")

if debutJeu == 'O':
    nomDeux = 'Machine'
elif debutJeu == 'N':
    nomDeux = input("Quel est le nom du deuxième joueur ?").title()
    print("Bienvenu ",nomDeux, " nous allons jouer ensemble \n")
else :
    print("Je n'ai pas compris votre réponse.")

scoreUn = 0
scoreDeux = 0
numeroManche = 0

jeu = True
while jeu == True:
    numeroManche += 1 
    choixUn = input("{nom} faîtes votre choix parmi (pierre, papier, ciseaux, puit): ".format(nom=nomUn)).lower()
    if choixUn != 'pierre' and choixUn != 'papier' and choixUn != 'ciseaux' and choixUn != 'puit':
        choixUnOk = False
        while choixUnOk == False :
            print("Je n'ai pas compris votre réponse joueur", nomUn)
            choixUn = input("Faîtes votre choix parmi (pierre, papier, ciseaux, puit): ")
            choixUnOk = True
            if choixUn != 'pierre' and choixUn != 'papier' and choixUn != 'ciseaux' and choixUn != 'puit':
                choixUnOk = False

    if debutJeu == 'O': 
        #Ici il faudrait plutôt vérifier que debutJeu == 'O' autrement
        #il y a un problème si le joueur 2 s'appelle Machine !
        choixDeux = ['papier','pierre','ciseaux','puit'][random.randint(0, 3)]


    if nomDeux != 'Machine':
        print("Joueur", nomDeux)
        choixDeux = input("faîtes votre choix parmi (pierre, papier, ciseaux, puit): ").lower()
        if choixDeux != 'pierre' and choixDeux != 'papier' and choixDeux != 'ciseaux' and choixDeux != 'puit':
            choixDeuxOk = False
            while not choixDeuxOk :
                print("Je n'ai pas compris votre réponse joueur", nomDeux)
                choixDeux = input("Faîtes votre choix parmi (pierre, papier, ciseaux, puit): ")
                choixDeuxOk = True
                if choixDeux != 'pierre' and choixDeux != 'papier' and choixDeux != 'ciseaux' and choixDeux != 'puit':
                    choixDeuxOk = False

    #On affiche les choix de chacun
    print("Si on récapitule :",nomUn, choixUn, "et", nomDeux, choixDeux,"\n")


    #On regarde qui a gagné cette manche on calcule les points et on affiche le résultat
    resultat = ""
    if choixUn == choixDeux :
        resultat = "aucun de vous, vous être ex æquo"
       
    elif choixUn == "pierre" and choixDeux == "ciseaux" or choixUn == "papier" and choixDeux == "pierre" or choixUn == "ciseaux" \
    and choixDeux == "feuille" or choixUn == "puit" and choixDeux == "pierre" or choixUn == "puit" and choixDeux == "ciseaux":
        resultat = nomUn
        scoreUn += 1
    
    else:
        resultat = nomDeux
        scoreDeux += 1

    print("Le gagnant est",resultat)
    print("Les scores à l'issue de cette manche sont donc",nomUn, scoreUn, "et", nomDeux, scoreDeux, "\n")

    if numeroManche == 5:
        jeu = False
        
    if numeroManche < 5:
        #On propose de jeu ou de s'arrêter 
        suite = input("Souhaitez vous refaire une partie {} contre {} ? (O/N) ".format(nomUn,nomDeux)).capitalize()
        if suite == 'O':
            jeu = True
        if suite == 'N':
            jeu = False
        if suite != 'O' and suite != 'N':
            jeu = True
            print("Vous ne répondez pas à la question, on continue ")
  
        
if jeu == False :
    print("Merci d'avoir joué ! A bientôt")

    # gagnant 1 if -> tout gagnant score +1 jouer1 else joeur deux gagne
    # debut oui non if o joueur 2= machine sinon input
    # print gagnant qu'une fois variable winner recup tout 