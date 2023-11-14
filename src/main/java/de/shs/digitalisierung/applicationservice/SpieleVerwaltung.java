package de.shs.digitalisierung.applicationservice;

import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleRepository;

import java.util.List;

public class SpieleVerwaltung {
    private final SpieleRepository spieleRepository;

    public void add(Spiel spiel){
        spieleRepository.add(spiel);
    }
    @SuppressWarnings("unused")
    public void delete (Spiel spiel){
        spieleRepository.remove(spiel);
    }

    public List<Spiel> get(){
        return spieleRepository.getAll();
    }
    public SpieleVerwaltung (SpieleRepository spieleRepository){
        this.spieleRepository = spieleRepository;
    }
}
