#include <stdio.h>
#include "min_max_struct.h"


int main(int argc, char const *argv[])
{
    double tab[] = {1,2,3,4,5,6,7,8,9,10};
    int taille = sizeof(tab) / sizeof(tab[0]);
    double_paire res;

    res = get_max_and_min_2(tab, taille);

    printf("min = %f et max = %f", res.min, res.max);
    
    return 0;
}

struct min_max_struct get_max_and_min_2(double tab[], int taille)
{
    double_paire min_max;
    min_max.min = tab[0];
    min_max.min = tab[0];


    for (int j = 0; j < taille; j++)
    {
        if (tab[j] > min_max.max)
        {
            min_max.max = tab[j];
        }
        else if (tab[j] < min_max.min)
        {
            min_max.min = tab[j];
        }
    }

    return min_max;
}
