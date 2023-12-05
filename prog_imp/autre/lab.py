#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 17 13:58:37 2023

@author: clementinemirande
"""
import math
import numpy as np
import copy

Labyrinthe = np.loadtxt("Laby.txt")
Direction = [(0,1), (1,0), (0,-1), (-1, 0)]
A = (Labyrinthe.shape[0]-1, Labyrinthe.shape[1]-1)
trouve = False

e = (0,0)
Labyrinthe[e[0], e[1]] = 1

def acceptable(e, Direction):
    px = e[0] + Direction[0]
    py = e[1] + Direction[1]
    
    if (px >= Labyrinthe.shape[0]) or (py >= Labyrinthe.shape[1]):
        return False
    if (px < 0) or (py < 0):
        return False
    if (Labyrinthe[px, py] == -1) or (Labyrinthe[px, py] == 1):
        return False
    return True


def chercher(Arr, etp):
    global trouve
    
    if Arr[0] == etp[0] and Arr[1] == etp[1]:
        trouve = True; return
    
    for D in Direction:
        if acceptable(etp, D):
            nvEtp = (etp[0] + D[0], etp[1] + D[1])
            Labyrinthe[nvEtp[0], nvEtp[1]] = 1
            chercher(Arr, nvEtp)
            if trouve == True:
                return
            Labyrinthe[nvEtp[0], nvEtp[1]] = 0


nbEtpBest = math.inf
LabyrintheBest = copy.deepcopy(Labyrinthe)

def chercherBest(A, e, nbEtp):
    global nbEtpBest, LabyrintheBest
    
    if A[0] == e[0] and A[1] == e[1]:
        if(nbEtp < nbEtpBest):
            nbEtpBest = nbEtp; LabyrintheBest = copy.deepcopy(Labyrinthe)
            return
    
    for D in Direction:
        if acceptable(e, D):
            nvEtp = (e[0] + D[0], e[1] + D[1])
            Labyrinthe[nvEtp[0], nvEtp[1]] = 1
            chercherBest(A, nvEtp, nbEtp+1)
            Labyrinthe[nvEtp[0], nvEtp[1]] = 0

chercherBest(A, e, 1)
    
            