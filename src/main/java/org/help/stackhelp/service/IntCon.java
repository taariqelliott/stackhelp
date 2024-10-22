package org.help.stackhelp.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;

@Configuration
public class IntCon {

    @Bean
    public MessageChannel inputChannel1() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel inputChannel2() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public IntegrationFlow cdArchiveFlow1() {
        return IntegrationFlow
                .from("inputChannel1")
                .handle((payload, headers) -> {
                    List<CdRecord> cds = (List<CdRecord>) payload;
                    return MessageBuilder.withPayload(cds)
                            .setHeader("processedFormat", true)
                            .setHeader("correlationCD", true)
                            .copyHeaders(headers)
                            .build();
                })
                .channel("outputChannel")
                .get();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public IntegrationFlow cdArchiveFlow2() {
        return IntegrationFlow
                .from("inputChannel2")
                .handle((payload, headers) -> {
                    List<CdRecord> cds = (List<CdRecord>) payload;
                    return MessageBuilder.withPayload(cds)
                            .setHeader("processedFormat", true)
                            .setHeader("correlationCD", true)
                            .copyHeaders(headers)
                            .build();
                })
                .channel("outputChannel")
                .get();
    }

    @SuppressWarnings("unchecked")
    @Bean
    public IntegrationFlow outputFlow() {
        return IntegrationFlow
                .from("outputChannel")
                .aggregate(aggregatorSpec -> aggregatorSpec
                        .correlationStrategy(group -> group.getHeaders().get("processedFormat"))
                        .releaseStrategy(group -> group.size() > 1)
                )
                // Flatten the lists from both channels into a single list
                .handle((payload, headers) -> {
                    // Flatten the payload if it's a list of lists
                    List<?> flattenedList = ((List<?>) payload).stream()
                            .flatMap(item -> ((List<?>) item).stream())
                            .toList();
                    System.out.println("the flattened payload is " + flattenedList);
                    return null;
                })
                .get();
    }
}