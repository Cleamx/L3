import numpy as np


arr = np.array([1, 2, 3, 4, 5, 4, 4])
print(arr)

def my_searchsorted (table : object, element : int)-> int:
    """fonction qui cherche l'indice d'un élément d'une matrice

    Args:
        table (object): table d'élément
        indice (int): element recherchée

    Returns:
        int: indice de l'élément rechercher
    """
    for i in table:
        if element == table[i]:
            return i

print(my_searchsorted(arr,4))

def my_where(table : object, element : int )-> list:
    """fonction qui cherche l'indice d'un élément d'une matrice et retourne une liste d'un ou plusieurs indices

    Args:
        table (object): table d'élément
        indice (int): element rechercher

    Returns:
        list: liste d'un ou plusieurs élément 
    """
    res = []
    for i in range(len(table)):
        if element == table[i]:
            res.append(i)
    return res 

# print(my_where(arr, 4))

A = np.array(([3,1,],[6,4])) 
B = np.array(([1,8],[4,2]))

def my_add(tableA : object, tableB : object)-> object:
    """fonction qui permet d'additionner deux matrice

    Args:
        tableA (object): matrice a
        tableB (object): matrice b

    Returns:
        object: matrice a+b
    """
    if tableA.shape == tableB.shape:
        res = A + B
    return res

# print(my_add(A,B))