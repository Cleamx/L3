#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

int isNumber(const char *str);

int main(int argc, char *argv[]) 
{
    int sum = 0;

    // Vérifier nbr argument
    if (argc < 3) 
    {
        printf("Veuillez entrer au moins deux paramètres.\n");
        printf("./sum param1 param2\n");
        return 1;
    }

    for (int i = 1; i < argc; i++) 
    {
        if (!isNumber(argv[i])) 
        {
            printf("Il y a un problème avec l'argument %d, %s.\n",i, argv[i]);
            printf("Il n'a pas pu être transformé en int. Veuillez réessayer !\n");
            return 1;
        }
        sum += atoi(argv[i]);
    }

    printf("%d\n", sum);

    return 0;
}

int isNumber(const char *str) 
{
    for (int i = 0; str[i] != '\0'; i++) 
    {   
        if (!isdigit(str[i])) 
        {
            return 0;
        }
    }
    return 1;
}