#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 13:54:35 2023

@author: clementinemirande
"""
import numpy as np
sudoku = np.loadtxt('Sudoku.txt')
cases = np.where(sudoku == 0)

def accepte(e,i):
    global sudoku, cases
    x = cases[0][e] ; y = cases[1][e]
    if i in sudoku[:,y] : return
    if i in sudoku[x, :] : return
    A = (x // 3)*3 ; B = (y // 3) * 3
    if i in sudoku [A:A+3, B:B+3] : return False
    return True

def fill(e):
    global sudoku, cases, Trouve
    if e == len(cases[0]):
        Trouve = True; return
    for i in range(1, len(sudoku)+1):
        if accepte(e, i):
            x = cases[0][e] ; y = cases[1][e]
            sudoku[x,y] = i
            fill(e+1)
        if Trouve : return