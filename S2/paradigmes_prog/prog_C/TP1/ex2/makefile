pile.o: pile.c pile.h
	$(CC) -c pile.c -o pile.o

main_pile.o: main_pile.c pile.h
	$(CC) -c main_pile.c -o main_pile.o

main_pile: pile.o main_pile.o
	$(CC) pile.o main_pile.o -o main_pile

clean:
	rm -f pile.o main_pile.o main_pile