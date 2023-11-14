package de.shs.digitalisierung.domain;
import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Spiel {
    private final SpielDaten spielDaten;
    private final SpieleId spieleid;

    public Spiel(SpielDaten spielDaten, SpieleId spieleId) {
        this.spielDaten = spielDaten;
        this.spieleid = spieleId;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spiel spiel = (Spiel) o;
        return Objects.equals(getSpieleid(), spiel.getSpieleid());
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
    public SpieleId getSpieleid(){
        return spieleid;
    }
}