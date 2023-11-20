package de.shs.digitalisierung.infrastructure.drivenadapter.persistence;

import io.jexxa.addend.infrastructure.DrivenAdapter;
import io.jexxa.infrastructure.messaging.MessageSender;
import de.shs.digitalisierung.domain.VerifizierungsCodeVerschickt;
import de.shs.digitalisierung.domainservice.VerifizierungsCodeSender;

import java.util.Properties;

import static io.jexxa.infrastructure.MessageSenderManager.getMessageSender;

@DrivenAdapter
public class VerifizierungsCodeSenderImpl implements VerifizierungsCodeSender {


    public static final String TOPIC = "SpieleVerifizierungsEmail";
    private final MessageSender messageSender;

    public VerifizierungsCodeSenderImpl(Properties properties){
        this.messageSender = getMessageSender(VerifizierungsCodeSender.class, properties);
    }
    public void send(VerifizierungsCodeVerschickt verifizierungsCodeVerschickt){
        messageSender
                .send(verifizierungsCodeVerschickt)
                .toTopic(TOPIC)
                .asJson();
    }
}