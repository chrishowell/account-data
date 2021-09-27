package com.vonage.api.telco.accountsdata.capabilities;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
public class SmppController implements AccountsController {

    private final AccountsDatabase accountsDatabase;

    @Get("/smpp/enabled")
    public Mono<List<String>> accountRandomPoolsAccounts() {
        return idsFromAccounts(accountsDatabase::accountsWithSmppEnabled);
    }

}
