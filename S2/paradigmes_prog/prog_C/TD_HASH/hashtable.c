#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include "hashtable.h"

hsht_key_value_pair * hsht_new_key_value_pair(const char * key, const char * value){
    
    hsht_key_value_pair * element_paire = (hsht_key_value_pair * ) malloc(sizeof(hsht_key_value_pair));
    element_paire -> key = strdup(key);
    element_paire -> value = strdup(value);

    return element_paire;
}

ht_hash_table * hsht_new(const int size){

    ht_hash_table * new_table = (ht_hash_table * ) malloc(sizeof(ht_hash_table));
    if (size == 0){
        new_table -> size = 53;
    }
    else{
        new_table -> size = size;
    }

    new_table -> kv_items = (hsht_key_value_pair **) calloc(new_table -> size, sizeof(hsht_key_value_pair *));
    new_table -> amount = 0;
    
    return new_table;
}

void hsht_del_key_value_pair(hsht_key_value_pair * element){
    free(element->key);
    free(element->value);
    free(element);
}

void hsht_del(ht_hash_table * tab){
    for (int i = 0; i < tab->size; i++)
    {   
        if (tab->kv_items[i] != NULL)
        {
            printf("Suppression de l'élément avec la clé : %s\n", tab->kv_items[i]->key);
            hsht_del_key_value_pair(tab->kv_items[i]);
        }
    }
    printf("Suppression de la table de hachage\n");
    free(tab->kv_items);
    free(tab);
}

double hsht_hash(char * value, double nbr_premier, int taille_tab){
    int ascii = 0;
    double equ = 0;
    int taille_value = strlen(value);
    for(int i = 0; i < taille_value; i++){
        printf("taille value = %d\n", taille_value);
        ascii = value[i];
        printf("ascii = %d\n", ascii);
        equ = equ + pow(nbr_premier, i) * ascii;
    }
    equ = fmod(equ, taille_tab);
    return equ;
}