ENTRYPOINT=MainTester
LIB=Libro

all:
	javac $(ENTRYPOINT).java $(LIB).java
	java $(ENTRYPOINT)

.PHONY: clean
clean:
	rm $(ENTRYPOINT).class $(LIB).class