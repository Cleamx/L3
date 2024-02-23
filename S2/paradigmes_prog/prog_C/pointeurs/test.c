#include <stdio.h>
#include <stdlib.h>

int main(int argc, char const *argv[])
{
    int a = 10;
    int b = 20;
    void *ptA = NULL;
    void *ptB = NULL;
    void *ptC = NULL; 
    
    ptC = (int*) malloc(sizeof(int));
    ptA = &a;
    ptB = &b;

    *(int*)ptC = *(int*)ptA;
    *(int*)ptA = *(int*)ptB;
    *(int*)ptB = *(int*)ptC;

    printf("a = %d et b = %d", a, b);


    free(ptC);

    return 0;
}