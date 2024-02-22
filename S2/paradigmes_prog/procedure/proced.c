#include <stdio.h>

int swap(int *a, int *b)
{
    int temp;
    
    temp = *a;
    *a = *b;
    *b = temp;
}

int main(int argc, char const *argv[])
{
    int a = 20;
    int b = 10;

    swap(&a, &b);

    printf("a = %d et b = %d", a, b);
    
    return 0;
}
