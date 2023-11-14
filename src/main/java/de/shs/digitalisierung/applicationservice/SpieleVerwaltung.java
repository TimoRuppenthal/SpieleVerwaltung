package de.shs.digitalisierung.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleRepository;
import de.shs.digitalisierung.domain.SpieleId;

import java.util.List;
@ApplicationService
public class SpieleVerwaltung {
    private final SpieleRepository spieleRepository;

    public void add(Spiel spiel){
        spieleRepository.add(spiel);
    }
    @SuppressWarnings("unused")
    public void delete (Spiel spiel){
        spieleRepository.remove(spiel);
    }

    public List<SpieleId> get(){
        return spieleRepository.getAll().stream().map(Spiel::getSpieleid).toList();
    }
    public SpieleVerwaltung (SpieleRepository spieleRepository){
        this.spieleRepository = spieleRepository;
    }
}
