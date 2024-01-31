let sequence = [1,1,2,3,5,8,13];
let size = sequence.length;

function double(sequence){
    let sequenceDouble = [];

    for(var i = 0; i<size; i++){
        let double = sequence[i] * 2
        sequenceDouble.push(double)
    }

    return sequenceDouble; 
}

function paire(sequence){
    var sequencePaire = [];

    for(var i = 0; i<size; i++){
        if(sequence[i]%2==0){
            sequencePaire.push(sequence[i])
        }
    }

    return sequencePaire;
}

function impaire(sequence){
    var sequenceImpaire = [];

    for(var i = 0; i<size; i++){
        if(sequence[i]%2 != 0){
            sequenceImpaire.push(sequence[i])
        }
    }

    return sequenceImpaire;
}

function somme(sequence){
    var sommeRes = 0;
    for(var i = 0; i<size; i++){
        sommeRes = sommeRes + sequence[i];
    }
    return sommeRes;
}

function isPaire(nbr){
    if(nbr % 2 == 0){
        return "paire";
    }
    return "impaire";
}

const Sdouble = sequence.map(e => e * 2);
const Spaire = sequence.map(e => e % 2);
const Ssomme = sequence.reduce((sum,e)=> sum + e);
console.log(Ssomme);
console.log("-----");
console.log(Sdouble);
//filter -> filtrer les tableaux