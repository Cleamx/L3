#include <stdio.h>

int main(int argc, char const *argv[])
{
    char ch1, ch2, ch3;

    printf("Entrez trois characteres\n");
    scanf("%c %c %c", &ch1, &ch2, &ch3);

    printf("Voici les trois characteres %c %c %c\n", ch1, ch2, ch3);

    return 0;
}
