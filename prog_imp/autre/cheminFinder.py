class CheminFinder:
    def __init__(self, reseau):
        self.reseau = reseau
        self.Lmin = []
        self.Kmin = float('inf')
        self.index_sommets = {}

    def lire_liste_sommets(self, fichier):
        # Fonction pour lire la liste de sommets depuis un fichier
        with open(fichier, 'r') as file:
            sommets = file.readline().split()
        return sommets

    def initialiser_index_sommets(self, sommets):
        # Fonction pour créer un index pour les sommets
        self.index_sommets = {sommet: i for i, sommet in enumerate(sommets)}

    def chemin(self):
        D = input("départ: ")
        A = input("arrivée: ")
        L = [self.index_sommets[D]]
        K = 0
        self.etapeSuivante(L, K, self.index_sommets[A])
        if self.Lmin:
            # Convertir les indices de sommets en noms de sommets
            chemins_noms = [list(self.index_sommets.keys())[i] for i in self.Lmin]
            print("Chemin trouvé:", chemins_noms)
            print("Nombre de Km:", self.Kmin)
        else:
            print("Aucun chemin trouvé entre", D, "et", A)

    def etapeSuivante(self, L, K, A):
        if L[-1] == A:
            if K < self.Kmin:
                self.Lmin = list(L)
                self.Kmin = K
            return
        for v in range(len(self.reseau)):
            if v not in L and self.reseau[L[-1]][v] > 0:
                L.append(v)
                K += self.reseau[L[-2]][v]
                self.etapeSuivante(L, K, A)
                L.pop()
                K -= self.reseau[L[-1]][v]

# Exemple d'utilisation avec lecture de la liste de sommets depuis un fichier
reseau = [
    [0, 7, 3, 0, 0, 0],
    [0, 0, 0, 1, 1, 0],
    [4, 0, 0, 1, 0, 6],
    [0, 2, 0, 0, 4, 0],
    [0, 0, 0, 0, 0, 1],
    [0, 0, 0, 2, 3, 0]
]

finder = CheminFinder(reseau)

# Lire la liste de sommets depuis un fichier
liste_sommets = finder.lire_liste_sommets("reseau.txt")

# Initialiser l'index des sommets
finder.initialiser_index_sommets(liste_sommets)

# Utiliser la liste de sommets dans le programme
print("Index des sommets:", finder.index_sommets)

finder.chemin()
