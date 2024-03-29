#include <stdio.h>
#include "hashtable.h"

int main() {
    char key[256];
    char value[256];

    // Crée une table de hachage
    ht_hash_table * table = hsht_new(3);

    // Demande à l'utilisateur d'entrer une clé et une valeur
    printf("Entrez une clé : ");
    scanf("%255s", key);
    printf("Entrez une valeur : ");
    scanf("%255s", value);

    // Crée un nouvel élément avec la clé et la valeur 
    hsht_key_value_pair * element = hsht_new_key_value_pair(key, value);

    // Ajoute l'élément à la table
    table->kv_items[0] = element;

    int size = table->size;
    int res = hsht_hash(value, 227, 53);
    printf("%d\n", res);

    // Détruit la table et les éléments
    hsht_del(table);

    return 0;
}