#include <stdio.h>
#include <stdlib.h>
#include "pile.h"

int main() {
    // Créer une nouvelle pile
    Pile* ma_pile = creer_pile();

    empiler(ma_pile, 1);
    empiler(ma_pile, 2);
    empiler(ma_pile, 3);

    // Créer une pile temporaire pour afficher les valeurs
    Pile* pile_temp = creer_pile();

    // Afficher les valeurs de la pile
    printf("Pile d'origine: ");
    while (!est_vide(ma_pile)) {
        int valeur = depiler(ma_pile);
        printf("%d ", valeur);
        empiler(pile_temp, valeur);
    }
    printf("\n");
    
    if(est_vide(ma_pile)){
        printf("La pile est vide");
    }

    // Remettre les valeurs dans la pile originale
    while (!est_vide(pile_temp)) {
        empiler(ma_pile, depiler(pile_temp));
    }

    // Créer une autre pile pour renverser la première
    Pile* pile_inverse = creer_pile();

    // Déplacer tous les éléments de la première pile à la deuxième
    while (!est_vide(ma_pile)) {
        empiler(pile_inverse, depiler(ma_pile));
    }

    // Afficher la valeur du sommet de la pile renversée
    printf("premier element de la pile renverse: %d\n", sommet(pile_inverse));

    // Dépiler et afficher les valeurs de la pile renversée
    printf("Pile renverse: ");
    while (!est_vide(pile_inverse)) {
        printf("%d ", depiler(pile_inverse));
    }

    printf("\n");

    free(pile_inverse);

    return 0;
}