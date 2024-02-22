#include <stdio.h>
#include <stdlib.h>

int main() {
    char *pc = (char *) malloc(sizeof(char));
    int *pi = (int *) malloc(sizeof(int));
    float *pf = (float *) malloc(sizeof(float));
    char quit;

    do {
        printf("Entrez un caractère : ");
        scanf(" %c", pc);
        printf("Entrez un entier : ");
        scanf("%d", pi);
        printf("Entrez un float : ");
        scanf("%f", pf);

        printf("Vous avez entré : %c, %d, %f\n", *pc, *pi, *pf);

        printf("Appuyez sur 'q' pour quitter, ou toute autre touche pour continuer : ");
        scanf(" %c", &quit);
    } while (quit != 'q');

    free(pc);
    free(pi);
    free(pf);

    return 0;
}