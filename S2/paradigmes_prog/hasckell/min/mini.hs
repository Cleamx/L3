minDe3 :: Ord a => a -> a -> a -> a
minDe3 x y z = min x(min y z)

main = do
    print(minDe3 20 10 32)    
