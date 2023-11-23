#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct 16 11:17:11 2023

@author: clementinemirande
"""
import numpy as np

Tab = np.random.randint(0,5,20)

def compter(D, F, N):
    if (D >= F):
        return 0
    M = (D + F) // 2
    Milieu = int(Tab[M] == N)
    gauche = compter(D,M,N)
    droite = compter(M+1, F, N)
    return gauche + droite + Milieu

print(compter(0, len(Tab), 0))

"""
def somme(N):
    if (N == 0) or (N == 1):
        return 1
    else:
        return N + somme(N-1)

print(somme(3))


def ContientZero(N, pos):
    if (N == 0):
        return True, pos
    if (N <=9):
        return False
    if (N % 10 == 0):
        return True, pos
    return ContientZero(N//10, pos+1)

print(ContientZero(12335466887098563, 0))

def Puissance(X,n):
    if (n == 0):
        return 1
    else:
        return X * Puissance(X, n-1)


for i in range(10):
    print(Puissance(2, i))


def suiteFibonacci(N):
    
    if(N == 0):
        return 0
    if (N == 1):
        return 1
    else:
        return suiteFibonacci(N-1) + suiteFibonacci(N-2)
    
def listeFibonacci(N):
    lst = []
    for i in range(N+1):
        lst.append(suiteFibonacci(i))
    return lst

print(listeFibonacci(8))

print(suiteFibonacci(8))
"""