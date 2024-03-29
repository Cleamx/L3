#ifndef PILE_H
#define PILE_H

#include <stdlib.h>
#include <stdio.h>

typedef struct Noeud {
    int donnee;
    struct Noeud* suivant;
} Noeud;

typedef struct Pile {
    Noeud* sommet;
} Pile;

Pile* creer_pile();
int est_vide(Pile* pile);
void empiler(Pile* pile, int donnee);
int sommet(Pile* pile);
int depiler(Pile* pile);

#endif 