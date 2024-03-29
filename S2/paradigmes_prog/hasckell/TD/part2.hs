monLast :: [Int] -> Int
monLast [] = error "Liste vide"
monLast (x : xs)
    | not (null xs) = monLast xs
    | otherwise = x

appartient :: Int -> [Int] -> Bool
appartient _ [] = False
appartient e (x:xs)
    | e == x = True
    | otherwise = appartient e xs

-- longueur :: [Int] -> Int
-- longueur (x :xs)
--     | e