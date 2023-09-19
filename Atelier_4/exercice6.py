from partie1 import gen_list_random_int
import time
import matplotlib.pyplot as plt

lst = [5,10,20]

def sort_list(liste:lst) -> list:
    """fonction qui permet de trier la liste en ordre croissant

    Args:
        liste (list): liste à trier

    Returns:
        list: liste trier dans l'ordre croissant
    """
    lst_sorted = list(liste)

    for i in range(len(lst_sorted)):
        min_index = i
        for j in range(i+1, len(lst_sorted)):
            if lst_sorted[j] < lst_sorted[min_index]:
                min_index = j
        lst_sorted[i], lst_sorted[min_index] = lst_sorted[min_index], lst_sorted[i]

    return lst_sorted

def perf_list(sort_list, sorted, listInt, n)->tuple:
    """calcule le temps que mettent sort_list et sorted à s'exécuter

    Args:
        sort_list (callable): ma fonction 
        sorted (callable): fonciton python
        listInt (list): tailles de liste pour lesquelles on effectue la comparaison
        n (_type_): nombre d’exécution moyen nécessaire au calcul de la moyenne des temps

    Returns:
        tuple: liste des temps d’exécution moyens pour chacune de ces tailles de liste
    """
    time_sorted = []
    time_sort_lst = []
    for i in listInt:
        times_sorted = []
        times_sort_lst = []
        liste = gen_list_random_int(i)

        for _ in range(n):

            start_pc = time.perf_counter()
            sorted(liste)
            end_pc = time.perf_counter()
            times_sorted.append(end_pc - start_pc)

            start_pc = time.perf_counter() 
            sort_list(liste)
            end_pc = time.perf_counter()
            times_sort_lst.append(end_pc - start_pc)

        time_sorted.append(sum(times_sorted) / n)
        time_sort_lst.append(sum(times_sort_lst) / n)

    return (time_sorted, time_sort_lst)

result = perf_list(sort_list, sorted, lst, 10)
print(sort_list(lst))
print(result)

# ------------- Affichage --------------

x_axis_list = lst
fig, ax = plt.subplots()

ax.plot(x_axis_list,result[0],'bo-',label='sorted') 
ax.plot(x_axis_list,result[1], 'r*-', label='sort_list') 
ax.set(xlabel='Taille de la liste', ylabel='Temps (s)', title="Comparaison temps fonction") 
ax.legend(loc='upper center', shadow=True, fontsize='x-large') 
#fig.savefig("test.png")
plt.show()