package de.shs.digitalisierung;

import java.util.ArrayList;
import java.util.List;

public class SpieleVerwaltung {
    private final List<Spiel> spieleList = new ArrayList<>();

    public void add(Spiel spiel){
        spieleList.add(spiel);
    }

    public void delete (Spiel spiel){
        spieleList.remove(spiel);
    }

    public List<Spiel> get(){
        return spieleList;
    }
}
