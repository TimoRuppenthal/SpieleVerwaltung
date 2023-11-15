package de.shs.digitalisierung.domainservice;

import io.jexxa.addend.applicationcore.InfrastructureService;
import de.shs.digitalisierung.domain.EMailAdresse;
import de.shs.digitalisierung.domain.VerifizierungsCodeVerschickt;
@InfrastructureService
public interface VerifizierungsCodeSender {

    void send(VerifizierungsCodeVerschickt verifizierungsCodeVerschickt);
}