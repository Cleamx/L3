-- Définition de la fonction factoriel
factoriel :: Integer -> Integer
factoriel 0 = 1
factoriel n = n * factoriel (n - 1)

-- Programme principal
main :: IO ()
main = do
    putStr "Entrez un nombre: "
    str <- getLine
    let num = read str :: Integer
    putStr "La factorielle est : "
    print (factoriel num)