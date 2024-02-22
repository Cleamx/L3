#include <stdio.h>


void convertirEnRomains(int num);
void convertirEnRomainsModernes(int num);



int main() {
    int num;
    printf("Entrez un nombre entier : ");
    scanf("%d", &num);
    printf("Ancienne notation : ");
    convertirEnRomains(num);
    printf("\n");
    printf("Notation moderne : ");
    convertirEnRomainsModernes(num);
    printf("\n");
    return 0;
}

void convertirEnRomains(int num) {
    while(num >= 1000) {
        printf("M");
        num -= 1000;
    }
    while(num >= 500) {
        printf("D");
        num -= 500;
    }
    while(num >= 100) {
        printf("C");
        num -= 100;
    }
    while(num >= 50) {
        printf("L");
        num -= 50;
    }
    while(num >= 10) {
        printf("X");
        num -= 10;
    }
    while(num >= 5) {
        printf("V");
        num -= 5;
    }
    while(num >= 1) {
        printf("I");
        num -= 1;
    }
}

void convertirEnRomainsModernes(int num) {
    while(num >= 1000) {
        printf("M");
        num -= 1000;
    }
    if(num >= 900) {
        printf("CM");
        num -= 900;
    }
    while(num >= 500) {
        printf("D");
        num -= 500;
    }
    if(num >= 400) {
        printf("CD");
        num -= 400;
    }
    while(num >= 100) {
        printf("C");
        num -= 100;
    }
    if(num >= 90) {
        printf("XC");
        num -= 90;
    }
    while(num >= 50) {
        printf("L");
        num -= 50;
    }
    if(num >= 40) {
        printf("XL");
        num -= 40;
    }
    while(num >= 10) {
        printf("X");
        num -= 10;
    }
    if(num >= 9) {
        printf("IX");
        num -= 9;
    }
    while(num >= 5) {
        printf("V");
        num -= 5;
    }
    if(num >= 4) {
        printf("IV");
        num -= 4;
    }
    while(num >= 1) {
        printf("I");
        num -= 1;
    }
}