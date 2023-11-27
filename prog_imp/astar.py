#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Nov 27 15:53:42 2023

@author: clementinemirande
"""
import numpy as np
import math
reseau = np.loadtxt('Astar.txt')
fp = open('Astar.txt')
noms = fp.readline().split()[:-1]
fp.close()
noms[0] = noms[0][1:]
chemins = [[math.inf, reseau[i][-1], None] for i in range(len(noms))]


