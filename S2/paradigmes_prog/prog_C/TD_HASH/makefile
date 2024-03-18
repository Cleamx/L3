CC=gcc

hashtable.o: hashtable.c hashtable.h
	$(CC) -c hashtable.c

hsht_main.o: hsht_main.c hashtable.h
	$(CC) -c hsht_main.c -o hsht_main.o

hsht_main: hashtable.o hsht_main.o
	$(CC) hashtable.o hsht_main.o -o hsht_main

clean:
	rm -f hashtable.o hsht_main.o hsht_main