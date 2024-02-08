#include <stdio.h>

#define pscanf(message, format, data) \
    printf("%s", message); \
    scanf(format, data)


int main(int argc, char const *argv[])
{
    int number;

    pscanf("Veuillez entrer un nombre : ", "%d", &number);
    printf("Vous avez entré : %d\n", number);

    return 0;
}
