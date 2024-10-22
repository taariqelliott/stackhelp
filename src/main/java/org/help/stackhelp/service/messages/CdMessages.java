package org.help.stackhelp.service.messages;

import org.help.stackhelp.service.CdRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CdMessages {

    private final MessageChannel inputChannel1;

    @Autowired
    public CdMessages(@Qualifier("inputChannel1") MessageChannel inputChannel1) {
        this.inputChannel1 = inputChannel1;
    }

    public void sendCdRecords() {
        List<CdRecord> cds = Arrays.asList(
                new CdRecord("Thriller", "Michael Jackson", 1982, 9, "Epic Records"),
                new CdRecord("Back in Black", "AC/DC", 1980, 10, "Atlantic Records"),
                new CdRecord("Hotel California", "Eagles", 1976, 8, "Asylum Records")
        );

        inputChannel1.send(MessageBuilder.withPayload(cds).build());
    }
}
