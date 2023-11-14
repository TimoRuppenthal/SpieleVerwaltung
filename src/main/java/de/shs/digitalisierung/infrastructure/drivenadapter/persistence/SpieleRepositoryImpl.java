package de.shs.digitalisierung.infrastructure.drivenadapter.persistence;

import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleRepository;

import java.util.ArrayList;
import java.util.List;

public class SpieleRepositoryImpl implements SpieleRepository {
    private final List<Spiel> spieleList = new ArrayList<>();
    @Override
    public List<Spiel> getAll() {
        return spieleList;
    }

    @Override
    public void remove(Spiel spiel) {
        spieleList.remove(spiel);

    }

    @Override
    public void add(Spiel spiel) {
        spieleList.add(spiel);

    }
}
