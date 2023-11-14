package de.shs.digitalisierung.domain;

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
