#include <stdio.h>

void add(int a, int b, int *c);

int main() {

    int a, b, c;

    printf("Entrez le 1er nombre : ");
    scanf("%d", &a);

    printf("Entrez le 2eme nombre : ");
    scanf("%d", &b);

    add(a, b, &c);
    printf("Le résultat de l'addition entre %d et %d est : %d\n", a, b, c);
    
    return 0;
}

void add(int a, int b, int *c) {
    *c = a + b;
}