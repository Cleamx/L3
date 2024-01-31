// test de gcc -E cc.c -o cc.e
// cat cc.e

// test de gcc -S cc.c 
// cat cc.s

#include <stdio.h>
#include <ncurses.h>

#define VALEUR 50
// #define VALEUR 100
int main() {
    int variable = VALEUR;
    printf("La valeur de la variable est %d\n", variable);
    return 0;

}
