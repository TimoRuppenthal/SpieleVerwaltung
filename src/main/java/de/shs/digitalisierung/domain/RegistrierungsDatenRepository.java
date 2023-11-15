package de.shs.digitalisierung.domain;

import io.jexxa.addend.applicationcore.Repository;
import java.util.List;
@Repository
public interface RegistrierungsDatenRepository {
    List<RegistrierungsDaten> getAll();

    void remove(EMailAdresse eMailAdresse);

    void add(RegistrierungsDaten registrierungsDaten);

    RegistrierungsDaten get(EMailAdresse eMailAdresse);
}
