#ifndef MIRANDELISTEINT_H
#define MIRANDELISTEINT_H

typedef struct maillon_int {
    int val;
    struct maillon_int* p_suiv;
} maillon_int;

maillon_int* init_elt();
maillon_int* ajout_tete_v1(maillon_int* p_tete, maillon_int* p_nv_elt);
void ajout_tete_v2(maillon_int** prem, maillon_int* nouveau);
void parcourir(maillon_int* prem);
maillon_int* inserer1(maillon_int* p_tete, maillon_int* p_nv_elt);
void inserer2(maillon_int** prem, maillon_int* nouveau);
void supprimer_debut(maillon_int** prem);
maillon_int* critere_supp_un1(maillon_int* prem, int val);
void critere_supp_un2(maillon_int** prem, int val);
void detruire_liste(maillon_int** prem);
void detruire_liste2(maillon_int** prem);
void sauver_liste(maillon_int* prem);
maillon_int* load_liste();

#endif