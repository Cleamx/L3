def proche_zero(L:list)->float:
    procheZeroNegatif = []
    procheZeroPos = []
    i = 0
    j = 0

    while i < len(L):
        if L[i] <= 0:
            procheZeroNegatif.append(L[i])
        elif L[i]> 0:
            procheZeroPos.append(L[i])
        i+=1
    
    res = max(procheZeroNegatif)
    res2 = min(procheZeroPos)

    if res > -res2:
        fin = res
    else:
        fin = res2
    return fin
            
print(proche_zero([7,-10,13,8,4,-1.2,1,2,3,-2]))