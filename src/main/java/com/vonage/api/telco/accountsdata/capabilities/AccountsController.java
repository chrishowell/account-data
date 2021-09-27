package com.vonage.api.telco.accountsdata.capabilities;

import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public interface AccountsController {
    default Mono<List<String>> idsFromAccounts(Supplier<List<Account>> accountsSupplier) {
        return Mono.fromSupplier(accountsSupplier)
                   .map(accounts -> accounts.stream()
                                            .map(Account::getSysId)
                                            .collect(toList()));
    }
}
