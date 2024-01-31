#include <ncurses.h>

int main() {
    // Initialiser ncurses
    initscr();
    // Ne pas afficher les caractères saisis par l'utilisateur
    noecho();
    // Activer les touches de fonction, les flèches, etc.
    keypad(stdscr, TRUE);

    // Déplacer le curseur à la position (10, 10)
    move(10, 10);
    // Afficher du texte à la position du curseur
    printw("Bonjour, ncurses!");

    // Rafraîchir l'écran pour afficher les modifications
    refresh();

    // Attendre que l'utilisateur appuie sur une touche
    getch();

    // Terminer ncurses
    endwin();

    return 0;
}