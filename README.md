# Motivation

Ein Projekt um die Grundlagen der Software-Entwicklung zu lernen. Dieses Projekt soll folgende Funktionalität anbieten:

* Hinzufügen eines Spiels in die Spieleverwaltung
* Löschen eines Spiels aus der Spieleverwaltung
* Abfragen aller Spiele aus der SpieleVerwaltung
* Die SpielDaten eines Spiels können aktualisiert werden

[User-Story Spiel registrieren] Als Manager der SpieleVerwaltung möchte ich, dass neue Spiele beim Hinzufügen in die SpieleVerwaltung registriert werden müssen, damit diese automatisiert verifiziert werden können.
* Bei der Registrierung muss eine gültige E-Mail-Adresse und die SpielDaten angegeben werden
* Ws wird eine UUID an die angegebene E-Mail-Adresse verschickt
* Damit ein Spiel in die SpieleVerwaltung aufgenommen werden kann, müssen E-Mail-Adresse und Verifizierungscode übergeben werden
* Der Verifizierungscode verliert nach 24 Stunden seine Gültigkeit


Abbildung auf DDD Mustersprache und Klassen

Applicationservice: SpieleVerwaltung
    Methoden: registriere und verifiziere
ValueObject: E-Mail-Adresse, SpielDaten, VerifizierungsCode
Aggregate: RegistrierungsDaten
Repository: RegistrierungsDatenRepository
DomainEvent: VerifizierungsCodeVerschickt