#include <stdio.h>
#include <ncurses.h>

/*
 * Fonction : chiffrementCesar
 * ---------------------------
 *   Chiffre une chaîne de caractères en utilisant le chiffrement de César.
 *
 *   str : la chaîne de caractères à chiffrer.
 *   key : la clé à utiliser pour le chiffrement (le décalage de caractères).
 *
 *   returns : la chaîne de caractères chiffrée.
 */
void chiffrementCesar(char str[], int key);

/*
 * Fonction : dechiffrer
 * ---------------------------
 *   Déchiffre une chaîne de caractères en utilisant le chiffrement de César.
 *
 *   str : la chaîne de caractères à chiffrer.
 *   key : la clé à utiliser pour le dechiffrement (le décalage de caractères).
 *
 *   returns : la chaîne de caractères dechiffré.
 */
void dechiffrer(char str[], int key);

int main(int argc, char const *argv[])
{
    char mot[100];
    int cle = 2;
    
    initscr();              
    printw("Entrez la clé de chiffrement : \n");
    scanw("%d", &cle);
    

    refresh();             
    getch();                
    endwin();

    // printf("Entrez un mot à chiffrer : \n");
    // scanf("%s", mot);

    // printf("Entrez la clé de chiffrement : \n");
    // scanf("%d", &cle);

    // printf("\nVoici le mot chiffrer : ");
    // chiffrementCesar(mot, cle);

    // printf("\nVoici le mot dechiffrer : ");
    // dechiffrer(mot, cle);

    return 0;
}

void chiffrementCesar(char str[], int key)
{
    int i = 0;

    while (str[i] != '\0')
    {
        str[i] += key;

        i++;
    }
    printf("%s", str);
}

void dechiffrer(char str[], int key)
{
    int i = 0;

    while (str[i] != '\0')
    {
        str[i] -= key;
        i++;
    }
    printf("%s", str);
}