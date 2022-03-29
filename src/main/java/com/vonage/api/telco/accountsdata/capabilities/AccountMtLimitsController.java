package com.vonage.api.telco.accountsdata.capabilities;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Controller
@RequiredArgsConstructor
public class AccountMtLimitsController implements AccountsController {

    private final RealTimeAccountsDatabase accountsDatabase;

    @Post("/accounts/mt-limits")
    public Map<String, Long> accountMtLimits(List<String> sysIds) {
        return accountsDatabase.accountMtLimitsFor(sysIds)
                               .stream()
                               .collect(toMap(AccountWithMtLimit::getSysId, AccountWithMtLimit::getMaxMt));
    }

}
