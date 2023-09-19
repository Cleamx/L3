import matplotlib.pyplot as plt
from random import shuffle, sample
import time
from partie1 import mix_list, gen_list_random_int, extract_elements_list

listNbr = [i for i in range(100)]

def perf_list(mix_list, shuffle, listInt, n)->callable:
    time_shuffle = []
    time_mix = []
    liste = [i for i in range(100)]
    for i in listInt:
        times_shuffle = []
        times_mix = []

        for _ in range(n):

            start_pc = time.perf_counter()
            shuffle(liste)
            end_pc = time.perf_counter()
            times_shuffle.append(end_pc - start_pc)

            start_pc = time.perf_counter() 
            mix_list(liste)
            end_pc = time.perf_counter()
            times_mix.append(end_pc - start_pc)

        time_shuffle.append(sum(times_shuffle) / n)
        time_mix.append(sum(times_mix) / n)

    return (time_shuffle, time_mix)

result = perf_list(mix_list, shuffle, [5,10,20], 10)

def perf_extract(sample, extract_elements_list, listInt, n, int_nbr_of_element_to_extract):
    time_extract = []
    time_sample = []
    liste = [i for i in range(100)]

    for i in listInt:
        times_extract = []
        times_sample = []

        for _ in range(n):
            start_pc = time.perf_counter()
            extract_elements_list(liste,int_nbr_of_element_to_extract)
            end_pc = time.perf_counter()
            times_extract.append(end_pc - start_pc)

            start_pc = time.perf_counter() 
            sample(liste,int_nbr_of_element_to_extract)
            end_pc = time.perf_counter()
            times_sample.append(end_pc - start_pc)

        time_extract.append(sum(times_extract) / n)
        time_sample.append(sum(times_sample) / n)

    return (time_extract, time_sample)

resultDeux = perf_extract(sample, extract_elements_list,listNbr, 100, 5 )




# -------------- Affichage ---------------
x_axis_list = [5,10,20]
fig, ax = plt.subplots()

ax.plot(x_axis_list,result[0],'bo-',label='Shuffle') 
ax.plot(x_axis_list,result[1], 'r*-', label='Mix') 
ax.set(xlabel='Taille de la liste', ylabel='Temps (s)', title="Comparaison temps fonction") 
ax.legend(loc='upper center', shadow=True, fontsize='x-large') 
#fig.savefig("test.png")
plt.show()

x_axis_list = listNbr
fig, ax = plt.subplots()

ax.plot(x_axis_list,resultDeux[0],'bo-',label='extract') 
ax.plot(x_axis_list,resultDeux[1], 'r*-', label='sample') 
ax.set(xlabel='Taille de la liste', ylabel='Temps (s)', title="Comparaison temps fonction") 
ax.legend(loc='upper center', shadow=True, fontsize='x-large') 
#fig.savefig("test.png")
plt.show()