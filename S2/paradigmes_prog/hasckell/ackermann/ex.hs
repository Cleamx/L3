ackermann :: Integer -> Integer -> Integer
ackermann m n
    | m == 0 = n + 1
    | m > 0 && n == 0 = ackermann (m-1) 1
    | otherwise = ackermann (m - 1) (ackermann m (n - 1))

somme 0 = 0
somme n = n + somme(n - 1)

-- récursivité terminale
fact n = facAux 1 n
    where 
        facAux acc n
            |n == 0 = acc
            | n > 0 = facAux (n * acc) (n - 1)
            | otherwise = error " N doit être un entier positif"

sommeTest n = sommeAc 0 n
    where
        sommeAc acc n
            | n == 0 = acc
            | n > 0 = sommeAc (n + acc) ( n - 1)
            | otherwise = error "erreur"

mult x y = multAcc x y 0
    where
         multAcc x y acc
            | y == 0 = acc
            | otherwise = multAcc x (y - 1) (acc + x)

puiss x y = puissAcc x y 1
    where
        puissAcc x y acc
            | y == 0 = acc
            | otherwise = puissAcc x (y - 1) (acc * x)

divi a n = divAcc a n 0
    where
        divAcc a n acc
            | a < n = acc
            | otherwise = divAcc n (a - n)  (acc + 1)
