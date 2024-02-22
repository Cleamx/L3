#include <stdlib.h>
#include <stdio.h>
#include "util_rand.h"

int random_entier() {
    return rand();
}

int random_entier_seuil(int seuil_haut) {
    return rand() % (seuil_haut + 1);
}

int random_entier_bornes(int seuil_bas, int seuil_haut) {
    return seuil_bas + rand() % (seuil_haut - seuil_bas + 1);
}

double random_reel() {
    return (double)rand() / (double)RAND_MAX;
}

double random_reel_bornes(double seuil_bas, double seuil_haut) {
    return seuil_bas + ((double)rand() / (double)RAND_MAX) * (seuil_haut - seuil_bas);
}

// int main() {
//     int entier, entier_seuil, entier_bornes;
//     double reel, reel_bornes;

//     entier = random_entier();
//     printf("Nombre entier aléatoire : %d\n", entier);

//     entier_seuil = random_entier_seuil(10);
//     printf("Nombre entier aléatoire entre 0 et 10 : %d\n", entier_seuil);

//     entier_bornes = random_entier_bornes(10, 20);
//     printf("Nombre entier aléatoire entre 10 et 20 : %d\n", entier_bornes);

//     reel = random_reel();
//     printf("Nombre réel aléatoire entre 0 et 1 : %f\n", reel);

//     reel_bornes = random_reel_bornes(0.5, 1.5);
//     printf("Nombre réel aléatoire entre 0.5 et 1.5 : %f\n", reel_bornes);

//     return 0;
// }