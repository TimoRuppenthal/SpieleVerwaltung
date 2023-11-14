package de.shs.digitalisierung;

import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleVerwaltung;
import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import de.shs.digitalisierung.domain.Spiel;
import de.shs.digitalisierung.domain.SpieleVerwaltung;
import java.util.List;
public class Main {
    public String SpieleVerwaltung() {
        return "SpieleVerwaltung";
    }

    public static void main(String[] args) {
        SpieleVerwaltung spieleVerwaltung = new SpieleVerwaltung();

        Spiel portal = new Spiel("Portal", "Puzzle-Adventure", "schwer", 124);
        Spiel ittakestwo = new Spiel("ItTakesTwo", "Puzzle-Adventure", "einfach", 34);

        spieleVerwaltung.add(portal);
        spieleVerwaltung.add(ittakestwo);
        spieleVerwaltung.delete(ittakestwo);

        List<Spiel> alleSpiele = spieleVerwaltung.get();
        alleSpiele.forEach(element -> System.out.println(element.getName()));
        alleSpiele.forEach(element -> System.out.println(element.getGenre()));
        alleSpiele.forEach(element -> System.out.println(element.getSchwierigkeit()));
        alleSpiele.forEach(element -> System.out.println(element.getErrungenschaften()));


        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bind(RESTfulRPCAdapter.class).to(spieleVerwaltung)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(Main.class) // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}
