#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Oct 23 08:38:17 2023

@author: clementinemirande
"""

import numpy as np


sudoku = np.loadtxt("sdku.txt")
cases = np.where(sudoku==0)
trouve = False
    
def bloc(Mat, i, j):
    L = []
    for x in range(3*(i//3), 3*(i//3)+3) :
        for y in range(3*(j//3), 3*(j//3)+3) :
            if Mat[x,y] != 0:
                L.append(Mat[x,y])
    return L

def conflits(Mat, i, j):
    L = [x for x in sudoku[i,:] if x > 0]
    L = L + [x for x in sudoku[:,j] if x > 0]
    L = L + bloc(Mat, i, j)
    return set(L)


def fill_sudoku(num):
    global compter
    global sudoku, cases, trouve
    
    compter += 1
    if num == len(cases[0]):
        trouve = True
        return
    
    conf = conflits(sudoku, cases[0][num], cases[1][num])
    for e in range(1,10):
        if e not in conf:
            sudoku[cases[0][num], cases[1][num]] = e
            fill_sudoku(num+1)
            if trouve:
                return
            sudoku[cases[0][num], cases[1][num]] = 0
            
compter = 0
E = fill_sudoku(0)
"""
possibilite = []
for x, y in zip(cases[0], cases[1]): 
    possibilite.append(conflits(sudoku, x, y))

L = [ind for ind in range(len(possibilite)) if len(possibilite[ind]) == 8]
    """