
<?php
session_start();

$nb = rand(1, 100);

if (!isset($_SESSION['nb'])) {
    $_SESSION['nb'] = rand(10, 100);
    $_SESSION['compteur'] = 0;
}
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <title>Nombre</title>
</head>

<body>
    <h1>Juste Prix</h1>
    <form method="post">
        <label for="pseudo">Pseudo :</label>
        <input type="text" id="pseudo" name="pseudo" required minlength="1" size="10" value= "<?php echo isset($_POST["pseudo"]) ? $_POST["pseudo"] : "" ?>" /><br/>

        <label for="nombre">Nombre :</label>
        <input type="text" id="nombre" name="nombre" required minlength="1" size="10" value= "<?php echo isset($_POST["nombre"]) ? $_POST["nombre"] : "" ?>" /><br/>
    
        <input type="submit" value="Submit" id="btn" />
    </form>

    <?php
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $pseudo = $_POST["pseudo"];
        $nombre = $_POST["nombre"];
        $_SESSION['compteur']++;
        
        echo '<div class="center-text">';
        if ($nombre > $_SESSION['nb']) {
            echo $_POST["nombre"] . " est trop grand !";
        } else if ($nombre < $_SESSION['nb']) {
            echo $_POST["nombre"] . " est trop petit !";
        } else {
            echo "Bravo " . $pseudo . " vous avez trouvé le bon nombre en " . $_SESSION['compteur'] . " essais!";
            $_SESSION['nb'] = rand(10, 100);
            $_SESSION['compteur'] = 0;
        }
        echo '</div>';
    }
    ?>

</body>

</html>