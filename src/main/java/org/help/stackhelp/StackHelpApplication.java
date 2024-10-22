package org.help.stackhelp;

import org.help.stackhelp.service.messages.CdMessages;
import org.help.stackhelp.service.messages.VinylMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StackHelpApplication implements CommandLineRunner {

    @Autowired
    private CdMessages cdMessages;

    @Autowired
    private VinylMessages cdMessages2;

    public static void main(String[] args) {
        SpringApplication.run(StackHelpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cdMessages.sendCdRecords();
        cdMessages2.sendCdRecords();
    }
}
