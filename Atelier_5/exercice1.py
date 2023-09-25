import numpy as np

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

def my_add(tableA : object, tableB : object)-> object:
    """fonction qui permet d'additionner deux matrice

    Args:
        tableA (object): matrice a
        tableB (object): matrice b

    Returns:
        object: matrice a+b
    """
    if tableA.shape == tableB.shape :
        for L in range(len(tableA)):
             for col in range(len(tableA)):
                tableA[L, col] += tableB[L, col]
    return tableA


def test():

    arr = np.array([1, 2, 3, 4, 5, 4, 4])
    print("Matrice:", arr)
    print("---------------------------")

    # Test de my_searchsorted
    search_element = 4
    index = my_searchsorted(arr, search_element)
    if index != -1:
        print("L'indice de ", search_element, " est ", index)
    else:
        print("L'élément chercher n'est pas dans la matrice")
    print("---------------------------")

    # Test de my_where (décommentez la ligne ci-dessous si vous souhaitez l'exécuter)
    indices = my_where(arr, search_element)
    print("Le ou les indices de ", search_element, " est/sont ", indices)
    print("---------------------------")

    A = np.array([[3, 1], [6, 4]])
    B = np.array([[1, 8], [4, 2]])

    print("Matrix A:")
    print(A)
    print("Matrix B:")
    print(B)

    # Test de my_add
    result = my_add(A, B)
    print("Result of matrix addition:")
    print(result)
    print("---------------------------")

# Appeler la fonction de test
test()