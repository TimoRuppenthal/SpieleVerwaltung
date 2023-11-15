package de.shs.digitalisierung.domain;

import io.jexxa.addend.applicationcore.DomainEvent;
@DomainEvent
public record VerifizierungsCodeVerschickt(EMailAdresse eMailAdresse, VerifizierungsCode verifizierungsCode) {
}