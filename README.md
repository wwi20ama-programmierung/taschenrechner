# Taschenrechner
## Erklärung
Dieser Taschenrechner nimmt eine Folge von Zahlen und Operatoren beim Programmaufruf entgegen.
Aus diesen Zahlen wird mithilfe der Operatoren "von links nach rechts" das Ergebnis berechnet.
Aktuell prüft der Rechner nur, ob die übergebene Anweisung generell valide ist und kann die Division durch 0 behandeln.
Andere Rechenregeln wurden bisher nicht implementiert.

## Verwendung
**Addition**

```
4.2 + 2 + 3.1 + 1.9
```

```
4.2 plus 2 + 3.1 plus 1.9
```

**Subtraktion**
```
4 - 2.2 - 3.1 - 1.7
```

```
4 - 2.2 minus 3.1 - 1.7
```

**Multiplikation**
```
4 * 2.2 * 3.1 * 1.7
```

```
4 x 2.2 * 3.1 mal 1.7
```

**Division**
```
4 / 2.2 / 3.1 / 1.7
```

```
4 / 2.2 : 3.1 % 1.7 geteilt durch 9
```
*Hinweis: Eine Division durch `0` ist nicht möglich.*

## Logging
Beim Initialisieren eines `Calculator`-Objekts kann optional ein `Boolean` mitgegeben werden.
Hat dieser den Wert `true`, wird jeder Rechenschritt an der Konsole ausgegeben. 
