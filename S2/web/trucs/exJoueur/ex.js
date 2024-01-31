
const football = [
    {club : "SCB", joueur : "SANTELLI", but:2},
    {club : "SCB", joueur : "MAGRI", but:1},
    {club : "HAC", joueur : "KITALA", but:3},
    {club : "SCB", joueur : "ROBIC", but:3},
    {club : "BORDEAUX", joueur : "MAJA", but:4}
]


const res = football.filter(e => e.club == "SCB").map(player => player.but +=1).reduce((somme,sumGoal)=>somme+sumGoal);
console.log(res);
