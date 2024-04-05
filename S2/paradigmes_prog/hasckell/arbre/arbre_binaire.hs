data TreeB a = EmptyTree | Node (TreeB a) a (TreeB a) deriving (Show, Read, Eq)
listenum = [1,2,3,4,5,7,10,8,9,12,11]
monArbrebis = treeInsertFromList listenum


singleTree :: Ord a => a -> TreeB a
singleTree e = Node EmptyTree e EmptyTree

treeInsert :: Ord a => a -> TreeB a -> TreeB a
treeInsert elt EmptyTree = singleTree elt
treeInsert elt (Node ltree rootelt rtree) 
    |elt == rootelt = Node ltree rootelt rtree
    |elt < rootelt = Node (treeInsert elt ltree) rootelt rtree
    |elt > rootelt = Node ltree rootelt (treeInsert elt rtree)

treeInsertFromList :: Ord a => [a] -> TreeB a
treeInsertFromList [] = EmptyTree
treeInsertFromList (x:xs) = treeInsert x bTreexs
    where bTreexs = treeInsertFromList xs

searchTree :: Ord a => a -> TreeB a -> Bool
searchTree elt EmptyTree = False
searchTree elt (Node ltree rootelt rtree)  
    |elt == rootelt = True
    |elt < rootelt = searchTree elt ltree
    |otherwise = searchTree elt rtree

countNode :: TreeB a -> Int
countNode EmptyTree = 0
countNode (Node ltree rootelt rtree) = countNode ltree + countNode rtree + 1

valuemax :: TreeB a -> a
valuemax EmptyTree = error "Arbre vide"
valuemax (Node _ rootelt EmptyTree) = rootelt
valuemax (Node ltree rootelt rtree) = valuemax rtree 

countAll :: Num a => TreeB a -> a
countAll EmptyTree = 0
countAll (Node ltree rootelt rtree) = countAll ltree + countAll rtree + rootelt

profondeur :: (Num a1, Ord a1) => TreeB a2 -> a1
profondeur EmptyTree = error "Arbre vide"
profondeur (Node EmptyTree rootelt EmptyTree) = 0
profondeur (Node ltree rootelt EmptyTree) = profondeur ltree + 1
profondeur (Node EmptyTree rootelt rtree) = profondeur rtree + 1
profondeur (Node ltree rootelt rtree) 
    |profondeur ltree > profondeur rtree = profondeur ltree + 1
    |profondeur ltree < profondeur rtree = profondeur rtree + 1