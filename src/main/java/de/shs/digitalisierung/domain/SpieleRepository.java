package de.shs.digitalisierung.domain;

import io.jexxa.addend.applicationcore.Repository;
import java.util.List;
@Repository
public interface SpieleRepository {
    List<Spiel> getAll();

    void remove(SpieleId spieleId);

    void add(Spiel spiel);
}
