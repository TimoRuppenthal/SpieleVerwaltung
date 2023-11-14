package de.shs.digitalisierung.domainservice;

import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleRepository;

import java.util.List;

public class StammdatenService {
    private final SpieleRepository spieleRepository;

    public StammdatenService(SpieleRepository spieleRepository){
        this.spieleRepository = spieleRepository;
    }

    public void initStammdaten(){
        List<Spiel> alleSpiele = spieleRepository.getAll();
        if(!alleSpiele.contains(new Spiel("Portal", "Puzzle-Adventure", "schwer", 124))){
            spieleRepository.add(new Spiel("Portal", "Puzzle-Adventure", "schwer", 124));
        }
        if(!alleSpiele.contains(new Spiel("ItTakesTwo", "Puzzle-Adventure", "einfach", 34))){
            spieleRepository.add(new Spiel("ItTakesTwo", "Puzzle-Adventure", "einfach", 34));
        }
        spieleRepository
                .getAll()
                .forEach( element -> System.out.println(element.getName()));
    }
}
