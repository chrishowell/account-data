package com.vonage.api.telco.dashboarddata.capabilities;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

@Controller
@RequiredArgsConstructor
public class AccountBillingController {

    private final DashboardDatabase dashboardDatabase;

    @Get("/billing/prepaid")
    public Mono<List<String>> prepaidAccounts() {
        return idsFromAccounts(dashboardDatabase::prepaidAccounts);
    }

    private Mono<List<String>> idsFromAccounts(Supplier<List<DashboardAccountBilling>> accountBillingSupplier) {
        return Mono.fromSupplier(accountBillingSupplier)
                   .map(accounts -> accounts.stream()
                                            .map(DashboardAccountBilling::getAccountRef)
                                            .collect(toList()));
    }
}
