package de.shs.digitalisierung.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import de.shs.digitalisierung.domain.*;

import java.util.List;
@ApplicationService
public class SpieleVerwaltung {
    private final SpieleRepository spieleRepository;

    public void add(EMailAdresse eMailAdresse, SpielDaten spielDaten){
        spieleRepository.add(new Spiel(spielDaten, eMailAdresse));
    }
    @SuppressWarnings("unused")
    public void delete (EMailAdresse eMailAdresse){
        spieleRepository.remove(eMailAdresse);
    }

    public List<EMailAdresse> get(){
        return spieleRepository.getAll()
                .stream()
                .map(Spiel::getEMailAdresse)
                .toList();
    }
    public SpieleVerwaltung (SpieleRepository spieleRepository){
        this.spieleRepository = spieleRepository;
    }
    public void registriere(EMailAdresse eMailAdresse, VerifizierungsCode verifizierungsCode){
    }
    public void verifiziere(EMailAdresse eMailAdresse, VerifizierungsCode verifizierungsCode){
    }
}
