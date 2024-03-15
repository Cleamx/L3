#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <errno.h>

typedef struct maillon {
    int val;
    struct maillon* p_suiv;
}maillon_int;

int menu()
{
    int choix = 0;
    printf("1 Creer une liste d'entiers compris entre 0 et 20 de taille aleatoire comprise entre 1 et 20\n"
        "2 Ajouter un élément entier aléatoire (compris entre 0 et 20) en tête de liste\n"
        "3 Inserer un élément entier aléatoire dans sa place dans la liste suivant l'ordre croissant des premiers éléments\n"
        "4 Supprimer l'élément de tête\n"
        "5 Supprimer tous les maillons d'une valeur donnee\n"
        "6 Detruire liste\n"
        "7 Sauver la liste courante en binaire dans le fichier \"saveliste.bin\"\n"
        "8 Charger une liste depuis le fichier \"savelist.bin\"\n");

    scanf("%d", &choix);
    rewind(stdin);

    return choix;
}

/* Initialise un nouvel élément de type maillon_int avec une valeur aléatoire entre 0 et 20
@input : void
@output : maillon_int*, pointeur vers le nouvel élément
@precondition : aucune
@postcondition : un nouvel élément de type maillon_int est créé avec une valeur aléatoire entre 0 et 20
*/
maillon_int* init_elt()
{
    maillon_int* p_nv_elt = malloc(sizeof(maillon_int));
    p_nv_elt -> val = rand() % 21;
    p_nv_elt -> p_suiv = NULL;
    return p_nv_elt;
}

/* Ajoute un nouvel élément en tête de la liste
@input : maillon_int* p_tete, pointeur vers l'élément de tête de la liste
         maillon_int* p_nv_elt, pointeur vers le nouvel élément à ajouter
@output : maillon_int*, pointeur vers le nouvel élément de tête de la liste
@precondition : p_nv_elt est un pointeur vers un élément de type maillon_int
@postcondition : p_nv_elt est ajouté en tête de la liste, p_tete pointe vers p_nv_elt
*/
maillon_int* ajout_tete_v1(maillon_int* p_tete, maillon_int* p_nv_elt)
{
    p_nv_elt -> p_suiv = p_tete;
    p_tete = p_nv_elt;
    return p_tete;
}

/* Ajoute un nouvel élément en tête de la liste
@input : maillon_int** p_p_tete, pointeur vers le pointeur de l'élément de tête de la liste
         maillon_int* p_nv_elt, pointeur vers le nouvel élément à ajouter
@output : void
@precondition : p_nv_elt est un pointeur vers un élément de type maillon_int
@postcondition : p_nv_elt est ajouté en tête de la liste, *p_p_tete pointe vers p_nv_elt
*/
void ajout_tete_v2(maillon_int** p_p_tete, maillon_int* p_nv_elt)
{
    p_nv_elt->p_suiv = *p_p_tete;
    *p_p_tete = p_nv_elt;
}

/* Parcourt et affiche les éléments de la liste
@input : maillon_int* p_tete, pointeur vers l'élément de tête de la liste
@output : void
@precondition : aucune
@postcondition : les valeurs de tous les éléments de la liste sont affichées à l'écran
*/
void parcourir(maillon_int* p_tete)
{
    if (p_tete == NULL)
        printf("liste vide");
    else
        while (p_tete != NULL) {
            printf("%d--", p_tete->val);
            p_tete = p_tete->p_suiv;
        }
    putchar('\n');
}

/* Insère un nouvel élément dans la liste de manière à ce que la liste reste triée par ordre croissant
@input : maillon_int* p_tete, pointeur vers l'élément de tête de la liste
         maillon_int* p_nv_elt, pointeur vers le nouvel élément à ajouter
@output : maillon_int*, pointeur vers le nouvel élément de tête de la liste
@precondition : p_nv_elt est un pointeur vers un élément de type maillon_int
@postcondition : p_nv_elt est inséré dans la liste de manière à ce que la liste reste triée par ordre croissant
*/
maillon_int* inserer1(maillon_int* p_tete, maillon_int* p_nv_elt)
{
    maillon_int* n, * prec;
    
    if (p_tete == NULL || p_nv_elt->val <= p_tete->val) {  
        p_nv_elt->p_suiv = p_tete;
        p_tete = p_nv_elt;
    }
    else {  
        n = prec = p_tete;
        while (n != NULL && p_nv_elt->val > n->val) {
            prec = n;
            n = n->p_suiv;
        }
        p_nv_elt->p_suiv = n;
        prec->p_suiv = p_nv_elt;
    }
    return p_tete;
}

/* Insère un nouvel élément dans la liste de manière à ce que la liste reste triée par ordre croissant
@input : maillon_int** p_p_tete, pointeur vers le pointeur de l'élément de tête de la liste
         maillon_int* p_nv_elt, pointeur vers le nouvel élément à ajouter
@output : void
@precondition : p_nv_elt est un pointeur vers un élément de type maillon_int
@postcondition : p_nv_elt est inséré dans la liste de manière à ce que la liste reste triée par ordre croissant
*/
void inserer2(maillon_int** prem, maillon_int* e)
{
    maillon_int* n, * prec;
    if (*prem == NULL || e->val <= (*prem)->val){ 
        e->p_suiv = *prem;
        *prem = e;
    }
    else {  
        n = prec = *prem;
        while (n != NULL && e->val > n->val) {
            prec = n;
            n = n->p_suiv;
        }
        e->p_suiv = n;
        prec->p_suiv = e;
    }
}

/* Supprime le premier élément de la liste
@input : maillon_int** prem, pointeur vers le pointeur de l'élément de tête de la liste
@output : void
@precondition : *prem est un pointeur valide vers un élément de type maillon_int ou NULL
@postcondition : le premier élément de la liste est supprimé, *prem pointe vers le deuxième élément de la liste
*/
void supprimer_debut(maillon_int** prem)
{
    maillon_int* n;
    if (*prem != NULL) {
        n = *prem;
        *prem = (*prem)->p_suiv;
        free(n);
    }
}

/* Supprime tous les éléments de la liste qui ont une certaine valeur
@input : maillon_int* prem, pointeur vers l'élément de tête de la liste
         int val, la valeur à supprimer
@output : maillon_int*, pointeur vers le nouvel élément de tête de la liste
@precondition : prem est un pointeur valide vers un élément de type maillon_int ou NULL
@postcondition : tous les éléments de la liste qui ont la valeur 'val' sont supprimés
*/
maillon_int* critere_supp_un1(maillon_int* prem, int val)
{
    maillon_int* e = prem, * prec = NULL, * n;

    while (e != NULL) {
        n = NULL;
        if (e->val == val) {
            n = e;
            if (prec == NULL)
                prem = e->p_suiv;
            else
                prec->p_suiv = e->p_suiv;
        }
        else
            prec = e;
        e = e->p_suiv;
        if (n != NULL)
            free(n);
    }
    return prem;

}

/* Supprime tous les éléments de la liste qui ont une certaine valeur
@input : maillon_int** prem, pointeur vers le pointeur de l'élément de tête de la liste
         int val, la valeur à supprimer
@output : void
@precondition : *prem est un pointeur valide vers un élément de type maillon_int ou NULL
@postcondition : tous les éléments de la liste qui ont la valeur 'val' sont supprimés
*/
void critere_supp_un2(maillon_int** prem, int val)
{
    maillon_int* e = *prem, * prec = NULL, * n;

    while (e != NULL) {
        n = NULL;
        if (e->val == val) {
            n = e;
            if (prec == NULL)
                *prem = e->p_suiv;
            else
                prec->p_suiv = e->p_suiv;
        }
        else
            prec = e;
        e = e->p_suiv;
        if (n != NULL)
            free(n);
    }
}

/* Détruit la liste en libérant toute la mémoire qui lui est associée
@input : maillon_int** prem, pointeur vers le pointeur de l'élément de tête de la liste
@output : void
@precondition : *prem est un pointeur valide vers un élément de type maillon_int ou NULL
@postcondition : tous les éléments de la liste sont supprimés et toute la mémoire qui leur était associée est libérée
*/
void detruire_liste(maillon_int** prem)
{
    maillon_int* n;
    while (*prem != NULL) {
        n = *prem;
        *prem = (*prem)->p_suiv;
        free(n);
    }
}

/* Détruit la liste en appelant la fonction supprimer_debut jusqu'à ce que la liste soit vide
@input : maillon_int** prem, pointeur vers le pointeur de l'élément de tête de la liste
@output : void
@precondition : *prem est un pointeur valide vers un élément de type maillon_int ou NULL
@postcondition : tous les éléments de la liste sont supprimés et toute la mémoire qui leur était associée est libérée
*/
void detruire_liste2(maillon_int** prem)
{
    while (*prem != NULL)
        supprimer_debut(prem);
    
}

/* Permet la sérialisation format binaire dans le fichier
"saveliste.bin" de la liste d'entier (maillon_int) dont
le pointeur sur le premier élément est passé en paramètre
@input : maillon_int * prem, pointeur sur l'élément de tête de la liste à sérialiser
@output : void
@precondition : le répertoire courant et le processus père permettent l'écriture 
                le pointeur prem, est soit NULL (aucune action) soit pointe sur
                le premier élément d'une liste d'entiers
@postcondition : le fichier saveliste.bin contient les éléments de la liste 
                dont le premier élément est pointé par prem. 
                Nota : il n'y a pas de libération de la mémoire occupée par la 
                liste. Il faut donc la détruire avant d'éventuellement la recharger.
*/
void sauver_liste(maillon_int* prem)
{
    //ouvrir un fichier binaire en écriture : suffixe b
    FILE* f=fopen("saveliste.bin", "wb");
    printf("Ouvertude du fichier %p\n",f);
    // si liste non vide
    if (prem != NULL) {
        if (f==NULL)
            fprintf(stderr,"erreur création fichier :%i\n",errno);
        else // parcourir la liste jusque fin
            while (prem != NULL) {
                // écrire chaque maillon en binaire
                if (1 !=fwrite(prem, sizeof(maillon_int), 1, f))
                    fprintf(stderr,"Erreur d'écriture du maillon %p\n",prem);
                else 
                // passer au maillon suivant
                prem = prem->p_suiv;
            }
            fclose(f);	// fermer le fichier
    }
    else
        fprintf(stderr,"pas de sauvegarde pour une liste vide\n");
}

/* Charge une liste à partir d'un fichier binaire
@input : void
@output : maillon_int*, pointeur vers l'élément de tête de la liste chargée
@precondition : le fichier "saveliste.bin" existe et contient une liste d'éléments de type maillon_int
@postcondition : retourne un pointeur vers l'élément de tête de la liste chargée, ou NULL si le fichier n'existe pas ou s'il y a une erreur
*/
maillon_int* load_liste()
{
    FILE* f;
    maillon_int* prem = NULL, * p, e;
    if ((f= fopen("saveliste.bin", "rb")) != NULL) {
        prem = malloc(sizeof(maillon_int));
        fread(prem, sizeof(maillon_int), 1, f);
        p = prem;
        while (fread(&e, sizeof(maillon_int), 1, f)) {
            p->p_suiv = malloc(sizeof(maillon_int));
            p = p->p_suiv;
            *p = e;
            p->p_suiv = NULL;
        }
        fclose(f);
    }
    else
        printf("erreur ou fichier inexistant");
    return prem;
}

int main()
{
    maillon_int* premier = NULL;
    maillon_int* nouveau;
    int fin = 0;
    int i, nb;


    srand((unsigned)time(NULL));
    while (!fin) {
        i = menu();
        switch (i) {

        case 1: //Créer une liste de taille aléatoire
            nb = rand() % 20 + 1;
            for (int j = 0; j < nb; j++) {
                nouveau = init_elt();
                ajout_tete_v2(&premier, nouveau);
            }
            parcourir(premier);
            break;

        case 2: // Ajouter
            ajout_tete_v2(&premier, nouveau);
            parcourir(premier);
            break;

        case 3: // Insérer (ordre croissant)
            inserer2(&premier, nouveau);
            parcourir(premier);
            break;

        case 4: //Supprimer début:
            supprimer_debut(&premier);
            parcourir(premier);
            break;

        case 5: // Supprimer un maillon d'une valeur donnée
            printf("Entrez la valeur à supprimer : ");
            scanf("%d", &nb);
            critere_supp_un2(&premier, nb);
            parcourir(premier);
            break;

        case 6: // détruire liste
            detruire_liste2(&premier);
            parcourir(premier);
            break;

        case 7: // Sauver liste
            sauver_liste(premier);
            break;

        case 8: // Charger liste
            premier = load_liste();
            break;

        default:
            fin = 1;
            break;
        }

    }

    return 0;
}