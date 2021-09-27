package com.vonage.api.telco.accountsdata.redact;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
public class RedactController {

    private final RedactApiClient redactApiClient;

    @Get("/redact/sms")
    public Mono<List<String>> redactedSmsAccounts() {
        return Mono.from(redactApiClient.accountsWithSmsRedaction())
                   .map(records -> records.stream()
                                          .map(RedactApiClient.RedactRecord::apiKey)
                                          .collect(toList()));
    }

}
