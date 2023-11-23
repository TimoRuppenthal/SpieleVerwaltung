package org.example.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import org.example.domain.EMailAdresse;
import org.example.domain.Spiel;
import org.example.domain.SpielDaten;
import org.example.domain.SpieleRepository;

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
