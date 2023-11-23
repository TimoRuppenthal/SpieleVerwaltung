package org.example.domain;

import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.UUID;

@Aggregate
public class RegistrierungsDaten {
    private final SpielDaten spielDaten;
    private final EMailAdresse eMailAdresse;
    private final VerifizierungsCode verifizierungsCode;

    public RegistrierungsDaten(EMailAdresse eMailAdresse, SpielDaten spielDaten) {
        this.eMailAdresse = eMailAdresse;
        this.spielDaten = spielDaten;
        this.verifizierungsCode = new VerifizierungsCode(UUID.randomUUID().toString());
        sendVerifizierungsCode();
    }

    public VerifizierungsCode getVerifizierungsCode() {
        return verifizierungsCode;
    }

    public SpielDaten getSpielDaten() {
        return spielDaten;
    }
    public void verifiziere(VerifizierungsCode verifizierungsCode) throws UngueltigerVerifizierungsCode {
        if (this.verifizierungsCode != verifizierungsCode) {
            throw new UngueltigerVerifizierungsCode();
        }
    }

    public void sendVerifizierungsCode(){
        DomainEventPublisher.publish(new VerifizierungsCodeVerschickt(eMailAdresse, verifizierungsCode));
    }
    @AggregateID
    public EMailAdresse getEMailAdresse() {
        return eMailAdresse;
    }
}