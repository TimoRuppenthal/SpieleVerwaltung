package org.example.infrastructure.drivenadapter.persistence;
import org.example.domain.EMailAdresse;
import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.Spiel;
import org.example.domain.SpieleRepository;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
@DrivenAdapter
public class SpieleRepositoryImpl implements SpieleRepository {
    private final IRepository<Spiel, EMailAdresse> repository;

    public SpieleRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(Spiel.class, Spiel::getEMailAdresse, properties);
    }
    @Override
    public List<Spiel> getAll() {
        return repository.get();
    }

    @Override
    public void remove(EMailAdresse eMailAdresse) {
        repository.remove(eMailAdresse);

    }

    @Override
    public void add(Spiel spiel) {
        repository.add(spiel);

    }
    public Optional<Spiel> get(EMailAdresse eMailAdresse){
        return repository.get(eMailAdresse);
    }
    public void update(Spiel spiel){
        repository.update(spiel);
    }
}
