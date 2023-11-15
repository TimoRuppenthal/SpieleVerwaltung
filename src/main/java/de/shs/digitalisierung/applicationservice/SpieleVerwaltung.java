package de.shs.digitalisierung.applicationservice;

import io.jexxa.addend.applicationcore.ApplicationService;
import de.shs.digitalisierung.domain.*;
import de.shs.digitalisierung.domainservice.VerifizierungsCodeSender;
import java.util.List;
@ApplicationService
public class SpieleVerwaltung {
    private final SpieleRepository spieleRepository;
    private final RegistrierungsDatenRepository registrierungsDatenRepository;

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
    public SpieleVerwaltung (SpieleRepository spieleRepository, RegistrierungsDatenRepository registrierungsDatenRepository){
        this.spieleRepository = spieleRepository;
        this.registrierungsDatenRepository = registrierungsDatenRepository;
    }
    public void registriere(EMailAdresse eMailAdresse, SpielDaten spielDaten){registrierungsDatenRepository.add(new RegistrierungsDaten(eMailAdresse, spielDaten));
    }
    public void verifiziere(EMailAdresse eMailAdresse, VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode{RegistrierungsDaten registrierungsDaten = registrierungsDatenRepository.get(eMailAdresse).orElseThrow();
        registrierungsDaten.verifiziere(verifizierungsCode);
        add(eMailAdresse,registrierungsDaten.getSpielDaten());
        registrierungsDatenRepository.remove(eMailAdresse);
    }
}
