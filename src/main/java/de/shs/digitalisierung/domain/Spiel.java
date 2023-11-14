package de.shs.digitalisierung.domain;
import io.jexxa.addend.applicationcore.Aggregate;
import io.jexxa.addend.applicationcore.AggregateID;

import java.util.Objects;

@Aggregate
public class Spiel {
    private final String name;
    private final String genre;
    private final String schwierigkeit;
    private final int errungenschaften;

    private final SpieleId spieleid;

    public Spiel(String name, String genre, String schwierigkeit, int errungenschaften, int spieleid) {
        this.name = name;
        this.genre = genre;
        this.schwierigkeit = schwierigkeit;
        this.errungenschaften = errungenschaften;
        this.spieleid = new SpieleId(spieleid);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spiel spiel = (Spiel) o;
        return Objects.equals(getSpieleid(), spiel.getSpieleid());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, genre,schwierigkeit,errungenschaften,spieleid);
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getSchwierigkeit() {
        return schwierigkeit;
    }
    public int getErrungenschaften(){
        return errungenschaften;
    }
    @AggregateID
    public SpieleId getSpieleid(){
        return spieleid;
    }
}