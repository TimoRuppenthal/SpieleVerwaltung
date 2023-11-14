package de.shs.digitalisierung;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import de.shs.digitalisierung.domain.SpieleRepository;
import de.shs.digitalisierung.applicationservice.SpieleVerwaltung;
import de.shs.digitalisierung.domainservice.StammdatenService;
import de.shs.digitalisierung.infrastructure.drivenadapter.persistence.SpieleRepositoryImpl;
import java.util.Properties;
public class Main {

    @SuppressWarnings("java:S106") //Okey da Demoprojekt
    public static void main(String[] args) {
        SpieleRepository spieleRepository = new SpieleRepositoryImpl(new Properties());
        SpieleVerwaltung spieleVerwaltung = new SpieleVerwaltung(spieleRepository);

        StammdatenService stammdatenService = new StammdatenService(spieleRepository);
        stammdatenService.initStammdaten();

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
