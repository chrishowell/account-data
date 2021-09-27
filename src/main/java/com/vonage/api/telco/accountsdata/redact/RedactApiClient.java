package com.vonage.api.telco.accountsdata.redact;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

import java.util.List;


@Client("${redact.api.baseUrl}")
public interface RedactApiClient {

    @Get("/v1/anon/settings?anon_enabled=true&anon_product=SMS")
    Publisher<List<RedactRecord>> accountsWithSmsRedaction();

    record RedactRecord(@JsonProperty("api_key") String apiKey) {}

}
