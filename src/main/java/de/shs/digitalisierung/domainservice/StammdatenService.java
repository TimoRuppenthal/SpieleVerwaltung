package de.shs.digitalisierung.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import de.shs.digitalisierung.domain.*;

import java.util.List;
@DomainService
public class StammdatenService {

    private final SpieleRepository spieleRepository;

    public StammdatenService(SpieleRepository spieleRepository){
        this.spieleRepository = spieleRepository;
    }

    public void initStammdaten(){

        final Spiel portal = new Spiel(new SpielDaten("Portal", "Puzzle-Adventure", "schwer", 124), new EMailAdresse("planta.jeremie@gmail.com"));
        final Spiel itTakesTwo = new Spiel(new SpielDaten("ItTakesTwo", "Puzzle-Adventure", "leicht", 34), new EMailAdresse("ruppenthal.timo@gmail.com"));

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
