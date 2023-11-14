package de.shs.digitalisierung.domainservice;

import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleRepository;

import java.util.List;

public class StammdatenService {

    private static final Spiel Portal = new Spiel("Portal", "Puzzle-Adventure", "schwer", 124, 1);
    private static final Spiel ItTakesTwo = new Spiel("ItTakesTwo", "Puzzle-Adventure", "leicht", 34, 2);


    private final SpieleRepository spieleRepository;

    public StammdatenService(SpieleRepository spieleRepository){
        this.spieleRepository = spieleRepository;
    }

    public void initStammdaten(){

        List<Spiel> alleSpiele = spieleRepository.getAll();
        if(!alleSpiele.contains(Portal)){
            spieleRepository.add(Portal);
        }
        if(!alleSpiele.contains(ItTakesTwo)){
            spieleRepository.add(ItTakesTwo);
        }
        spieleRepository
                .getAll()
                .forEach( element -> System.out.println(element.getName()));
    }
}
