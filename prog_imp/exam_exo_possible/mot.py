#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Dec 18 10:51:09 2023

@author: clementinemirande
"""

import numpy as np

"""
Mot1 = '-DISTANCES'
Mot2 = '-DETENTES'

PLSS = np.zeros((len(Mot1), len(Mot2)))

for m in range(1, len(Mot1)):
    for n in range(1, len(Mot2)):
        PLSS[m,n] = max(PLSS[m-1, n], PLSS[m,n-1], PLSS[m-1,n-1] + int(Mot1[m] == Mot2[n]))
"""


Gen1 = '-ACTGACC'
Gen2 = '-AGTCAC'

d = np.zeros((len(Gen2), len(Gen1)))
for i in range(1, len(Gen2)) : d[i,0] = i
for j in range(1, len(Gen1)) : d[0,j] = j

for m in range(1, len(Gen2)):
    for n in range(1, len(Gen1)):
        if Gen2[m] == Gen1[n]:
            plus = 0
        else:
            plus = 1
            
        d[m,n] = min(d[m-1,n]+1, d[m,n-1]+1, d[m-1, n-1]+plus)
        