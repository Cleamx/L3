function GetPseudo() {
    var pseudo = document.getElementById("pseudo").value;
    return pseudo;
}

function GetNombre() {
    var nombre = document.getElementById("nombre").value;
    return nombre;
}

function getRandomInt() {
    return Math.floor(Math.random() * 100);
}

var compteur = 0;
var nb = getRandomInt();

function Comparer(){
    var pseudo = GetPseudo();
    var nombre = GetNombre();

    console.log(nb);

    compteur++;

    if (nombre == nb){
        alert("Bravo " + pseudo + " vous avez trouvé le bon nombre en " + compteur + "!");
    }
    else if (nombre < nb){
        alert("Le nombre est plus grand que " + nombre);
    }
    else if (nombre > nb){
        alert("Le nombre est plus petit que " + nombre);
    }
    else{
        alert("Veuillez entrer un nombre !");
    }
}

document.getElementById("btn").addEventListener("click", function(event) {
    event.preventDefault();
    Comparer();
});