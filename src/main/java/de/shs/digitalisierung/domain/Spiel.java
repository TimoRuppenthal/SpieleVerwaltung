package de.shs.digitalisierung.domain;
import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Spiel {
    private SpielDaten spielDaten;
    private final EMailAdresse eMailAdresse;

    public Spiel(SpielDaten spielDaten, EMailAdresse eMailAdresse) {
        this.spielDaten = spielDaten;
        this.eMailAdresse = eMailAdresse;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spiel spiel = (Spiel) o;
        return Objects.equals(getEMailAdresse(), spiel.getEMailAdresse());
    }

    public String getName() {
        return spielDaten.name();
    }

    public String getGenre() {
        return spielDaten.genre();
    }

    public String getSchwierigkeit() {
        return spielDaten.schwierigkeit();
    }
    public int getErrungenschaften(){
        return spielDaten.errungenschaften();
    }
    @AggregateID
    public EMailAdresse getEMailAdresse(){
        return eMailAdresse;
    }
    public void setSpielDaten(SpielDaten spielDaten){
        this.spielDaten = spielDaten;
    }
}