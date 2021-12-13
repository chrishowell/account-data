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

    @Get("/capabilities/sms-fe")
    public Mono<List<String>> migratedAccounts() {
        return idsFromAccounts(accountsDatabase::accountsWithSmsFeEnabled);
    }

}
