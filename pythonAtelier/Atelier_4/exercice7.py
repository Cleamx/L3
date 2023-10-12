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
    """fonction qui trie la liste en décalant vers la droite les éléments
    qui sont plus grands que x

    Args:
        list_to_sort (list): liste à trier

    Returns:
        list: liste triée
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

def selection_sort(list_to_sort: list)->list:
    """fonction qui recherche dans la partie de la liste non triée le min
    et place le min à la fin de la partie triée de la liste 

    Args:
        list_to_sort (list): liste à trier

    Returns:
        list: liste triée ordre croissant
    """

    for i in range(len(list_to_sort)):
        min_index = i
        for j in range(i+1, len(list_to_sort)):
            if list_to_sort[j] < list_to_sort[min_index]:
                min_index = j
        if min_index != i:
            list_to_sort[i], list_to_sort[min_index] = list_to_sort[min_index], list_to_sort[i]
    
    return list_to_sort

print(selection_sort(my_lst_to_sort))

def buble_sort(list_to_sort: list)->list:
    """fonction qui parcourt la liste et compare les éléments consécutifs. 
    Lorsque deux éléments consécutifs ne sont pas dans l'ordre convenu 
    (croissant), ils sont échangés.

    Args:
        list_to_sort (list): liste à trier

    Returns:
        list: liste triée
    """
    
    for i in range(len(my_lst_to_sort)):
        for j in range (i-1):
            if my_lst_to_sort[j+1] < my_lst_to_sort[j]:
                list_to_sort[j+1], list_to_sort[j] = list_to_sort[j], list_to_sort[j+1]
    
    return list_to_sort

print(buble_sort(my_lst_to_sort))

def tri_fusion(list_to_sort: list)->list:
    """Trie une liste d'éléments en utilisant l'algorithme de tri fusion

    Args:
        list_to_sort (list): Liste à trier

    Returns:
        list: liste trier
    """
    if len(list_to_sort) <= 1:
        return list_to_sort


    milieu_liste = len(list_to_sort) // 2
    liste_droite = list_to_sort[:milieu_liste]
    liste_gauche = list_to_sort[milieu_liste:]
    liste_droite = tri_fusion(liste_droite)
    liste_gauche = tri_fusion(liste_gauche)

    liste_triee = []
    i = j = 0
    taille_liste_droite = len(liste_droite)
    taille_liste_gauche = len(liste_gauche)

    while i < taille_liste_droite and j < taille_liste_gauche :
        if liste_droite[i] < liste_gauche[j]:
            liste_triee.append(liste_droite[i])
            i+=1
        else:
            liste_triee.append(liste_gauche[j])
            j+=1
        
    while i < len(liste_droite):
        liste_triee.append(liste_droite[i])
        i += 1
    
    while j < len(liste_gauche):
        liste_triee.append(liste_gauche[j])
        j += 1

    return liste_triee

print(tri_fusion(my_lst_to_sort))
