#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int lancerDe();

int main() {
    srand(time(NULL));
    int choix, total, max, seuil;

    do {
        printf("\nMenu :\n");
        printf("1. Jouer avec un dé\n");
        printf("2. Jouer avec deux dés\n");
        printf("3. Jouer avec trois dés\n");
        printf("4. Jouer avec quatre dés\n");
        printf("0. Quitter\n");
        printf("Votre choix : ");
        scanf("%d", &choix);

        if (choix >= 1 && choix <= 4) {
            total = 0;
            max = choix * 6;
            seuil = (max * 2) / 3;

            for (int i = 0; i < choix; i++) {
                int de = lancerDe();
                printf("Dé %d : %d\n", i + 1, de);
                total += de;
            }

            printf("Total : %d\n", total);

            if (total > seuil) {
                printf("Vous avez gagné avec %d points en plus !\n", total - seuil);
            } else if (total == seuil) {
                printf("Vous avez juste atteint le seuil pour gagner.\n");
            } else {
                printf("Vous avez perdu. Il vous manque %d points pour gagner.\n", seuil - total);
            }
        }
    } while (choix != 0);

    return 0;
}

int lancerDe() {
    return rand() % 6 + 1;
}