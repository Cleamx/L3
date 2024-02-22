#ifndef UTIL_RAND_H
#define UTIL_RAND_H

int random_entier();
int random_entier_seuil(int seuil_haut);
int random_entier_bornes(int seuil_bas, int seuil_haut);
double random_reel();
double random_reel_bornes(double seuil_bas, double seuil_haut);

#endif