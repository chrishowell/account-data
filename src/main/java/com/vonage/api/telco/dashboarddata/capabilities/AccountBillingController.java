package com.vonage.api.telco.dashboarddata.capabilities;

import com.vonage.api.telco.accountsdata.capabilities.Account;
import com.vonage.api.telco.accountsdata.capabilities.AccountsDatabase;
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
    private final AccountsDatabase accountsDatabase;

    @Get("/billing/prepaid")
    public Mono<List<String>> prepaidAccounts() {
        return Mono.fromSupplier(() -> dashboardDatabase.prepaidAccounts()
                                                        .stream()
                                                        .map(DashboardAccountBilling::getAccountRef)
                                                        .flatMap(accountRef -> accountsDatabase.quotaAccountsFor(accountRef)
                                                                                               .stream()
                                                                                               .map(Account::getSysId))
                                                        .collect(toList()));

    }
}
