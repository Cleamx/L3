from random import *

def gen_list_random_int(nbmax = 10, int_binf=0, int_bsup=10)->list:

    int_nbr = []
    i = 0

    while i < nbmax:
        int_nbr.append(randint(int_binf,int_bsup-1))
        i+=1
    
    return int_nbr

print(gen_list_random_int())


def mix_list(int_nbr_of_element_to_extract:list)->list:
    list_nbAleatoire = []
    extrated_list = []

    for i in range(len(int_nbr_of_element_to_extract)):
        nbAleatoire = randint(0, len(int_nbr_of_element_to_extract)-1)
        if nbAleatoire not in list_nbAleatoire:
            extrated_list.append(int_nbr_of_element_to_extract[nbAleatoire])
            list_nbAleatoire.append(nbAleatoire)
        else:
            while nbAleatoire in list_nbAleatoire:
                nbAleatoire = randint(0, len(int_nbr_of_element_to_extract)-1)
            extrated_list.append(int_nbr_of_element_to_extract[nbAleatoire])
            list_nbAleatoire.append(nbAleatoire)
    return extrated_list


lst_sorted=[i for i in range(10)]
res = mix_list(lst_sorted)
print(res)

def choose_element_list(list_in_which_to_choose:list)-> int:
    nbAleatoire = randint(0, len(list_in_which_to_choose)-1)
    return list_in_which_to_choose[nbAleatoire]

print(choose_element_list(res))

def extract_elements_list(list_in_which_to_choose:list, int_nbr_of_element_to_extract:int)->list:

    list_nbAleatoire = []
    extrated_list = []

    for i in range(int_nbr_of_element_to_extract):
        nbAleatoire = randint(0, len(list_in_which_to_choose)-1)
        if nbAleatoire not in list_nbAleatoire:
            extrated_list.append(list_in_which_to_choose[nbAleatoire])
            list_nbAleatoire.append(nbAleatoire)
        else:
            while nbAleatoire in list_nbAleatoire:
                nbAleatoire = randint(0, len(list_in_which_to_choose)-1)
            extrated_list.append(list_in_which_to_choose[nbAleatoire])
            list_nbAleatoire.append(nbAleatoire)
    return extrated_list

print(extract_elements_list(lst_sorted,5))