#include <stdio.h>

#define cube(x) (x * x * x)

int carre(int num);

int main() {
    int nombre = 5;
    printf("Le carré de %d est %d\n", nombre, carre(nombre));
    printf("Le cube de %d est %d\n", nombre, cube(nombre));
    return 0;
}


int carre(int num) {
    return num * num;
}