#include <stdio.h>

void recursive();

int main() 
{
    recursive();
    return 0;
}

void recursive() 
{
    recursive();
}