#include <stdio.h>
#include <stdlib.h>

void empoisonner(int *pv, int *poison);

int main(int argc, char const *argv[])
{
    int pv_perso = 100;
    int nocivite_poison = 10;

    empoisonner(&pv_perso, &nocivite_poison);
    printf("Le personnage a %d pv et la cigue est au niveau %d", pv_perso, nocivite_poison);

    return 0;
}

void empoisonner(int *pv, int *poison)
{
    *pv = *pv - *poison;
    *poison = *poison - 1;

    if (*poison <= 0)
    {

        *poison = (rand() % 20) + 1;
    }
}