#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Dec 12 13:42:04 2023

@author: clementinemirande
"""
import numpy as np
import math
import copy

reseau = np.loadtxt('Reseau.txt')
Trouve = False
D = 0; A = 5
Route = [D]; km = 0
bestRoute = []; bestKm = math.inf

def accepte(e,s):
    global reseau, Route
    if reseau[e,s] == 0:
        return False
    if s in Route : 
        return False
    return True

def chemin(e):
    global reseau, Trouve, Route
    if e == A:
        Trouve == True; return
        for s in range(len(reseau)):
            if accepte(e, s):
                Route.append(s)
                chemin(s)
                if Trouve : return
                del Route[-1]
                
def BestChemin(e):
    global reseau, Route, km, bestRoute, bestKm
    if e == A:
        if km < bestKm:
            bestRoute = copy.deepcopy(Route); bestKm = km
        return
    for s in range(len(reseau)):
        if accepte(e,s):
            Route.append(s)
            km += reseau[e,s]
            BestChemin(s)
            km -= reseau[e,s]
            del Route[-1]
    
BestChemin(0)