#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct 16 10:50:49 2023

@author: clementinemirande
"""
"""
def factorielle(N):
    if (N == 0) or (N == 1):
        return 1
    else:
        return N * factorielle(N-1)

print(factorielle(3))
"""
T1 = [5, 4, 3, 2, 1]
T2 = []
T3 = []

def Hanoi(N, TA, TB, TC, NomA, NomB, NomC):
    if (N == 1):
        TB.append(TA[-1])
        del TA[-1]
        print("Déplacer {} de {} vers {}".format(TB[-1], NomA, NomB))
    else :
        Hanoi(N-1, TA, TC, TB, NomA, NomC, NomB)
        Hanoi(1, TA, TB,TC, NomA, NomB, NomC)
        Hanoi(N-1, TC, TB, TA, NomC, NomB, NomA)

Hanoi(len(T1), T1, T2, T3, "T1", "T2", "T3")
