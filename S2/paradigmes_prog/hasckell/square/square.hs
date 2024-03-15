{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use max" #-}
{-# HLINT ignore "Use min" #-}

square :: Num a => a -> a
square x = x * x

quad :: Num a => a -> a
quad x = square(square x) 

smaller :: Ord a => (a, a) -> a
smaller (x,y) = if x <= y then x else y

greater :: Ord a => (a, a) -> a
greater (x,y) = if x > y then x else y

aera :: Floating a => a -> a
aera x = square x * pi

-- on peut aussi écrire 
-- |x < y = x
-- |x >= y = y

main = do
    print(square 2)
    print(smaller (2, 5))
    print(quad 2)
    print(greater (2,4))
    print(aera 10)
