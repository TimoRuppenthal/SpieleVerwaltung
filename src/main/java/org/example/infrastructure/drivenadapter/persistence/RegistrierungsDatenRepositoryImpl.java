package org.example.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.RepositoryManager;
import io.jexxa.infrastructure.persistence.repository.IRepository;
import org.example.domain.EMailAdresse;
import org.example.domain.RegistrierungsDaten;
import org.example.domain.RegistrierungsDatenRepository;

import java.util.List;
import java.util.Optional;
import java.util.Properties;

@DrivenAdapter
public class RegistrierungsDatenRepositoryImpl implements RegistrierungsDatenRepository {

    private final IRepository<RegistrierungsDaten, EMailAdresse> repository;

    public RegistrierungsDatenRepositoryImpl(Properties properties){
        this.repository = RepositoryManager.getRepository(RegistrierungsDaten.class, RegistrierungsDaten::getEMailAdresse,properties);
    }
    public List<RegistrierungsDaten> getAll(){
        return repository.get();
    }

    public void remove(EMailAdresse eMailAdresse){
        repository.remove(eMailAdresse);
    }

    public void add(RegistrierungsDaten registrierungsDaten){
        repository.add(registrierungsDaten);
    }

    public Optional<RegistrierungsDaten> get(EMailAdresse eMailAdresse) {

        return repository.get(eMailAdresse);
    }

}