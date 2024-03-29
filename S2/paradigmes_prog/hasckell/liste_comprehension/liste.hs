monConcatAMoiLC :: [[a]] -> [a]
monConcatAMoiLC lst =  [ x | y <- lst, x <- y ]

listeDiviseurs:: Int -> [Int]
listeDiviseurs a = [ x | x <- [1..a], a `mod` x == 0]

estPremier :: Int -> Bool
estPremier a = listeDiviseurs a == [1, a]

tripletsPythagoricien :: Int -> [(Int, Int, Int)]
tripletsPythagoricien x = [(a,b,c) |c<-[1..x], b<-[1..c], a<-[1..b], a^2 + b^2 == c^2]
 
nombresParfait :: Int -> [Int]
nombresParfait a = [ x | x <- [1..a], sum(listeDiviseurs x) - x == x]

