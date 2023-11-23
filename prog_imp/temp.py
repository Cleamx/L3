# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import numpy as np
import copy
data = np.loadtxt('sac a dos.txt', dtype = int)

"""
## Métode gloutonne 

X = data[:,1]/data[:,2]
data = np.c_[data,X]

def bigger(indices):
    indPG = indices[0]
    for ind in indices:
        if data[ind,3] > data[indPG,3] :
            indPG = ind
    return indPG

def biggers(nb):
    L = []
    for ind in range(len(data)):
        L.append(ind)
    listePG = []
    for i in range(nb):
        ind = bigger(L)
        listePG.append(ind)
        L.remove(ind)
    return listePG

def remplir(W = 15):
    objets = []
    poids = 0
    count = 0
    L = []
    for ind in range(len(data)):
        L.append(ind)
    for i in range(len(data)):
        ind = bigger(L)
        if poids + data[ind,2] <= W :
            objets.append(ind)
            poids = poids + data[ind,2]
            count = count + data[ind,1]
            L.remove(ind)
    
    return objets, poids, count


print(biggers(4))
objects, poids, count = remplir()"""

data = np.delete(data, (0),axis =1) ##suprime col 0

def dynamique(Weight):
    
    Cpred = [0] * (Weight + 1)
    SacPred = [[]] * (Weight + 1)
    
    for ind in range(len(data)):
        C = [0] * (Weight + 1)
        Sac = []
       
        for w in range(0, Weight + 1):
            poids = data[ind][1]
            cout = data[ind][0]
            
            if ((w < poids) or (Cpred[w] > (Cpred[w-poids] + cout))):
                C[w] = Cpred[w]
                Sac.append(list(SacPred[w]))
                
            else:
                C[w] = Cpred[w - poids] + cout
                Sac.append(list(SacPred[w - poids]))
                Sac[-1].append(ind)
        Cpred = copy.deepcopy(C)
        SacPred = copy.deepcopy(Sac)
    
    return Sac , C
            
Sac , C = dynamique(15)



