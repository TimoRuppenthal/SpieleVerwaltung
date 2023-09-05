package de.shs.digitalisierung;

public class Spiel {
    private final String name;
    private final String genre;
    private final String schwierigkeit;
    private final int errungenschaften;

    public Spiel(String name, String genre, String schwierigkeit, int errungenschaften) {
        this.name = name;
        this.genre = genre;
        this.schwierigkeit = schwierigkeit;
        this.errungenschaften = errungenschaften;
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
}