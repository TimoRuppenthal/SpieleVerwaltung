package de.shs.digitalisierung.domainservice;

import io.jexxa.addend.applicationcore.DomainService;
import de.shs.digitalisierung.domain.VerifizierungsCode;
import de.shs.digitalisierung.domain.VerifizierungsCodeVerschickt;

import static de.shs.digitalisierung.domain.DomainEventPublisher.subscribe;

@DomainService
public class DomainEventSender {
    public DomainEventSender(VerifizierungsCodeSender verifizierungsCodeSender) {
        subscribe(VerifizierungsCodeVerschickt.class, verifizierungsCodeSender::send);
    }
}