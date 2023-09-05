package de.shs.digitalisierung;

import java.util.List;
public class Main {
    public static void main(String[] args) {
        SpieleVerwaltung spieleVerwaltung = new SpieleVerwaltung();

        Spiel portal = new Spiel("Portal", "Puzzle-Adventure", "schwer", 124);
        Spiel ittakestwo = new Spiel("ItTakesTwo", "Puzzle-Adventure", "einfach", 34);

        spieleVerwaltung.add(portal);
        spieleVerwaltung.add(ittakestwo);
        List<Spiel> alleSpiele = spieleVerwaltung.get();
        alleSpiele.forEach(element -> System.out.println(element.getName()));
    }
}