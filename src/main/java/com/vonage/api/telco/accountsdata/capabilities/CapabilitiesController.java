package com.vonage.api.telco.accountsdata.capabilities;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CapabilitiesController implements AccountsController {

    private final RealTimeAccountsDatabase accountsDatabase;

    @Get("/capabilities/account-random-pools")
    public Mono<List<String>> accountRandomPoolsAccounts() {
        return idsFromAccounts(accountsDatabase::accountsWithAccountRandomPools);
    }

    @Get("/capabilities/submission-control-queues")
    public Mono<List<String>> submissionControlQueuesAccounts() {
        return idsFromAccounts(accountsDatabase::accountsWithSubmissionControlEnabled);
    }

    @Get("/capabilities/disable-per-sender-throttle")
    public Mono<List<String>> disablePerSenderThrottleAccounts() {
        return idsFromAccounts(accountsDatabase::accountsWithDisablePerSenderThrottle);
    }

    @Get("/capabilities/sms-use-sms-legacy")
    public Mono<List<String>> legacyAccounts() {
        return idsFromAccounts(accountsDatabase::accountsWithSmsLegacyEnabled);
    }

}
