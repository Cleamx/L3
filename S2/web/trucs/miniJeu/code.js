const solution = String.fromCharCode(48, 52, 50);
document.getElementById('button').addEventListener('click', check);

function check() {
    const value = document.getElementById('code').value;
    if (value === solution) {
        alert('Bravo !');
    } else {
        alert('Dommage !');
    }
}