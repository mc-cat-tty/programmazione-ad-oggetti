In questa esercitazione useremo le strutture dati templetizzate di libreria.

Micro benchmarking -> ad esempio le prestazioni tra `Vector` e `ArrayList`
Ricorda di chiamare `System.gc()` prima di effettuare un benchmark e di scartare il primo benchmark per rimuovere il bias della cache.

Override di `equals` e `equals`:
```java
@Override
public boolean equals(Object o) {
	if (o == null) {
		return false;
	}
	
	if ( ! (o instanceof Contatto) ) {
		return false;
	}
	
	Contatto c = (Contatto) o;
	
	if (
		this.cognome.equals(c.cognome) &&
		// ...
		this.telefono.equals(c.telefono)
	) {
		return true;	
	}
	
	return false;
}
```