import numpy as np
import math
import copy

"""
reseau = np.loadtxt("reseau.txt")
fp = open("reseau.txt")
Sommets = fp.readline().split()
Sommets[0] = Sommets[0][1:]

S = fp.readline().split()
A = S[1]
D = S[0][1:] 
fp.close() 

#Variables du pb
Chemin = [D]; Distance = 0
PCC = []; DistancePCC = math.inf

def accept(ne, i):
    global reseau, Distance, DistancePCC, Chemin, Sommets
    
    if reseau[ne, i] == 0: return False
    if Sommets[i] in Chemin : return False
    if Distance + reseau[ne, i] > DistancePCC : 
        return False
    return True
    

def PlusCourtCh():
    global reseau, Sommets, A
    global Chemin, Distance, PCC, DistancePCC
    
    e = Chemin[-1]
    if e == A:
        if Distance < DistancePCC:
            DistancePCC = Distance
            PCC = copy.deepcopy(Chemin)
        return
    numE = Sommets.index(e)
    for i in range(len(Sommets)):
        if accept(numE, i):
            Chemin.append(Sommets[i])
            Distance = Distance + reseau[numE, i]
            PlusCourtCh()
            Distance = Distance - reseau[numE, i]
            del Chemin[-1]
            

res = PlusCourtCh()
"""

Barre = [0,2,5,7,9,10,12,14,15]
TailleMax = len(Barre)-1

Decoupe = []; DecoupOp = []
Prix = 0; PrixOp = 0

def decouper(e):
    global Barre, TailleMax, Decoupe, Prix, DecoupOp, PrixOp
    taille = sum(Decoupe)
    
    if taille == TailleMax:
        if Prix > PrixOp:
            DecoupOp = copy.deepcopy(Decoupe)
            PrixOp = Prix
        return
    
    for i in range(e, (TailleMax-taille)+1):
        Decoupe.append(i)
        Prix = Prix + Barre[i]
        decouper(i)
        Prix = Prix - Barre[i]
        del Decoupe[-1]

res = decouper(1)























