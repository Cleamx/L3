#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Dec  7 14:34:22 2023

@author: clementinemirande
"""

import numpy as np

lab = np.loadtxt("Laby.txt")
D = (0,0) ; A = (lab.shape[0]-1, lab.shape[1]-1)
Trouve = False
Direction = [[1,0],[0,1],[-1,0],[0,-1]]

def accepte(e,d):
    global lab
    x = e[0]+ d[0]; y = e[1] + d[1]
    if x < 0 : return False
    if x >= lab.shape[0] : return False
    if y < 0 : return False
    if y >= lab.shape[1] : return False
    if lab[x,y] != 0 : False
    return True

def recherche(e):
    global lab, D, A, Trouve, Direction
    if e == A: 
        lab[e] = 1
        Trouve = True; return
    for d in Direction:
        if accepte(e, d):
            lab[e] = 1
            recherche((e[0]+ d[0], e[1] + d[1]))
            if Trouve : return
            lab[e] = 0
        
res = recherche(D)
            
