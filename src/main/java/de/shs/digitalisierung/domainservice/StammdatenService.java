package de.shs.digitalisierung.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpielDaten;
import de.shs.digitalisierung.domain.SpieleRepository;
import de.shs.digitalisierung.domain.SpieleId;

import java.util.List;
@DomainService
public class StammdatenService {

    private final SpieleRepository spieleRepository;

    public StammdatenService(SpieleRepository spieleRepository){
        this.spieleRepository = spieleRepository;
    }

    public void initStammdaten(){

        final Spiel portal = new Spiel(new SpielDaten("Portal", "Puzzle-Adventure", "schwer", 124), new SpieleId(1));
        final Spiel itTakesTwo = new Spiel(new SpielDaten("ItTakesTwo", "Puzzle-Adventure", "leicht", 34), new SpieleId(2));

        List<Spiel> alleSpiele = spieleRepository.getAll();
        if(!alleSpiele.contains(portal)){
            spieleRepository.add(portal);
        }
        if(!alleSpiele.contains(itTakesTwo)){
            spieleRepository.add(itTakesTwo);
        }
        spieleRepository
                .getAll()
                .forEach( element -> System.out.println(element.getName()));
    }
}
