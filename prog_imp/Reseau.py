#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 14:09:10 2023

@author: clementinemirande
"""

import numpy as np
import math
reseau = np.loadtxt("reseau.txt")
fp = open("reseau.txt")
line = fp.readline()
fp.close()
noms = line.split()
noms[0] = noms[0][1:]
chemins = []
for i in range(len(noms)):
    chemins.append([None, math.inf, 'Blanc' ])
    
def petitGris():
    global chemins, noms
    nom = ''; taille = math.inf
    for num in range(len(noms)):
        if (chemins[num][2] == 'Gris') and (chemins[num][1] < taille):
            nom = noms[num]; taille = chemins[num][1]
    return nom

def dijsktra(D):
    global chemins, noms, reseau
    numD = noms.index(D)
    chemins[numD][1] = 0; chemins[numD][2] = 'Gris'
    
    while True:
        nomX = petitGris()
        if nomX == '': return
        X = noms.index(nomX)
        chemins[X][2]='Noir'
        Liste = [i for i in range(len(noms)) if reseau[X,i] != 0 and chemins[i][2] != 'Noir']
        for Y in Liste:
            if (reseau[X,Y] + chemins[X][1]) < chemins[Y][1]:
                chemins[Y][1] = reseau[X,Y] + chemins[X][1]
                chemins[Y][0] = nomX
                chemins[Y][2] = 'Gris'
    
dijsktra('S0')