#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Oct 17 15:46:20 2023

@author: clementinemirande
"""

#import numpy as np 
import math
#import copy

Tab = [-1] * 8
trouve = False

def acceptable(e, numReine):
    if e in Tab :
        return False
    for ind in range(len(Tab)):
        if Tab[ind] == -1: 
            return True
        if abs(ind - numReine) == abs(Tab[ind] - e):
            return False
    return True
        

def placerReine(numReine):
    global trouve
    if numReine == 8:
        trouve = True
        return
    for e in range(8):
        if acceptable(e, numReine):
            Tab[numReine] = e
            placerReine(numReine+1)
            if trouve == True:
                return
            Tab[numReine] = -1
    

placerReine(0)