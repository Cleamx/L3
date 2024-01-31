const Pseudo = document.querySelector("#pseudo");

//recup valeur joueur
const value_player_choice = document.querySelector("#choice_player");
const input_selected_player = document.querySelector("#select_choice_player");
const value_player_choice_res = document.querySelector("#choice_res_player");
const input_selected_player_res = document.querySelector("#select_choice_res_player");

//recup valeur bot
const value_bot_choice = document.querySelector("#choice_bot");
const input_selected_bot = document.querySelector("#select_choice_bot");
const value_res_bot_choice = document.querySelector("#choice_res_bot");
const input_selected_res_bot = document.querySelector("#select_choice_res_bot");

//affiche les choix du joueur
value_player_choice.textContent = Math.round(input_selected_player.value);
input_selected_player.addEventListener("input", (event) => {
    value_player_choice.textContent = Math.round(event.target.value);
});
value_player_choice_res.textContent = Math.round(input_selected_player_res.value);
input_selected_player_res.addEventListener("input", (event) => {
    value_player_choice_res.textContent = Math.round(event.target.value);
});

//random pour le choix du bot
function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

//bouton joué
const playButton = document.querySelector("#play_button");

//événement quand on click sur le bouton
playButton.addEventListener("click", () => {

    input_selected_bot.value = getRandomInt(1, 5);
    value_bot_choice.textContent = Math.round(input_selected_bot.value);

    input_selected_res_bot.value = getRandomInt(2, 10);
    value_res_bot_choice.textContent = Math.round(input_selected_res_bot.value);

    const player_result = document.querySelector("#player_result");
    const gagnant = document.querySelector("#gagnant");

    const sum = Number(input_selected_player.value) + Number(input_selected_bot.value);
    const playerDifference = Math.abs(sum - Number(input_selected_player_res.value));
    const botDifference = Math.abs(sum - Number(input_selected_res_bot.value));

    const cardHide = document.querySelector("#card_hide");
    cardHide.style.display = "block";

    let winner;
    if (playerDifference < botDifference) {
        if(Pseudo.value.trim() !== "") {
            winner = Pseudo.value;
        }
        else{
            winner= 'Joueur';
        }
       
    } else if (botDifference < playerDifference) {
        winner = 'Ordinateur';
    } else {
        winner = 'Personne, c\'est un match nul';
    }

    gagnant.textContent = `Le gagnant est : ${winner}`;



    //affichage dans résultats
    player_result.textContent = `Somme : ${Math.round(sum)}`;



});

//affiche le choix du bot 
input_selected_bot.addEventListener("input", (event) => {
    value_bot_choice.textContent = Math.round(event.target.value);
});

input_selected_res_bot.addEventListener("input", (event) => {
    value_res_bot_choice.textContent = Math.round(event.target.value);
});



