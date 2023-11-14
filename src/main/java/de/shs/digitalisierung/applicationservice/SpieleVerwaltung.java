package de.shs.digitalisierung.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleRepository;
import de.shs.digitalisierung.domain.SpieleId;
import de.shs.digitalisierung.domain.SpielDaten;

import java.util.List;
@ApplicationService
public class SpieleVerwaltung {
    private final SpieleRepository spieleRepository;

    public void add(SpieleId spieleId, SpielDaten spielDaten){
        spieleRepository.add(new Spiel(spielDaten, spieleId));
    }
    @SuppressWarnings("unused")
    public void delete (SpieleId spieleId){
        spieleRepository.remove(spieleId);
    }

    public List<SpieleId> get(){
        return spieleRepository.getAll()
                .stream()
                .map(Spiel::getSpieleid)
                .toList();
    }
    public SpieleVerwaltung (SpieleRepository spieleRepository){
        this.spieleRepository = spieleRepository;
    }
}
