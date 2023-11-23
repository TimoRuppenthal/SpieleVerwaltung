package org.example.domain;

import io.jexxa.addend.applicationcore.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface SpieleRepository {
    List<Spiel> getAll();

    void remove(EMailAdresse eMailAdresse);

    void add(Spiel spiel);
    Optional<Spiel> get(EMailAdresse emailAdresse);

    void update(Spiel spiel);
}
