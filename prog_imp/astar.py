#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 15:53:42 2023

@author: clementinemirande
"""
import numpy as np
import math
reseau = np.loadtxt('Astar.txt')
fp = open('Astar.txt')
noms = fp.readline().split()[:-1]
fp.close()
noms[0] = noms[0][1:]
chemins = [[math.inf, reseau[i][-1], None] for i in range(len(noms))]
reseau = reseau[:, :-1]

def minLO(LO):
    global chemins, noms
    X = LO[0]; numX = noms.index(X)
    for Y in LO[1:]:
        numY = noms.index(Y)
        if chemins[numX][0] + chemins[numY][1] < chemins[numX][0] + chemins[numX][1]:
            X = Y; numX = numY
    return X, numX

def Astar(D, A):
    global reseau, chemins, noms
    LO = [D]; LF = []
    chemins[noms.index(D)][0] = 0
    
    while len(LO) > 0:
        X, numX = minLO(LO); LF.append(X)
        LO.remove(X)
        if X == A : return
        liste =[i for i in range(len(noms)) if reseau[numX, i] != 0 and (noms[i] not in LF)]
        for numY in liste:
            cout = chemins[numX][0]+ reseau[numX, numY]
            if cout < chemins[numY][0]:
                chemins[numY][0] = cout
                chemins[numY][2] = X
                Y = noms[numY]
                if (Y not in LO) and (Y not in LF):
                    LO.append(Y)
                
Astar('S0', 'S10')

