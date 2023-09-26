def  listeMultiples(binf : int, bsup : int, nb:int )->list:
    lst=list(range(binf,bsup))
    lst_res= [nb*lst[x-1] for x in lst] 
    return lst_res

def test():
    
    res_lst_multiple = listeMultiples(1,4,2)
    print(res_lst_multiple)

test()