#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 09:07:55 2023

@author: clementinemirande
"""

import numpy as np

lenght = 20; deep = 20 ; percent = 0.42


def createSol(lenght, deep, percent):
    sol = np.zeros((lenght, deep))
    
    """
    indices = []
    for x in range(lenght):
        for y in range(deep):
            indices.append((x, y))"""
            
    nbPo = int(lenght * deep * percent)
    indPo = np.random.choice(lenght*deep, nbPo, replace = False)
    for i in indPo:
        sol[i//lenght, i%lenght] = 1
        
        """
        x = indices[i][0]; y = indices[i][1]
        sol[x][y] = 1
        """

    return sol

def acceptable(x, y):
    global lenght, deep, sol
    if (y == lenght) or (y == -1) : return False
    if x == deep: return False
    if sol[x, y] != 0: return False
    return True
    
def infilatration(x,y):
    global sol

    for D in [(1,0), (0,1),(0, -1)]:
        if acceptable(x+D[0], y+D[1]):
            sol[x+D[0], y+D[1]] = 2
            infilatration(x+D[0], y+D[1])
    return sol

def infiltrations():
    for y in range(lenght):
        if sol[0,y] == 0:
            infilatration(0, y)


sol = createSol(lenght, deep, percent)
Lzero = [(0,y) for y in range(lenght) if sol[0,y] == 0]

res = infiltrations()














    