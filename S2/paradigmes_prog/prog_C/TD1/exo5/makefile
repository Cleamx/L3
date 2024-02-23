CC = gcc
CFLAGS = -Wall -pedantic -g

#programme a exec
all: ex5

%.o: %.c %.h
	$(CC) $(CFLAGS) -c -o $@

ex5: ex5.o
	$(CC) $(CFLAGS) -o $@ $^

clean:
	rm -f *.o ex5