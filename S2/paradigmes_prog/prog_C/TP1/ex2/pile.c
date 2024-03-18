#include <stdlib.h>
#include <stdio.h>

#define ERREUR_PILE_VIDE -1

typedef struct Noeud {
    int donnee;
    struct Noeud* suivant;
} Noeud;

typedef struct Pile {
    Noeud* sommet;
} Pile;

/* Créer une nouvelle pile */
Pile* creer_pile() {
    Pile* pile = malloc(sizeof(Pile));
    pile->sommet = NULL;
    return pile;
}

/* Tester si la pile est vide */
int est_vide(Pile* pile) {
    return pile->sommet == NULL;
}

/* Empiler un nouvel élément de type entier */
void empiler(Pile* pile, int donnee) {
    Noeud* nouveau_noeud = malloc(sizeof(Noeud));
    nouveau_noeud->donnee = donnee;
    nouveau_noeud->suivant = pile->sommet;
    pile->sommet = nouveau_noeud;
}

/* Récupérer la valeur de l’élément de sommet de pile */
int sommet(Pile* pile) {
    if (est_vide(pile)) {
        printf("La pile est vide.\n");
        return ERREUR_PILE_VIDE;
    }
    return pile->sommet->donnee;
}

/* Récupérer la valeur et enlever l’élément de sommet de pile */
int depiler(Pile* pile) {
    if (est_vide(pile)) {
        printf("La pile est vide.\n");
        return ERREUR_PILE_VIDE;
    }
    int donnee = pile->sommet->donnee;
    Noeud* temp = pile->sommet;
    pile->sommet = pile->sommet->suivant;
    free(temp);
    return donnee;
}