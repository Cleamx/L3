#include <stdio.h>
#include "util_rand.h"

#define NB_TIRAGES 100000

void tirage() 
{
    int compteur[6] = {0}; 

    for (int i = 0; i < NB_TIRAGES; i++) 
    {
        int nombre = random_entier_seuil(5); 
        compteur[nombre]++; 
    }

    for (int i = 0; i < 6; i++) 
    {
        double pourcentage = (double)compteur[i] / NB_TIRAGES * 100;
        printf("Nombre %d : %.2f%%\n", i, pourcentage);
    }
}

int main() {
    tirage();
    return 0;
}