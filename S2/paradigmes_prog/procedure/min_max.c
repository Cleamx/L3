#include <stdio.h>
//gcc -Wall -pedantic -c min_max.c 

void get_min_max_1(double tab[], int nb_elements, double *min, double *max);


int main(int argc, char const *argv[])
{
    double tab[] = {1,2,3,4,5,6,7,8,9,10};
    int taille = sizeof(tab)/sizeof(tab[0]);
    double min, max;

    printf("taille = %d \n", taille);

    get_min_max_1(tab, taille, &min, &max);
    printf("le min = %f et le max = %f\n", min, max);

    return 0;
}

void get_min_max_1(double tab[], int nb_elements, double *min, double *max)
{

    *min = tab[0];
    *max = tab[0];

    for (int j = 0; j < nb_elements; j++)
    {
        if (tab[j] > *max)
        {
            *max = tab[j];
        }
        else if (tab[j] < *min)
        {
            *min = tab[j];
        }
    }
}
