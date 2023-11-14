package de.shs.digitalisierung.domain;

import java.util.List;

public interface SpieleRepository {
    List<Spiel> getAll();

    void remove(Spiel spiel);

    void add(Spiel spiel);
}
