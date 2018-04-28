# Contributing
## Issues
* Zum melden von Fehler ist das hinterlegte Template zu nutzen.
* Anmerkungen und andere Dinge können frei formuliert werden.

## Pull Requests
* Ein Pull-Request muss sich auf ein bestehendes Issue beziehen und alle Änderungen die vorgenommen wurden, müssen aufgeführt und kurz beschrieben werden.
* Änderungen eines Pull Requests müssen zunächst von TravisCI grünes Licht bekommen und werden dann von zwei verschiedenen Personen gegengeprüft. Stimmen beide Prüfer den Änderungen zu wird der Feature-Branch mit dem `master` Branch gemergt und danach gelöscht.

## Änderungen
* Änderungen werden in einem seperaten Branch durchgeführt.
    * Der `master` Branch ist für direkte Änderungen gesperrt.
    * In einem Branch wird immer nur eine Änderung durchgeführt.
        * Keine zwei Features in einem Branch.
        * Code der nicht modifiziert werden muss bleibt unberührt.
* Änderungen müssen sich auf ein bestehendes Issue beziehen.
    * Sollte noch kein Issue existieren ist dieses anzulegen.
    * Die Issue-ID ist in der jeweiligen Commit-Nachricht anzugeben.
* Commits sind atomar zu halten. Eine Änderung pro Commit.
* Commit-Nachrichten sind sinnvoll zu wählen und sollten kurz die gemachten Änderungen beschreiben.
* Passend zu einer Änderung sind auch entsprechende Tests zu schreiben.
* Vor dem commiten ist sicherzustellen das der Code sich kompilieren lässt und kein Test fehlschlägt.

## Tests
* Für jede geschriebene Methode sind passende Unit Tests zu schreiben
* Für UI-Änderungen sind entsprechende UI-Tests zu schreiben. Hier ist lediglich ein positiv Test nötig.