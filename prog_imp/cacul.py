#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct 23 10:30:26 2023

@author: clementinemirande
"""

import itertools as it
import copy


Valeurs = [9, 7, 3, 8, 100, 50]
Resultat = 604
op = ['*', '+', '-', '/']
operations = []
trouve = False

def acceptable(N1, N2):
    global op
    liste_op = []
    
    if N1 >= N2:
        liste_op.append('+')
        liste_op.append('*')
        if N1 != N2:
            liste_op.append('-')
        if N1 % N2 == 0:
            liste_op.append('/')
    return liste_op

def calcul(N1, N2, op):
    if op == "+": return N1 + N2
    if op == "-": return N1 - N2
    if op == "*": return N1 * N2
    return N1/N2

def leCompteEstBon(Values):
    global Resultat, op, operations, trouve
    
    if Resultat in Values:
        trouve = True
        return
    if len(Values) == 1:
        return
    for N1, N2 in it.permutations(Values, 2):
        for op in acceptable(N1, N2):
            R = calcul(N1, N2, op)
            Liste = copy.deepcopy(Values)
            Liste.remove(N1)
            Liste.remove(N2)
            Liste.append(R)
            operations.append("{} {} {} = {}".format(N1, op, N2, R))
            leCompteEstBon(Liste)
            if trouve == True:
                return
            del operations[-1]
            
leCompteEstBon(Valeurs)
        

"""
L = list(range(1,11)) * 2 + [25, 50, 75, 100]
Valeurs = []
for i in range(6):
    V = rd.choice(L)
    Valeurs.append(V)
    L.remove(V)

Resultat = rd.randint(101, 1000)
"""
