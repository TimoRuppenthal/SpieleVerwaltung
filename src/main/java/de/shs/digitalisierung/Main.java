package de.shs.digitalisierung;

import io.jexxa.core.JexxaMain;
import io.jexxa.drivingadapter.rest.RESTfulRPCAdapter;
import de.shs.digitalisierung.applicationservice.SpieleVerwaltung;
import de.shs.digitalisierung.domainservice.DomainEventSender;
import de.shs.digitalisierung.domainservice.StammdatenService;


public class Main {

    @SuppressWarnings("java:S106") //Okey da Demoprojekt
    public static void main(String[] args) {

        var jexxaMain = new JexxaMain(Main.class);

        jexxaMain
                // Bind a REST adapter to expose parts of the application
                .bootstrap(StammdatenService.class).with(StammdatenService::initStammdaten)
                .bootstrap(DomainEventSender.class).and()
                .bind(RESTfulRPCAdapter.class).to(SpieleVerwaltung.class)               // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(Main.class) // Get greetings: http://localhost:7501/HelloJexxa/greetings
                .bind(RESTfulRPCAdapter.class).to(jexxaMain.getBoundedContext())  // Get stats: http://localhost:7501/BoundedContext/isRunning

                // Run your application until Ctrl-C is pressed
                .run();
    }
}
