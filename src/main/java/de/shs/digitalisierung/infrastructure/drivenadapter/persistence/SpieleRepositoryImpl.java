package de.shs.digitalisierung.infrastructure.drivenadapter.persistence;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleRepository;

import java.util.List;
import java.util.Properties;

public class SpieleRepositoryImpl implements SpieleRepository {
    private final IRepository<Spiel, Integer> repository;

    public SpieleRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(Spiel.class, Spiel::getSpieleid, properties);
    }
    @Override
    public List<Spiel> getAll() {
        return repository.get();
    }

    @Override
    public void remove(Spiel spiel) {
        repository.remove(spiel.getSpieleid());

    }

    @Override
    public void add(Spiel spiel) {
        repository.add(spiel);

    }
}
