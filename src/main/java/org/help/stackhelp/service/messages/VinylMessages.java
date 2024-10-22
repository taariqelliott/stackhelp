package org.help.stackhelp.service.messages;

import org.help.stackhelp.service.VinylRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class VinylMessages {

    private final MessageChannel inputChannel2;

    @Autowired
    public VinylMessages(@Qualifier("inputChannel2") MessageChannel inputChannel2) {
        this.inputChannel2 = inputChannel2;
    }

    public void sendCdRecords() {
        List<VinylRecord> cds = Arrays.asList(
                new VinylRecord("Purple Rain", "Prince", 1984, "Warner Bros. Records"),
                new VinylRecord("The Dark Side of the Moon", "Pink Floyd", 1973, "Harvest Records"),
                new VinylRecord("Sgt. Pepper's Lonely Hearts Club Band", "The Beatles", 1967, "Parlophone Records")
        );

        inputChannel2.send(MessageBuilder.withPayload(cds).build());
    }
}
