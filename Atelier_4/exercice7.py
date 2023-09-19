from exercice6 import sort_list
from partie1 import mix_list

def stupid_sort(lst_to_sort:list)->list:
    """fonction qui mélange une liste tant qu'elle n'est pas triée

    Args:
        lst_to_sort (list): liste à trier

    Returns:
        list: liste triée
    """
    count = 0

    while lst_to_sort != sort_list(lst_to_sort):
        lst_to_sort = mix_list(lst_to_sort)
        count += 1
        print("nombre de fois mélanger", count)
    
    return lst_to_sort

print(stupid_sort([1,2]))

def insertion_sort(list_to_sort: list)->list:
    """fonction qui 

    Args:
        list_to_sort (list): _description_

    Returns:
        list: _description_
    """
    list_to_sort1 = list(list_to_sort)
    
    for i in range (len(list_to_sort1)):
        x = list_to_sort1[i]
        j = i
        while j > 0 and list_to_sort1[j - 1] > x:
            list_to_sort1[j] = list_to_sort1[j - 1]
            j = j-1
        list_to_sort1[j] = x
    
    return list_to_sort1

my_lst_to_sort = [170, 45, 75, 90, 2, 24, 802, 66]
print(insertion_sort(my_lst_to_sort))