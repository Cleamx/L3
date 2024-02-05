#include <stdio.h>

int main(int argc, char const *argv[])
{
    int *pt_int;
    int un_int = 5;

    printf("Valeur du pointeur pt_int à la déclaration %p\n", pt_int);

    pt_int = NULL;
    printf("Valeur du pointeur après assignation a NULL %p\n", pt_int);

    pt_int = &un_int;
    printf("Verification du fait que la val de pt_int %p et l'adresse de un_int %p sont les mêmes\n", pt_int, &un_int);
    printf("Verification du fait que la val un_int %i et la valeur de l'objet pointé par pt_int %i sont les mêmes\n", un_int, *pt_int);

    *pt_int = 2;

    printf("Verification du fait que la val de un_int %i et donc de l'objet pointé par pt_int %i ont bien été modifiés\n", un_int, *pt_int);

    return 0;
}
